package mapper.com.jsgc.business;

import pojo.com.jsgc.business.BudgetDetail;
import util.com.jsgc.searchCondition.BudgetSearchConditions;

import java.util.List;

public interface BudgetDetailMapper {
    int deleteByPrimaryKey(Integer budgetId);

    int insert(BudgetDetail record);

    int insertSelective(BudgetDetail record);

    BudgetDetail selectByPrimaryKey(Integer budgetId);

    int updateByPrimaryKeySelective(BudgetDetail record);

    int updateByPrimaryKey(BudgetDetail record);
    BudgetDetail selectByProjectID(Integer projectID);
    List<BudgetDetail> selectAll(BudgetSearchConditions ps);
}