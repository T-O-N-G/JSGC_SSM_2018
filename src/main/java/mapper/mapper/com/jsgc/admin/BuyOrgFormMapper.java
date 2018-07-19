package mapper.mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BuyOrgForm;

public interface BuyOrgFormMapper {
    int deleteByPrimaryKey(String buyOrgFormId);

    int insert(BuyOrgForm record);

    int insertSelective(BuyOrgForm record);

    BuyOrgForm selectByPrimaryKey(String buyOrgFormId);

    int updateByPrimaryKeySelective(BuyOrgForm record);

    int updateByPrimaryKey(BuyOrgForm record);
}