package mapper.com.jsgc.admin;


import pojo.com.jsgc.admin.BudgetReply;

public interface BudgetReplyMapper {
    int deleteByPrimaryKey(Integer budgetrReplyId);

    int insert(BudgetReply record);

    int insertSelective(BudgetReply record);

    BudgetReply selectByPrimaryKey(Integer budgetReplyId);

    int updateByPrimaryKeySelective(BudgetReply record);

    int updateByPrimaryKey(BudgetReply record);
}