package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Finance;
import util.com.jsgc.searchCondition.FinanceSearchConditions;

import java.util.List;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer financeId);

    int deleteFakeByPrimaryKey(Integer financeId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeId);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);

    List<Finance> selectAll();

    List<Finance> selectByConditions(FinanceSearchConditions fs);

    int ifSerialExistAdd(String financeSerial);

    int ifSerialExistUpdt(Finance finance);

}