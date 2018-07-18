package mapper.com.jsgc.business;


import pojo.com.jsgc.business.Finance;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer financeid);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeid);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}