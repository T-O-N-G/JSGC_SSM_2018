package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Project;
import service.com.jsgc.admin.UserService;
import service.com.jsgc.business.ProjectService;
//import util.com.jsgc.RequestPage;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/business/project/")

//@RequestMapping("/business/project/")

@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class ProjectController {
    @Resource
    private ProjectService projectService;
    @Resource
    private UserService userService;

    @RequestMapping("/getProjectList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        ProjectSearchConditions ps = JSON.parseObject(params, new TypeReference<ProjectSearchConditions>() {
        });
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return projectService.searchByConditions(ps);

    }


    @RequestMapping("getProjectDetail")
    @ResponseBody
    public String getProjectDetail(int projectID) {
        // Project project = JSON.parseObject(params , new TypeReference<Project>() {});
        return projectService.getProjectDetail(projectID);
    }

    @RequestMapping("updateProjectDetail")
    @ResponseBody
    public int updateProjectDetail(@RequestBody String params, HttpServletRequest request) {
        Project project = JSON.parseObject(params, new TypeReference<Project>() {
        });
        try {
            if (projectService.ifSerialExistUpdt(project) != 0)
                return 99;
            //下面这句会抛出异常
            int chargerId = userService.getUidbyUname(project.getUsername());
            project.setProjectChargerId(chargerId);
            int successNum = projectService.updateProjectDetail(project);
            return successNum;
        } catch (org.apache.ibatis.binding.BindingException e) {
            System.out.println("负责人id不存在");
            return 100;
        }
    }

    @RequestMapping("addProject")
    @ResponseBody
    public int addProject(@RequestBody String params) {
        Project project = JSON.parseObject(params, new TypeReference<Project>() {
        });
        try {
            if (projectService.ifSerialExistAdd(project.getProjectSerial()) != 0)
                return 99;
            int chargerId = userService.getUidbyUname(project.getUsername());
            project.setProjectChargerId(chargerId);
            return projectService.insertProject(project);
        } catch (org.apache.ibatis.binding.BindingException e) {
            System.out.println("负责人id不存在");
            return 100;
        }
    }

    @RequestMapping("deleteProject")
    @ResponseBody
    public int deleteProject(int projectID) {

        return projectService.deleteProject(projectID);
    }


}
