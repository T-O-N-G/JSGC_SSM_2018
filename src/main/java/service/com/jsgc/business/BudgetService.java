package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.BudgetDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.BudgetDetail;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.searchCondition.BudgetSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class BudgetService{

        @Resource
        BudgetDetailMapper budgetDetailMapper;

    @Autowired
    private JedisPool jedisPool;//注入JedisPool
    public String searchByConditions(BudgetSearchConditions ps) {



        System.out.println(ps.getStart()+" "+ps.getLimit());

        Page page= PageHelper.startPage(ps.getPage(),ps.getLimit(),true);
        List<BudgetDetail> projects=budgetDetailMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<BudgetDetail> pageInfo=new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",projects);

        return JSON.toJSONString(map);
    }

    public String getBudgetDetail(int budgetID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Budget:ID:"+budgetID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }
}
