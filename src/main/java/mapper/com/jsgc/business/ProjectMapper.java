package mapper.com.jsgc.business;


import pojo.com.jsgc.business.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}