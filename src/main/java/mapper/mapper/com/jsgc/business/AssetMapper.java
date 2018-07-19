package mapper.mapper.com.jsgc.business;

import pojo.com.jsgc.business.Asset;

public interface AssetMapper {
    int deleteByPrimaryKey(Integer assetId);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer assetId);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}