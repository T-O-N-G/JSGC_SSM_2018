package mapper.com.jsgc.business;

import pojo.com.jsgc.business.Contract;
import util.com.jsgc.searchCondition.ContractSearchConditions;

import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer contractId);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractId);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    int getContractIDBySerial(String contractSerial);

    List<String> getSerialList();

    void batchInsert(List<Contract> contracts);

    List<Contract> selectByConditions(ContractSearchConditions cs);
}