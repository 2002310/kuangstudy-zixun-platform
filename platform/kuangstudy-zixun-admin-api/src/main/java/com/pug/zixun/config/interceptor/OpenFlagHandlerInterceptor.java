package com.pug.zixun.config.interceptor;

import com.pug.zixun.threadlocal.OpenFlagThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class OpenFlagHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String isFlag = request.getParameter("isFlag");
        OpenFlagThreadLocal.put(Integer.parseInt(isFlag==null?"0":isFlag));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        OpenFlagThreadLocal.remove();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        OpenFlagThreadLocal.remove();
    }
}
