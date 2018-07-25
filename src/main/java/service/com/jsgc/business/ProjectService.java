package service.com.jsgc.business;

//import mapper.com.jsgc.business.ProjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public List<Project> searchByConditions(ProjectSearchConditions ps){
//        projectMapper.searchByConditions();
        Page page= PageHelper.startPage(ps.getStart(),ps.getLimit(),true);
        List<Project> projects=projectMapper.selectAll();
        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        System.out.println(projects);
        return projects;
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
        return projectMapper.deleteFakeByPrimaryKey(projectID);
    }

    public List<String> getSerials(){
        return  projectMapper.getSerials();
    }

    public int getProjectIDBySerial(String projectSerial){
        return projectMapper.getProjectIDBySerial(projectSerial);
    }
}
