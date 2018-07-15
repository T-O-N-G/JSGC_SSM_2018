package service;

import org.apache.ibatis.annotations.Param;
import pojo.Category;

import java.util.List;

public interface CategoryService {
    public int add(Category category);

    public void delete(Category category);

    public void delete(int id);

    public void deleteAll();

    public int update(Category category);

    public Category getById(int id);

    public List<Category> list(int start,int count);
    public List<Category> list();

    public int count();
}
