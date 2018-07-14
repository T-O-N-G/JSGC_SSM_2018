package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
import service.CategoryService;
import util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//告诉SpringMVC这是一个控制器类
@Controller
//@RequestMapping(value = "categoryController")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //RequestMapping的value值前面有没有斜杠都没有关系
    @RequestMapping(value = "listCategory" , method = RequestMethod.GET)//默认就是GET
    public ModelAndView listCategory(Page page) {

        ModelAndView mav = new ModelAndView("listCategory");
        int totalCount = categoryService.count();
        page.calculateLast(totalCount);

        List<Category> categoryList = categoryService.list(page.getStart(), page.getCount());
        mav.addObject("cs", categoryList);

        return mav;
    }

}
