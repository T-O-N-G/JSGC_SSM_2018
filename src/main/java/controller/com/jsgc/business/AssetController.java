package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Asset;
import service.com.jsgc.business.AssetService;
import javax.annotation.Resource;

@Controller
//@RequestMapping("/bussiness/asset/")
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
    public int updateAssetDetial(@RequestBody String params){
        Asset asset = JSON.parseObject(params , new TypeReference<Asset>() {});
        return  assetService.updateAssetDetail(asset);
    }

    @RequestMapping("addAsset")
    @ResponseBody
    public int addAsset(@RequestBody String params){
        Asset asset = JSON.parseObject(params , new TypeReference<Asset>() {});
        return  assetService.insertAsset(asset);
    }

//    @RequestMapping("deleteAsset")
//    @ResponseBody
//    public int deleteAsset(int ){
//        Asset asset = JSON.parseObject(params , new TypeReference<Asset>() {});
//        return  assetService.insertAsset(asset);
//    }
}
