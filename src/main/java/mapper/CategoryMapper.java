package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Category;

import java.util.List;

public interface CategoryMapper {

    public int add(Category category);

    public void delete(Category category);

    public int update(Category category);

    public Category getById(int id);

    //为了与动态SQL相匹配,可以通过方法的重载来实现动态SQL中不同条件下的不同情况
    //同时注意用注解@Param的方式给定参数名使得能够正确传入SQL语句中.
    //利用方法的多态性和SQL语句的动态性相匹配.
    public List<Category> list(@Param("start") int start, @Param("count") int count);
    public List<Category> list();

    public int count();
}
