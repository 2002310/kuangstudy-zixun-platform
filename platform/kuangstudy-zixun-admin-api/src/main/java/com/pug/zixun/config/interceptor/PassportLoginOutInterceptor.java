package com.pug.zixun.config.interceptor;

import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pug.zixun.common.anno.IgnoreToken;
import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.exceptions.PugTokenException;
import com.pug.zixun.common.exceptions.PugValidatorException;
import com.pug.zixun.common.utils.fn.asserts.Vsserts;
import com.pug.zixun.config.jwt.JwtServer;
import com.pug.zixun.config.validator.PugAssert;
import com.pug.zixun.domain.User;
import com.pug.zixun.service.UserService;
import com.pug.zixun.threadlocal.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
//下线拦截器
@Slf4j
@Component
public class PassportLoginOutInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token_uuid = request.getHeader("token_uuid");
        String token_userid = request.getHeader("token_userid");
        PugAssert.isEmptyEx(token_uuid,AdminErrorResultEnum.UUID_EX_OR_NULL);
        PugAssert.isEmptyEx(token_userid,AdminErrorResultEnum.UUID_EX_OR_NULL);
        String redisuuid = (String) redisTemplate.opsForValue().get("pug:user:login:" + token_userid);
        PugAssert.isEmptyEx(redisuuid,AdminErrorResultEnum.UUID_EX_OR_NULL);
        if (!token_uuid.equals(redisuuid)){
            throw new PugValidatorException(AdminErrorResultEnum.USER_LOGIN_SAME);
        }
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
