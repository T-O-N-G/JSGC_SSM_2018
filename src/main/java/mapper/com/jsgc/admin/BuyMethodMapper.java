package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.BuyMethod;

public interface BuyMethodMapper {
    int deleteByPrimaryKey(Integer buyMethodId);

    int insert(BuyMethod record);

    int insertSelective(BuyMethod record);

    BuyMethod selectByPrimaryKey(Integer buyMethodId);

    int updateByPrimaryKeySelective(BuyMethod record);

    int updateByPrimaryKey(BuyMethod record);
}