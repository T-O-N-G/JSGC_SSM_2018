package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Document;
import util.com.jsgc.searchCondition.DocumentSearchConditions;

import java.util.List;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentId);
    int deleteFakeByPrimaryKey(Integer documentId);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);


    List<Document> selectAll(DocumentSearchConditions ps);
}