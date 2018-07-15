package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Category;
import service.CategoryService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringApplicationContext.xml")
public class MybatisTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void deleteAll(){
        categoryService.deleteAll();
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 12; i++) {
            Category category = new Category("类目" + i);
//            category.setName("类目" + i);
            categoryService.add(category);
        }

    }

    @Test
    public void testList() {
        System.out.println(categoryService);
        List<Category> cs= categoryService.list();
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }

    @Test
    public void testTransaction() {
        categoryService.deleteAll();
        categoryService.addTwo();
    }
}