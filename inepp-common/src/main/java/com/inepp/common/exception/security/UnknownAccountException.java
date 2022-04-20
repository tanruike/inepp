package com.inepp.common.exception.security;

/**
 * @ClassName: UnknownAccountException
 * @Author
 * @Date 2022/3/26
 */
public class UnknownAccountException extends SecurityException{
    public UnknownAccountException(String message) {
        super(message);
    }
}
