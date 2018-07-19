package controller.com.jsgc.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Asset;
import service.com.jsgc.business.AssetService;
import javax.annotation.Resource;

@Controller
@RequestMapping("/bussiness/asset/")
public class AssetController {
    @Resource
    private AssetService assetService;

    @RequestMapping("getAssetDetail")
    @ResponseBody
    public String getAssetDetail(int assetID){
        return assetService.getAssetDetail(assetID);
    }

    @RequestMapping("updateAssetDetial")
    @ResponseBody
    public int updateAssetDetial(Asset asset){
        return  assetService.updateAssetDetail(asset);
    }
}
