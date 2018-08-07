package service.com.jsgc.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import mapper.com.jsgc.admin.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.admin.Permission;
import pojo.com.jsgc.business.Document;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;


    public int updatePermission(String param) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        int level = Integer.parseInt(jsonObject.getString("level"));
        List<HashMap> permissions;
        permissions = JSONArray.parseArray(jsonObject.getString("permissions"), HashMap.class);
//        for (String permission:permissions
//             ) {
//            System.out.println(permission);
//        }
        permissionMapper.deleteByLevel(level);
        permissionMapper.insertByLevelAll(permissions);
        return 1;
    }

    public String searchByLevel(Integer level) {
        List<Permission>   permissions = permissionMapper.searchByLevel(level);
        return JSON.toJSONString(permissions);
    }
}
