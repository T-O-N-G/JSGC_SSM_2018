package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Asset;
import util.com.jsgc.searchCondition.AssetSearchConditions;

import java.util.List;

public interface AssetMapper {
    int deleteByPrimaryKey(Integer assetId);
    int deleteFakeByPrimaryKey(Integer assetId);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer assetId);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);

    List<Asset> selectAll(AssetSearchConditions ps);

    int ifSerialExistAdd(String assetSerial);

    int ifSerialExistUpdt(Asset asset);
}