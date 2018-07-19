package mapper.com.jsgc.business;

import pojo.com.jsgc.business.BudgetDetail;

public interface BudgetDetailMapper {
    int deleteByPrimaryKey(Integer budgetId);

    int insert(BudgetDetail record);

    int insertSelective(BudgetDetail record);

    BudgetDetail selectByPrimaryKey(Integer budgetId);

    int updateByPrimaryKeySelective(BudgetDetail record);

    int updateByPrimaryKey(BudgetDetail record);
}