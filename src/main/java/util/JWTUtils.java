package util;

import com.alibaba.druid.util.Base64;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    public String createJWT(String id, String subject, long ttlMillis, Map<String, Object> claims) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        long nowMillis = System.currentTimeMillis();// 生成JWT的时间
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        // 下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() // 这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims) // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(id) // 设置jti(JWT
                // ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now) // iat: jwt的签发时间
                .setSubject(subject) // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm, key);// 设置签名使用的签名算法和签名使用的秘钥
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp); // 设置过期时间
        }
        return builder.compact(); // 就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception {
        SecretKey key = generalKey(); // 签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser() // 得到DefaultJwtParser
                .setSigningKey(key) // 设置签名的秘钥
                .parseClaimsJws(jwt).getBody();// 设置需要解析的jwt
        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public SecretKey generalKey() {
        PropertiesUtils propertiesUtils = new PropertiesUtils();
        byte[] encodedKey = Base64.decodeBase64(propertiesUtils.getUrlValue("secret", "secret"));// 本地的密码解码
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// 根据给定的字节数组使用AES加密算法构造一个密钥，使用
        return key;
    }
}

