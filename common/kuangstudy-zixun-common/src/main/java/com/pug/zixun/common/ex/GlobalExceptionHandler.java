package com.pug.zixun.common.ex;

import com.pug.zixun.common.enums.AdminErrorResultEnum;
import com.pug.zixun.common.enums.AdminSuccessResultEnum;
import com.pug.zixun.common.exceptions.PugBusinessException;
import com.pug.zixun.common.exceptions.PugOrderException;
import com.pug.zixun.common.exceptions.PugValidatorException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ErrorHandler makeException(Throwable e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.ADMIN_SERVER_ERROR,e.toString());
        return errorHandler;
    }
    @ExceptionHandler(FileNotFoundException.class)
    public ErrorHandler fileNotFoundException(FileNotFoundException e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.FILE_NOT_FOUND,e.toString());
        return errorHandler;
    }
    @ExceptionHandler(RuntimeException.class)
    public ErrorHandler RuntimeException(RuntimeException e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.RUNTIME_ERROR,e.toString());
        return errorHandler;
    }
    @ExceptionHandler(PugBusinessException.class)
    public ErrorHandler BusinessException(PugBusinessException e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.RUNTIME_ERROR,e.toString());
        return errorHandler;
    }
    @ExceptionHandler(PugOrderException.class)
    public ErrorHandler OrderException(PugOrderException e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.RUNTIME_ERROR,e.toString());
        return errorHandler;
    }@ExceptionHandler(PugValidatorException.class)
    public ErrorHandler ValidatorException(PugValidatorException e, HttpServletRequest request){
        e.printStackTrace();
        ErrorHandler errorHandler = ErrorHandler.fail(AdminErrorResultEnum.RUNTIME_ERROR,e.toString());
        return errorHandler;
    }


}
