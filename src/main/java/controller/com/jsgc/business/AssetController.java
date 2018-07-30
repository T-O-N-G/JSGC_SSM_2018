package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Asset;
import service.com.jsgc.business.AssetService;
import util.com.jsgc.searchCondition.AssetSearchConditions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
//@RequestMapping("/bussiness/asset/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})

public class AssetController {
    @Resource
    private AssetService assetService;

    @RequestMapping("/getAssetList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        AssetSearchConditions ps = JSON.parseObject(params , new TypeReference<AssetSearchConditions>() {});
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return assetService.searchByConditions(ps);
    }

    @RequestMapping("getAssetDetail")
    @ResponseBody
    public String getAssetDetail(int assetID){
        return assetService.getAssetDetail(assetID);
    }

    @RequestMapping("updateAssetDetail")
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

    @RequestMapping("deleteAsset")
    @ResponseBody
    public int deleteAsset(Integer assetID){
//        Integer assetID = JSON.parseObject(params,new TypeReference<Integer>() {});
        return  assetService.deleteAsset(assetID);
    }
}
