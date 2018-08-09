package controller.com.jsgc.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.com.jsgc.admin.Verify;
import service.com.jsgc.admin.VerifyService;

import javax.annotation.Resource;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class VerifyController {

    @Resource
    private VerifyService verifyService;

    @RequestMapping("/addVerify")
    @ResponseBody
    public int addVerify(Verify verify) {

        return verifyService.addVerify(verify);
    }

    @RequestMapping("/getVerifyList")
    @ResponseBody
    public String  getVerifyList(@RequestBody String param) {
        return verifyService.selectAll();
    }

    @RequestMapping("/passVerify")
    @ResponseBody
    public int  passVerify(Integer verifyID) {
        return verifyService.passByPrimaryKey(verifyID);
    }

    @RequestMapping("/delVerify")
    @ResponseBody
    public int  delVerify(Integer verifyID) {
        return verifyService.deleteByPrimaryKey(verifyID);
    }
}
