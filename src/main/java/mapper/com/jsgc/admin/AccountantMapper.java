package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.Accountant;

public interface AccountantMapper {
    int deleteByPrimaryKey(Integer accountantId);

    int insert(Accountant record);

    int insertSelective(Accountant record);

    Accountant selectByPrimaryKey(Integer accountantId);

    int updateByPrimaryKeySelective(Accountant record);

    int updateByPrimaryKey(Accountant record);
}