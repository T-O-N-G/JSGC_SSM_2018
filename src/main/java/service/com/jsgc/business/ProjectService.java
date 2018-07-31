package service.com.jsgc.business;

//import mapper.com.jsgc.business.ProjectMapper;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.ProjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
//import util.com.jsgc.RequestPage;
import util.HttpRequestMethod;
import util.PostJson;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    //    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
    @Autowired
    public JedisPool jedisPool;//注入JedisPool

    public String searchByConditions(ProjectSearchConditions ps) {
        System.out.println(ps.getStart() + " " + ps.getLimit());

        Page page = PageHelper.startPage(ps.getPage(), ps.getLimit(), true);
        List<Project> projects = projectMapper.selectByConditions(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Project> pageInfo = new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map = new HashMap();
        map.put("total", page.getTotal());
        map.put("data", projects);
        return JSON.toJSONString(map);

    }

    public String getProjectDetail(int projectID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Project:ID:" + projectID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }


    public int updateProjectDetail(Project project, HttpServletRequest request) {
        Project project2 = projectMapper.selectByPrimaryKey(project.getProjectId());

        int result = projectMapper.updateByPrimaryKeySelective(project);
//        Jedis jedis = jedisPool.getResource();
//        String key = "Project:ID:" + project.getProjectId();
//        jedis.set(key, JSON.toJSONString(project));
        if(project2.getProjectSerial().equals(project.getProjectSerial())){
            String url = "http://127.0.0.1:8002/updateProjectDetail";
            String param = "projectID=" + project.getProjectId();
            HttpRequestMethod.sendGet(url, param);
        }else {
            String url = "http://127.0.0.1:8002/updateProjectDetailWithSerial";
            String param = "projectID=" + project.getProjectId();
            HttpRequestMethod.sendGet(url, param);
        }
        return result;
    }

    public int insertProject(Project project) {
        return projectMapper.insertSelective(project);
    }

    public int deleteProject(int projectID) {
        return projectMapper.deleteFakeByPrimaryKey(projectID);
    }

    public List<String> getSerials() {
        return projectMapper.getSerials();
    }

    public int getProjectIDBySerial(String projectSerial) {
        return projectMapper.getProjectIDBySerial(projectSerial);
    }
    public int ifSerialExistAdd(String projectSerial){return projectMapper.ifSerialExistAdd(projectSerial);}
    public int ifSerialExistUpdt(Project project){return projectMapper.ifSerialExistUpdt(project);}


}
