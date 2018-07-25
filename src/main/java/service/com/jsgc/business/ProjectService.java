package service.com.jsgc.business;

//import mapper.com.jsgc.business.ProjectMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.RequestPage;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Resource
    private ProjectMapper projectMapper;

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
@Autowired
    public JedisPool jedisPool;//注入JedisPool

    public List<Project> searchByConditions(RequestPage rp, ProjectSearchConditions psc){
//        projectMapper.searchByConditions();
        List<Project> ls=new ArrayList<Project>();
        Project a=new Project();
        Project b=new Project();
        ls.add(a);
        ls.add(b);
        return(ls);
    }

    public String getProjectDetail(int projectID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Project:ID:"+projectID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateProjectDetail(Project project) {
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    public int insertProject(Project project){
        return projectMapper.insertSelective(project);
    }

    public int deleteProject(int projectID){
        return projectMapper.deleteByPrimaryKey(projectID);
    }
}
