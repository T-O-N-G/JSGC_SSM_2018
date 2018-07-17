package mapper.admin;


import pojo.com.jsxm.admin.Version;

public interface VersionMapper {
    int deleteByPrimaryKey(Integer verisionid);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Integer verisionid);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}