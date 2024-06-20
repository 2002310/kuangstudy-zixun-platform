package com.pug.zixun.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.exceptions.PugTokenException;
import com.pug.zixun.config.validator.PugAssert;
import com.pug.zixun.vo.UserVO;
import org.jacoco.agent.rt.internal_1f1cc91.core.internal.flow.IFrame;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtServer {
    //jwt私钥
    private static final String KEY = "pugadmin123456";
    private static final String CLAIM_ID = "pug-userid-token";
    public static final String PUG_TOKEN_PRIVATE = "pug-userid-token";
    /*
    * 单位：毫秒
    * 1s
    * */
    private static final Long ONE_SECOND = 1000L;
    /*
    * 30m
    * */
    public static final Long TOKEN_EXPIRE_TIME = ONE_SECOND * 60 * 30;
    private Algorithm ALOG = Algorithm.HMAC256(KEY);


    //生成token
    public String createToken(UserVO userVo){
        //创建加密签名
        System.out.println(userVo.getId());
        String token = JWT.create()
                .withIssuer(userVo.getUsername())
                //指定用户id，不要放完整的用户信息，放太多对象体积会很大，生成token太长了。且不安全，可被解密
                //后续开发会解析用户id去数据库或redis查一遍
                .withClaim(CLAIM_ID,userVo.getId())
                //签发时间
                .withIssuedAt(new Date())
                //过期时间
                .withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRE_TIME))
                .sign(ALOG);
        return PUG_TOKEN_PRIVATE+token;
    }
    /*
    * 校验token
    *
    * */
    public boolean verifyToken(String token){
        try{
            JWTVerifier verifier = JWT.require(ALOG).build();
            DecodedJWT verify = verifier.verify(token);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    //从token中获取用户id
    public Long getTokenByUserId(String token){
        try{
            PugAssert.isNullEx(token,AdminErrorResultEnum.TOKEN_IS_NULL);
            PugAssert.isFalseEx(!token.startsWith(PUG_TOKEN_PRIVATE),AdminErrorResultEnum.TOKEN_NOT_ACTIVITY);
            JWTVerifier verifier = JWT.require(ALOG).build();
            DecodedJWT verify = verifier.verify(token);
            Long aLong = verify.getClaim(CLAIM_ID).asLong();
            System.out.println(aLong);
            return aLong;
        }catch (Exception ex){
            throw new PugTokenException(AdminErrorResultEnum.TOKEN_ERROR);
        }
    }
    //获取token的签发时间
    public Date getTokenIssuedAt(String token){
        JWTVerifier verifier = JWT.require(ALOG).build();
        DecodedJWT verify = verifier.verify(token);
        Date issuedAt = verify.getIssuedAt();
        return issuedAt;
    }
    //获取token的过期时间
    public Date getTokenExpireTime(String token){
        JWTVerifier verifier = JWT.require(ALOG).build();
        DecodedJWT verify = verifier.verify(token);
        Date expiresAt = verify.getExpiresAt();
        return expiresAt;
    }
    //刷新token时间
    public boolean shouldTokenRefresh2(Date expiresTime){
        return true;
    }
}
