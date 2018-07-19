package mapper.mapper.com.jsgc.business;

import pojo.com.jsgc.business.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentId);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}