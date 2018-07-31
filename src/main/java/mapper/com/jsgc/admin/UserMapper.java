package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.User;
import util.com.jsgc.searchCondition.UserSearchConditions;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User selectByEmail(String email);

    List<User> selectAll(UserSearchConditions ps);

    int deleteFakeByPrimaryKey(int userID);

    int getUidbyUname(String uname);
}