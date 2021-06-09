package com.jwt.hs256;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.UUID;

/**
 * @author lryepoch
 * @date 2021/6/9 13:32
 * @description TODO HS256 方式(对称加密算法)
 */
public class HS256Test {
    public static void main(String[] args) {

        String secret = "eyJhbGciOiJIUzI1NiIsInR5cCI";

        //生产token
        String token = generate(secret);
        System.out.println("token：" + token);

        //校验token
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("jack").build();
        try {
            DecodedJWT verify = verifier.verify(token);

            System.out.println("getToken：" + verify.getToken());
            System.out.println("getAlgorithm：" + verify.getAlgorithm());
            System.out.println("getHeader：" + verify.getHeader());
            System.out.println("getPayload：" + verify.getPayload());
            System.out.println("getSignature：" + verify.getSignature());

            System.out.println("getIssuer：" + verify.getIssuer());
            System.out.println("getSubject：" + verify.getSubject());
            System.out.println("getAudience：" + verify.getAudience());
            System.out.println("getIssuedAt：" + verify.getIssuedAt());
            System.out.println("getExpiresAt：" + verify.getExpiresAt());
            System.out.println("getClaims：" + verify.getClaims());
            System.out.println("getNotBefore：" + verify.getNotBefore());
            System.out.println("getId：" + verify.getId());


        } catch (TokenExpiredException ex) {
            ex.printStackTrace();
        }
    }

    static String generate(String secret) {
        try {
            //设置签名的加密算法：HMAC256
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("jack")   //发布者
                    .withSubject("test")    //主题
                    .withAudience("lryepoch")     //观众，相当于接受者
                    .withIssuedAt(new Date())   // 生成签名的时间
                    .withExpiresAt(DateUtil.offset(new Date(), DateField.HOUR_OF_DAY, 2))    // 生成签名的有效期,小时
                    .withClaim("data", JSON.toJSONString("Object")) //自定义字段存数据
                    .withNotBefore(new Date())  //生效时间
                    .withJWTId(UUID.randomUUID().toString())    //编号
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            //签名不匹配
        }
        return null;
    }
}
