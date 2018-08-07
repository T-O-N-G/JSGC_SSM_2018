package controller.com.jsgc.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.admin.PermissionService;

import javax.annotation.Resource;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("/updatePermission")
    @ResponseBody
    public int updatePermission(@RequestBody String param){
        return  permissionService.updatePermission(param);
    }

    @RequestMapping("/getPermissionList")
    @ResponseBody
    public String getPermissionList(Integer level){
        return  permissionService.searchByLevel(level);
    }
}
