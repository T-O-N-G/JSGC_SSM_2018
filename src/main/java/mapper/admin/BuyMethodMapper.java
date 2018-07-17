package mapper.admin;


import pojo.com.jsxm.admin.BuyMethod;

public interface BuyMethodMapper {
    int deleteByPrimaryKey(Integer buymethodid);

    int insert(BuyMethod record);

    int insertSelective(BuyMethod record);

    BuyMethod selectByPrimaryKey(Integer buymethodid);

    int updateByPrimaryKeySelective(BuyMethod record);

    int updateByPrimaryKey(BuyMethod record);
}