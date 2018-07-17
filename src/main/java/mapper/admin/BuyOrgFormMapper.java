package mapper.admin;


import pojo.com.jsxm.admin.BuyOrgForm;

public interface BuyOrgFormMapper {
    int deleteByPrimaryKey(Integer buyorgformid);

    int insert(BuyOrgForm record);

    int insertSelective(BuyOrgForm record);

    BuyOrgForm selectByPrimaryKey(Integer buyorgformid);

    int updateByPrimaryKeySelective(BuyOrgForm record);

    int updateByPrimaryKey(BuyOrgForm record);
}