package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Finance;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer financeId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeId);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}