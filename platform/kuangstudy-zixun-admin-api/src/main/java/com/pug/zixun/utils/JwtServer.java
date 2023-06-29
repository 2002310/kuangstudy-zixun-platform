package com.pug.zixun.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.exceptions.PugTokenException;
import com.pug.zixun.domain.User;
import com.pug.zixun.vo.UserVO;
import org.omg.CORBA.TIMEOUT;
import org.springframework.stereotype.Component;

import java.lang.ref.PhantomReference;
import java.util.Date;

@Component
public class JwtServer {
    //jwt私钥
    private static final String KEY = "pugadmin123456";
    private static final String CLAIM_ID = "pug-userid-token";
    /*
    * 单位：毫秒
    * 1s
    * */
    private static final Long ONE_SECOND = 1000L;
    /*
    * 30m
    * */
    private static final Long TOKEN_EXPIRE_TIME = ONE_SECOND * 60 * 30;
    private Algorithm ALOG = Algorithm.HMAC256(KEY);


    //生成token
    public String createToken(UserVO userVo){
        //创建加密签名

        String token = JWT.create()
                .withIssuer(userVo.getUserName())
                //指定用户id，不要放完整的用户信息，放太多对象体积会很大，生成token太长了。且不安全，可被解密
                //后续开发会解析用户id去数据库或redis查一遍
                .withClaim(CLAIM_ID,userVo.getId())
                .withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRE_TIME))
                .sign(ALOG);
        return token;
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
            JWTVerifier verifier = JWT.require(ALOG).build();
            DecodedJWT verify = verifier.verify(token);
            return verify.getClaim(CLAIM_ID).asLong();
        }catch (Exception ex){
            throw new PugTokenException(AdminErrorResultEnum.TOKEN_ERROR);
        }
    }
}
