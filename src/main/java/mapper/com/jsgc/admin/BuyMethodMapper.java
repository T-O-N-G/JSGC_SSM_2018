package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BuyMethod;

public interface BuyMethodMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(BuyMethod record);

    int insertSelective(BuyMethod record);

    BuyMethod selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(BuyMethod record);

    int updateByPrimaryKey(BuyMethod record);
}