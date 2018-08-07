package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;
import pojo.com.jsgc.admin.BuyType;

import java.util.List;

public interface BuyTypeMapper {
    int deleteByPrimaryKey(String buyTypeId);

    int insert(BuyType record);

    int insertSelective(BuyType record);

    BuyType selectByPrimaryKey(String buyTypeId);

    int updateByPrimaryKeySelective(BuyType record);

    int updateByPrimaryKey(BuyType record);
    public List<String> getBuyTypeSerials();

    List<BuyType> selectByVersionID(String versionId);
}