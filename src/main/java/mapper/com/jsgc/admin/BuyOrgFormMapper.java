package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BuyOrgForm;

public interface BuyOrgFormMapper {
    int deleteByPrimaryKey(Integer buyOrgFormId);

    int insert(BuyOrgForm record);

    int insertSelective(BuyOrgForm record);

    BuyOrgForm selectByPrimaryKey(Integer buyOrgFormId);

    int updateByPrimaryKeySelective(BuyOrgForm record);

    int updateByPrimaryKey(BuyOrgForm record);
}