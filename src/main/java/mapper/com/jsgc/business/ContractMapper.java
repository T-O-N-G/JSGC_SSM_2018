package mapper.com.jsgc.business;


import pojo.com.jsgc.business.Contract;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    int getContractIDBySerial(String contractSerial);


}