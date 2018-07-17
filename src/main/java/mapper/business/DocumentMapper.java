package mapper.business;


import pojo.com.jsxm.business.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentid);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentid);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}