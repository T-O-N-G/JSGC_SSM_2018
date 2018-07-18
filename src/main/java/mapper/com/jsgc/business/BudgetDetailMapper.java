package mapper.com.jsgc.business;


import pojo.com.jsgc.business.BudgetDetail;

public interface BudgetDetailMapper {
    int deleteByPrimaryKey(Integer budgetid);

    int insert(BudgetDetail record);

    int insertSelective(BudgetDetail record);

    BudgetDetail selectByPrimaryKey(Integer budgetid);

    int updateByPrimaryKeySelective(BudgetDetail record);

    int updateByPrimaryKey(BudgetDetail record);
}