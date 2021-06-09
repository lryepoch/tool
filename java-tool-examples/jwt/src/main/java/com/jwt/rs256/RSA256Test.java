//package com.jwt.rs256;
//
//import cn.hutool.core.date.DateField;
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.crypto.asymmetric.RSA;
//import com.alibaba.fastjson.JSON;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.util.Date;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * @author lryepoch
// * @date 2021/6/9 13:32
// * @description TODO RS256 方式(非对称算法)
// */
//public class RSA256Test {
//    public static final String PUBLIC_KEY = "publicKey";
//    public static final String PRIVATE_KEY = "privateKey";
//
//    public static void main(String[] args) throws Exception {
//
//
//        Map<String, byte[]> keyMap = CreateSecrteKey.initKey();
//
//        RSAPublicKey publicKey = CreateSecrteKey.restorePublicKey(keyMap.get(PUBLIC_KEY));
//        RSAPrivateKey privateKey = CreateSecrteKey.restorePrivateKey(keyMap.get(PRIVATE_KEY));
//
//        //生成token
//        String token = generate(publicKey, privateKey);
//
//        //校验token
//        Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
//        JWTVerifier verifier = JWT.require(algorithm).withIssuer("rstyro").build();
//
//        try {
//            DecodedJWT verify = verifier.verify(token);
//
//            System.out.println("getToken：" + verify.getToken());
//            System.out.println("getAlgorithm：" + verify.getAlgorithm());
//            System.out.println("getHeader：" + verify.getHeader());
//            System.out.println("getPayload：" + verify.getPayload());
//            System.out.println("getSignature：" + verify.getSignature());
//
//            System.out.println("getIssuer：" + verify.getIssuer());
//            System.out.println("getSubject：" + verify.getSubject());
//            System.out.println("getAudience：" + verify.getAudience());
//            System.out.println("getIssuedAt：" + verify.getIssuedAt());
//            System.out.println("getExpiresAt：" + verify.getExpiresAt());
//            System.out.println("getClaims：" + verify.getClaims());
//            System.out.println("getNotBefore：" + verify.getNotBefore());
//            System.out.println("getId：" + verify.getId());
//
//        } catch (TokenExpiredException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    static String generate(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
//        try {
//            //设置签名的加密算法：RSA256
//            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
//            String token = JWT.create()
//                    .withIssuer("rstyro")   //发布者
//                    .withSubject("test")    //主题
//                    .withAudience("audience")     //观众，相当于接受者
//                    .withIssuedAt(new Date())   // 生成签名的时间
//                    .withExpiresAt(DateUtil.offset(new Date(), DateField.HOUR_OF_DAY, 2))    // 生成签名的有效期,小时
//                    .withClaim("data", JSON.toJSONString("Object")) //自定义字段存数据
//                    .withNotBefore(new Date())  //生效时间
//                    .withJWTId(UUID.randomUUID().toString())    //编号
//                    .sign(algorithm);
//            return token;
//        } catch (JWTCreationException exception) {
//            //签名不匹配
//            exception.printStackTrace();
//        }
//        return null;
//    }
//}
