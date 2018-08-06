package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.BudgetReply;
import pojo.com.jsgc.admin.BuildContent;

import java.util.List;

public interface BuildContentMapper {
    int deleteByPrimaryKey(String buildContentId);

    int insert(BuildContent record);

    int insertSelective(BuildContent record);

    BuildContent selectByPrimaryKey(String buildContentId);

    int updateByPrimaryKeySelective(BuildContent record);

    int updateByPrimaryKey(BuildContent record);
    public List<String> getBuildContentSerials();

    List<BuildContent> selectByVersionID(String versionId);
}