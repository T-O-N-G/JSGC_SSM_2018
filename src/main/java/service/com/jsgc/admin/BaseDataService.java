package service.com.jsgc.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import mapper.com.jsgc.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.admin.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BaseDataService {
    @Resource
    private VersionMapper versionMapper;
    @Resource
    private BudgetReplyMapper budgetReplyMapper;
    @Resource
    private BuyMethodMapper buyMethodMapper;
    @Resource
    private BuyTypeMapper buyTypeMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private PayMethodMapper payMethodMapper;
    @Resource
    private BuildContentMapper buildContentMapper;
    @Resource
    private BuyOrgFormMapper buyOrgFormMapper;
    @Resource
    private AccountantMapper accountantMapper;

    @Autowired
    public JedisPool jedisPool;

    public String getBaseDataByVersion(String versionId) {
        List<BudgetReply> budgetReplies = budgetReplyMapper.selectByVersionID(versionId);
        List<BuyMethod> buyMethods = buyMethodMapper.selectByVersionID(versionId);
        List<BuyType> buyTypes = buyTypeMapper.selectByVersionID(versionId);
        List<Department> departments = departmentMapper.selectByVersionID(versionId);
        List<PayMethod> payMethods = payMethodMapper.selectByVersionID(versionId);
        List<BuyOrgForm> buyOrgForms = buyOrgFormMapper.selectByVersionID(versionId);
        List<BuildContent> buildContents = buildContentMapper.selectByVersionID(versionId);
        List<Accountant> borrowTypes = accountantMapper.selectBorrowTypeByVersionID(versionId);
        List<Accountant> lendTypes = accountantMapper.selectLendTypeByVersionID(versionId);


        HashMap<String, List> result = new HashMap<>();
        result.put("budgetReplies", budgetReplies);
        result.put("buyMethods", buyMethods);
        result.put("buyTypes", buyTypes);
        result.put("departments", departments);
        result.put("payMethods", payMethods);
        result.put("buildContents", buildContents);
        result.put("buyOrgForms", buyOrgForms);
        result.put("borrowTypes", borrowTypes);
        result.put("lendTypes", lendTypes);
        return JSON.toJSONString(result);
    }

    public String getVersionList() {
        List<Version> versions = versionMapper.selectAll();
        return JSON.toJSONString(versions);
    }


    public String getBaseDate(String baseDataType) {
        String key = baseDataType + ":list";
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }


    public int getNewVersionID(String versionBuildNum) {
        Version version = new Version();
        version.setVersionBuildNum(versionBuildNum);
        version.setVersionDate(new Date());
        versionMapper.insertSelective(version);
        version = versionMapper.selectByVersionName(versionBuildNum);
        return version.getVerisionId();
    }

    public String updateNewVersion(String param) {
        JSONObject jsonObject = JSON.parseObject(param);
        String versionBuildNum = jsonObject.getString("versionBuildNum");
//        int versionID = getNewVersionID(versionBuildNum);
        HashMap<String, String> newVersionData = new HashMap<>();
//        List<HashMap> newVersionDataList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("Department");
        int size = jsonArray.size();
//        for (int i = 0; i < size; i++) {
////            String s = String.valueOf(jsonArray.getJSONObject(i));
////            System.out.println(s);
////            Department department = new Department();
////            department.setDepartmentName(jsonObject.getString("studentName"));
////            System.out.println(jsonObject.getString("studentName") + ":" + jsonObject.getInteger("studentAge"));
//        }


        return "";
    }
}

