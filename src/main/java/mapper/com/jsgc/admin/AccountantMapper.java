package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.Accountant;

public interface AccountantMapper {
    int deleteByPrimaryKey(String accountantId);

    int insert(Accountant record);

    int insertSelective(Accountant record);

    Accountant selectByPrimaryKey(String accountantId);

    int updateByPrimaryKeySelective(Accountant record);

    int updateByPrimaryKey(Accountant record);
}