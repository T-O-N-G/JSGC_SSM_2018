package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(Integer paymethodid);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(Integer paymethodid);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);
}