package mapper.admin;


import pojo.com.jsxm.admin.PayMethod;

public interface PayMethodMapper {
    int deleteByPrimaryKey(Integer paymethodid);

    int insert(PayMethod record);

    int insertSelective(PayMethod record);

    PayMethod selectByPrimaryKey(Integer paymethodid);

    int updateByPrimaryKeySelective(PayMethod record);

    int updateByPrimaryKey(PayMethod record);
}