package service.com.jsgc.business;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class UserVerifyService {
    @Autowired
    private JedisPool jedisPool;
    public boolean UserProjectVerify(String userID, String projectSerial) {
        String key = "ProjectSerial:User:" + userID;
        String value = projectSerial;
        return SingleAnalyze(key, value);

    }


    public boolean UserContractUnderProjectVerify(String userID, String projectSerial, String contractSerial) {
        String key = "ContractSerial:User:" + userID + ":Project:" + projectSerial;
        String value = contractSerial;
        return SingleAnalyze(key, value);
    }
    public  boolean UserContractVerify(String userID,String contractSerial){
        String key="Contract:User:"+userID;
        String value=contractSerial;
        return SingleAnalyze(key,value);
    }

    public boolean SingleAnalyze(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (jedis.zrank(key, value) >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
