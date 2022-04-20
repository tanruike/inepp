package com.inepp.common.exception.security;

/**
 * @ClassName: EmptyAccountException
 * @Author
 * @Date 2022/3/26
 */
public class EmptyAccountException extends SecurityException{
    public EmptyAccountException(String message) {
        super(message);
    }
}
