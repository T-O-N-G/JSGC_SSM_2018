package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.BuildContent;

public interface BuildContentMapper {
    int deleteByPrimaryKey(Integer buildContentId);

    int insert(BuildContent record);

    int insertSelective(BuildContent record);

    BuildContent selectByPrimaryKey(Integer buildContentId);

    int updateByPrimaryKeySelective(BuildContent record);

    int updateByPrimaryKey(BuildContent record);
}