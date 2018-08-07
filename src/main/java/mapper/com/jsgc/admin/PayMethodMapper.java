package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;
import pojo.com.jsgc.admin.PayMethod;

import java.util.List;

public interface PayMethodMapper {
    int deleteByPrimaryKey(String payMethodId);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(String payMethodId);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);
    public List<String> getPayMethodSerials();

    List<PayMethod> selectByVersionID(String versionId);
}