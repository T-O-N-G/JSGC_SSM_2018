package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.AssetMapper;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.DocumentMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Asset;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Document;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.UpdateCache;
import util.com.jsgc.searchCondition.DocumentSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class DocumentService {
    @Resource
    private DocumentMapper documentMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private ContractMapper contractMapper;

    //    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool
    @Autowired
    public JedisPool jedisPool;//注入JedisPool


    public String getDocumentDetail(int documentID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Document:ID:" + documentID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateDocumentDetail(Document document) {

        try {
            if (documentMapper.ifSerialExistUpdt(document) != 0) {
                return 99;
            }

            //下面这句会抛出异常
            String contractSerial = document.getContractSerial();
            //属于合同
            if (!(contractSerial == null || contractSerial.equals(""))) {
                int contractId = contractMapper.getContractIDBySerial(contractSerial);
                document.setContractId(contractId);
                Contract contract = contractMapper.selectByPrimaryKey(contractId);
                int projectIdByContract = contract.getProjectId();
                Project project = projectMapper.selectByPrimaryKey(projectIdByContract);
                String projectSerialByContract = project.getProjectSerial();
                String projectSerialByInput = document.getProjectSerial();
                if (!(projectSerialByContract.equals(projectSerialByInput))) {
                    return 88;
                } else {
                    document.setProjectId(projectIdByContract);
                    int successNum = documentMapper.updateByPrimaryKeySelective(document);
                    UpdateCache.updateCache("updateDocument");

                    return successNum;
                }
            } else {
                int projectId = projectMapper.getProjectIDBySerial(document.getProjectSerial());
                document.setProjectId(projectId);
                document.setContractId(-1);
//                document.setContractSerial(null);
//                document.setContractName(null);
                int successNum = documentMapper.updateByPrimaryKeySelective(document);
                UpdateCache.updateCache("updateDocument");

                return successNum;
            }

        } catch (org.apache.ibatis.binding.BindingException e) {
            System.out.println("项目编号不存在");
            return 100;
        }
    }

    public int insertDocument(Document document) {
        int result = documentMapper.insertSelective(document);
        UpdateCache.updateCache("updateDocument");
        return result;

    }

    public int deleteDocument(int documentID) {
        int result = documentMapper.deleteFakeByPrimaryKey(documentID);
        UpdateCache.updateCache("updateDocument");
        return result;
    }

    public String searchByConditions(DocumentSearchConditions ps) {
        Page page = PageHelper.startPage(ps.getPage(), ps.getLimit(), true);
        List<Document> projects = documentMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Document> pageInfo = new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map = new HashMap();
        map.put("total", page.getTotal());
        map.put("data", projects);

        return JSON.toJSONString(map);
    }

    public int ifSerialExistAdd(String serial) {
        return documentMapper.ifSerialExistAdd(serial);
    }
}
