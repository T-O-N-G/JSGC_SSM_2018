package mapper.com.jsgc.business;


import pojo.com.jsgc.business.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentid);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentid);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}