package mapper.business;


import pojo.com.jsxm.business.Asset;

public interface AssetMapper {
    int deleteByPrimaryKey(Integer assetid);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Integer assetid);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}