package com.inepp.common.exception.security;

/**
 * @ClassName: HostAuthorizedException
 * @Author
 * @Date 2022/3/26
 */
public class HostAuthorizedException extends SecurityException{
    public HostAuthorizedException(String message) {
        super(message);
    }
}
