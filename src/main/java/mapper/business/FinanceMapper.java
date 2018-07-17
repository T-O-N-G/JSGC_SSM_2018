package mapper.business;


import pojo.com.jsxm.business.Finance;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer financeid);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeid);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}