package com.inepp.security.service.handler;

import com.inepp.common.dto.HttpResp;
import com.inepp.common.dto.RespEnum;
import com.inepp.common.exception.security.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

/**
 * @ClassName: AuthorityExceptionHandler
 * @Author
 * @Date 2022/3/27
 */
@RestControllerAdvice
public class AuthorityExceptionHandler {

    @ExceptionHandler
    public HttpResp emptyAccountExceptionHandler(EmptyAccountException e){
        return new HttpResp(RespEnum.EMPTY_ACCOUNT.getCode(), RespEnum.EMPTY_ACCOUNT.getMsg(), null, LocalDate.now());
    }

    @ExceptionHandler
    public HttpResp hostAuthorExceptionHandler(HostAuthorizedException e){
        return new HttpResp(RespEnum.HOST_UNAUTHORIZED.getCode(), RespEnum.HOST_UNAUTHORIZED.getMsg(), null, LocalDate.now());
    }


    @ExceptionHandler
    public HttpResp incorrectCredentialsExceptionHandler(IncorrectCredentialsException e){
        return new HttpResp(RespEnum.INCORRECT_CREDENTIALS.getCode(), RespEnum.INCORRECT_CREDENTIALS.getMsg(), null, LocalDate.now());
    }

    @ExceptionHandler
    public HttpResp unknownAccountExceptionHandler(UnknownAccountException e){
        return new HttpResp(RespEnum.UNKNOWN_ACCOUNT.getCode(), RespEnum.UNKNOWN_ACCOUNT.getMsg(), null, LocalDate.now());
    }


    @ExceptionHandler
    public HttpResp hasNotLoginExceptionHandler(HasNotLoginException e){
        return new HttpResp(RespEnum.NOT_LOGIN.getCode(), RespEnum.NOT_LOGIN.getMsg(), null, LocalDate.now());
    }


}
