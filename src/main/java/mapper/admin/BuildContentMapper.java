package mapper.admin;


import pojo.com.jsxm.admin.BuildContent;

public interface BuildContentMapper {
    int deleteByPrimaryKey(Integer buildcontentid);

    int insert(BuildContent record);

    int insertSelective(BuildContent record);

    BuildContent selectByPrimaryKey(Integer buildcontentid);

    int updateByPrimaryKeySelective(BuildContent record);

    int updateByPrimaryKey(BuildContent record);
}