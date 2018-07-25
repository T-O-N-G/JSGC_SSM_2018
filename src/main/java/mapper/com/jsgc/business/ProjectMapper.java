package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Project;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectId);

    int deleteFakeByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    int getProjectIDBySerial(String projectSerial);
    List<String> getSerials();
    //分页测试
    List<Project> selectAll();
}