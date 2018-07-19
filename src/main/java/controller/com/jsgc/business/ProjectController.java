package controller.com.jsgc.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Project;
import service.com.jsgc.business.ProjectService;
import util.com.jsgc.RequestPage;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/business/project/")
public class ProjectController {
    @Resource
    private ProjectService projectService;
    @RequestMapping("getProjectList")
    @ResponseBody
    public List<Project> searchByConditons(RequestPage rp, ProjectSearchConditions psc){
      return   projectService.searchByConditions(rp,psc);
    }


    @RequestMapping("getProjectDetail")
    @ResponseBody
    public String getProjectDetail(int projectID){
        return   projectService.getProjectDetail(projectID);
    }

    @RequestMapping("updateProjectDetail")
    @ResponseBody
    public int updateProjectDetail(Project project){
        return   projectService.updateProjectDetail(project);
    }

    @RequestMapping("addProject")
    @ResponseBody
    public int addProject(Project project){
        return   projectService.insertProject(project);
    }

    @RequestMapping("deleteProject")
    @ResponseBody
    public int deleteProject(int projectID){
        return   projectService.deleteProject(projectID);
    }


}
