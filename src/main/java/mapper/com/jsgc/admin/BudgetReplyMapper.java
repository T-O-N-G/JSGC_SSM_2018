package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;

public interface BudgetReplyMapper {
    int deleteByPrimaryKey(String budgetReplyId);

    int insert(BudgetReply record);

    int insertSelective(BudgetReply record);

    BudgetReply selectByPrimaryKey(String budgetReplyId);

    int updateByPrimaryKeySelective(BudgetReply record);

    int updateByPrimaryKey(BudgetReply record);
}