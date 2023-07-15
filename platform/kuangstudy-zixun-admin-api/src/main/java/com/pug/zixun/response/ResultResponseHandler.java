package com.pug.zixun.response;

import com.pug.zixun.common.ex.ErrorHandler;
import com.pug.zixun.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
//当设定了统一返回时，要添加一个包，否则会对swagger照成影响
@RestControllerAdvice
@Slf4j
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        如果返回的是一个异常类，那么就把返回的数据结构进行处理
        if (body instanceof ErrorHandler) {
            ErrorHandler errorHandler = (ErrorHandler) body;
            return R.fail(errorHandler.getCode(),errorHandler.getMsg(),null);
        } else if (body instanceof R) {
            return body;
        } else if (body instanceof String) {
            //因为springmvc数据转换器对string是有特殊处理StringHttpMessageConverter
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(R.success(body));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return R.success(body);
    }
}
