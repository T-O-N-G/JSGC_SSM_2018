package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BuyMethod;

public interface BuyMethodMapper {
    int deleteByPrimaryKey(String buyMethodId);

    int insert(BuyMethod record);

    int insertSelective(BuyMethod record);

    BuyMethod selectByPrimaryKey(String buyMethodId);

    int updateByPrimaryKeySelective(BuyMethod record);

    int updateByPrimaryKey(BuyMethod record);
}