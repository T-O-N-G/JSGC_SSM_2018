package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BuyType;

public interface BuyTypeMapper {
    int deleteByPrimaryKey(String buyTypeId);

    int insert(BuyType record);

    int insertSelective(BuyType record);

    BuyType selectByPrimaryKey(String buyTypeId);

    int updateByPrimaryKeySelective(BuyType record);

    int updateByPrimaryKey(BuyType record);
}