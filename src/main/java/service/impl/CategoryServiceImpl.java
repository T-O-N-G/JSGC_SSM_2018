package service.impl;

import mapper.CategoryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Category;
import service.CategoryService;

import java.util.List;
//CategoryServiceImpl被注解@Service标示为一个Service
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public void delete(Category category) {
        categoryMapper.delete(category);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public Category getById(int id) {
        return categoryMapper.getById(id);
    }

    @Override
    public List<Category> list(int start, int count) {
        return categoryMapper.list(start, count);
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }
}
