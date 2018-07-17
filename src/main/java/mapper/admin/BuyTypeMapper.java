package mapper.admin;


import pojo.com.jsxm.admin.BuyType;

public interface BuyTypeMapper {
    int deleteByPrimaryKey(Integer buytypeid);

    int insert(BuyType record);

    int insertSelective(BuyType record);

    BuyType selectByPrimaryKey(Integer buytypeid);

    int updateByPrimaryKeySelective(BuyType record);

    int updateByPrimaryKey(BuyType record);
}