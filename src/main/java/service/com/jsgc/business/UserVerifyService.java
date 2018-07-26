package service.com.jsgc.business;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class UserVerifyService {
    @Autowired
    private JedisPool jedisPool;

    public boolean UserProjectVerify(String userID, String projectID) {
        String key = "Project:User:" + userID;
        String value = projectID;
        return SingleAnalyze(key, value);

    }

    public boolean UserDocumentVerify(String userID, String projectID, String contractID) {
        String key = "Contract:User:" + userID + ":Project:" + projectID;
        String value = contractID;
        return SingleAnalyze(key, value);
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
