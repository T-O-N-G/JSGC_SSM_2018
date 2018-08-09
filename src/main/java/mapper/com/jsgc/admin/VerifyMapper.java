package mapper.com.jsgc.admin;

import pojo.com.jsgc.admin.Verify;

import java.util.List;

public interface VerifyMapper {
    int addVerify(Verify verify);
    List<Verify> selectAll();
    int passByPrimaryKey(Integer verifyID);
    int deleteByPrimaryKey(Integer verifyID);
    Verify selectByKey(Integer verifyID);
}
