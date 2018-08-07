package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;
import pojo.com.jsgc.admin.BuyMethod;

import java.util.List;

public interface BuyMethodMapper {
    int deleteByPrimaryKey(String buyMethodId);

    int insert(BuyMethod record);

    int insertSelective(BuyMethod record);

    BuyMethod selectByPrimaryKey(String buyMethodId);

    int updateByPrimaryKeySelective(BuyMethod record);

    int updateByPrimaryKey(BuyMethod record);
    public List<String> getBuyMethodSerials();

    List<BuyMethod> selectByVersionID(String versionId);
}