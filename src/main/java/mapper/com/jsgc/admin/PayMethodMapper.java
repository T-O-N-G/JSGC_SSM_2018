package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(String payMethodId);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(String payMethodId);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);
}