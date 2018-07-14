package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
import service.CategoryService;

import java.util.List;

//告诉SpringMVC这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("listCategory")
    public ModelAndView listCategory() {
        ModelAndView mav = new ModelAndView("listCategory");
        List<Category> categoryList = categoryService.list();
        mav.addObject("cs", categoryList);
        return mav;
    }

}
