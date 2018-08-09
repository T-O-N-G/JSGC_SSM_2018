package service.com.jsgc.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import mapper.com.jsgc.admin.UserMapper;
import mapper.com.jsgc.admin.VerifyMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.admin.User;
import pojo.com.jsgc.admin.Verify;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;
import service.com.jsgc.common.NotificationService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class VerifyService {

    @Resource
    private VerifyMapper verifyMapper;

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private NotificationService notificationService;

    @Autowired
    private JedisPool jedisPool;

    public int addVerify(Verify verify) {
//        Verify verify = JSON.parseObject(param, new TypeReference<Verify>() {
//        });
        Jedis jedis = jedisPool.getResource();
        Set<String> userIDs = jedis.zrange("User:Admin:Default", 0, -1);
        Project project = projectMapper.selectByPrimaryKey(verify.getProjectID());

        for (String userID:userIDs
             ) {
            notificationService.addNotification(userID,project.getProjectName()+"申请增加预算","新的待审核项目");
        }
        return verifyMapper.addVerify(verify);
    }

    public int deleteByPrimaryKey(Integer verifyID) {
        return verifyMapper.deleteByPrimaryKey(verifyID);
    }

    public int passByPrimaryKey(Integer verifyID) {
        Verify verify = verifyMapper.selectByKey(verifyID);
        Project project = projectMapper.selectByPrimaryKey(verify.getProjectID());
        project.setProjectBudgetSum(project.getProjectBudgetSum()+verify.getApplyMoney());
        projectMapper.updateByPrimaryKeySelective(project);
        String message = project.getProjectName()+"的预算增加申请已通过";
        notificationService.addNotification(String.valueOf(project.getProjectChargerId()),message,"预算申请已通过");
        return verifyMapper.deleteByPrimaryKey(verifyID);
    }

    public String selectAll(){
        List<Verify> result = verifyMapper.selectAll();
        return JSON.toJSONString(result);
    }



}
