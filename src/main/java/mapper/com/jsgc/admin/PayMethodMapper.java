package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(Integer payMethodId);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(Integer payMethodId);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);
}