package com.pug.zixun.config.interceptor;

import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pug.zixun.common.anno.IgnoreToken;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.exceptions.PugTokenException;
import com.pug.zixun.config.jwt.JwtServer;
import com.pug.zixun.config.validator.PugAssert;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import com.pug.zixun.threadlocal.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class PassportLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtServer jwtServer;
    @Autowired
    private UserService service;
    private String getToken(HttpServletRequest http){
        String token = http.getHeader("token");
        return token;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //自定义注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //方法和类中有这个注解即直接返回，不验证token
        IgnoreToken methodAnnotation = method.getAnnotation(IgnoreToken.class);
        if (methodAnnotation!=null){
            return true;
        }

        IgnoreToken classAnnotation = handlerMethod.getBeanType().getAnnotation(IgnoreToken.class);
        if (classAnnotation!=null){
            return true;
        }
        String token = getToken(request);
        if (StringUtils.isEmpty(token)) {
            throw new PugTokenException(AdminErrorResultEnum.TOKEN_NOT_FOUND);
        }
        //校验token是否合法
        boolean b = jwtServer.verifyToken(token);
        PugAssert.isTrueEx(b,AdminErrorResultEnum.TOKEN_ERROR);
        //解析token，获取用户id
        Long tokenByUserId = jwtServer.getTokenByUserId(token);
        PugAssert.isNullEx(tokenByUserId,AdminErrorResultEnum.USER_NOT_FOUND);

        //根据用户id查询用户信息
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("id",tokenByUserId);
        User one = service.getOne(query);
        if (one == null){
            throw new PugTokenException(AdminErrorResultEnum.USER_NOT_FOUND);
        }
        //是否黑名单
        if (one.getForbbiden()!=null&&one.getForbbiden().equals(0)){
            throw new PugTokenException(AdminErrorResultEnum.USER_FORBID);
        }
        //是否删除
        if (one.getIsDelete()!=null&&one.getIsDelete().equals(1)){
            throw new PugTokenException(AdminErrorResultEnum.USER_FORBID);
        }
        //把用户信息放入到UserThreadLocal中
        UserThreadLocal.put(one);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserThreadLocal.remove();
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }

}
