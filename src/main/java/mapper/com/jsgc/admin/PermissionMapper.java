package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.Permission;

import java.util.HashMap;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);
    int deleteByLevel(Integer level);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    int insertByLevelAll(List<HashMap> permissions);

    List<Permission> searchByLevel(Integer level);
}