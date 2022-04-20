package com.inepp.common.exception.security;

/**
 * @ClassName: IncorrectCreadentialsException
 * @Author
 * @Date 2022/3/26
 */
public class IncorrectCredentialsException extends SecurityException  {
    public IncorrectCredentialsException(String message) {
        super(message);
    }
}
