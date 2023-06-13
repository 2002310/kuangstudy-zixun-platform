package com.pug.zixun.config.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenHandlerInterceptor implements HandlerInterceptor {
    final static String key = "TokenKey";
    @Autowired
    private UserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Algorithm algorithm = Algorithm.HMAC256(key);
        Claim user = JWT.require(algorithm).build().verify(token).getClaim("id");
        Integer integer = user.asInt();
        User byId = service.getById(integer);
        boolean isTokenTrue = (byId == null || byId.getUsername() == null) ? false : true;
        request.setAttribute("user",byId);
        return isTokenTrue;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
