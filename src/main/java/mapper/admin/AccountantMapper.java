package mapper.admin;


import pojo.com.jsxm.admin.Accountant;

public interface AccountantMapper {
    int deleteByPrimaryKey(Integer accountantid);

    int insert(Accountant record);

    int insertSelective(Accountant record);

    Accountant selectByPrimaryKey(Integer accountantid);

    int updateByPrimaryKeySelective(Accountant record);

    int updateByPrimaryKey(Accountant record);
}