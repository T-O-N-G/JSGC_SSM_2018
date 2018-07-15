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
import javax.servlet.http.HttpServletResponse;
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
        //每一次获取列表之前都要计算totalCount,以及更新last的值
        int totalCount = categoryService.count();
        page.calculateLast(totalCount);

        List<Category> categoryList = categoryService.list(page.getStart(), page.getCount());
        mav.addObject("cs", categoryList);

        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(HttpServletRequest request) {
//        int id = category.getId();
        int id = Integer.parseInt(request.getParameter("id"));
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));
        Category category = categoryService.getById(id);
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("startIndex", startIndex);
        mav.addObject("category", category);

        return mav;
    }

    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category category, int startIndex) {
        categoryService.update(category);
        return new ModelAndView("redirect:/listCategory?start=" + startIndex);
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(HttpServletRequest request, int startIndex) {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        return new ModelAndView("redirect:/listCategory?start=" + startIndex);
    }

}
