package service.com.jsgc.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.admin.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.admin.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.searchCondition.UserSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    public JedisPool jedisPool;//注入JedisPool

    public String searchByConditions(UserSearchConditions ps) {

        System.out.println(ps.getStart()+" "+ps.getLimit());

        Page page= PageHelper.startPage(ps.getPage(),ps.getLimit(),true);
        List<User> projects=userMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<User> pageInfo=new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",projects);

        return JSON.toJSONString(map);
    }

    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    public int deleteUser(int userID) {
        return userMapper.deleteFakeByPrimaryKey(userID);
    }

    public int updateUserDetail(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public String getUserDetail(Integer userId) {
        Jedis jedis = jedisPool.getResource();
        String key = "User:ID:"+userId;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }
    public int getUidbyUname(String name){return userMapper.getUidbyUname(name);}
}
