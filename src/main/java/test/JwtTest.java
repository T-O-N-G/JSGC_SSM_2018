package test;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import util.JwtUtil;

public class JwtTest {

    @Test
    public void testJwt() throws Exception {
//        JwtUtil util = new JwtUtil("2222222");
//        String ab = util.createJWT("jwt", "{id:100,name:xiaohong}", 6000000);
//        System.out.println(ab);
//        //eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiJ7aWQ6MTAwLG5hbWU6eGlhb2hvbmd9IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJuaWNrX25hbWUiOiJEQVNEQTEyMSIsImV4cCI6MTUxNzgzNTE0NiwiaWF0IjoxNTE3ODM1MDg2LCJqdGkiOiJqd3QifQ.ncVrqdXeiCfrB9v6BulDRWUDDdROB7f-_Hg5N0po980
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiJ7aWQ6MTAwLG5hbWU6eGlhb2hvbmd9IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJuaWNrX25hbWUiOiJEQVNEQTEyMSIsImV4cCI6MTUzMTgxMjk3NiwiaWF0IjoxNTMxODEyOTE2LCJqdGkiOiJqd3QifQ.FWGrH3yvifPS3hpR7QIJvP-cQZg_nszFMc6b5VAV_Oc";
//        Claims c = util.parseJWT(jwt);//注意：如果jwt已经过期了，这里会抛出jwt过期异常。
//        System.out.println(c.getId());//jwt
//        System.out.println(c.getIssuedAt());//Mon Feb 05 20:50:49 CST 2018
//        System.out.println(c.getSubject());//{id:100,name:xiaohong}
//        System.out.println(c.getIssuer());//null
//        System.out.println(c.get("uid", String.class));//DSSFAWDWADAS...
    }


}
