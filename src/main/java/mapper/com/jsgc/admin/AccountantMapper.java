package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.Accountant;

public interface AccountantMapper {
    int deleteByPrimaryKey(Integer accountantid);

    int insert(Accountant record);

    int insertSelective(Accountant record);

    Accountant selectByPrimaryKey(Integer accountantid);

    int updateByPrimaryKeySelective(Accountant record);

    int updateByPrimaryKey(Accountant record);
}