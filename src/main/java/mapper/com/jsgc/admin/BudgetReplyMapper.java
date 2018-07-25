package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;

import java.util.List;

public interface BudgetReplyMapper {
    int deleteByPrimaryKey(String budgetReplyId);

    int insert(BudgetReply record);

    int insertSelective(BudgetReply record);

    BudgetReply selectByPrimaryKey(String budgetReplyId);

    int updateByPrimaryKeySelective(BudgetReply record);

    int updateByPrimaryKey(BudgetReply record);

    public List<String> getBudgetReplySerials();
}