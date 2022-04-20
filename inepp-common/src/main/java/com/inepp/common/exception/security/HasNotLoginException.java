package com.inepp.common.exception.security;

/**
 * @ClassName: HasNotLoginException
 * @Author
 * @Date 2022/3/28
 */
public class HasNotLoginException extends SecurityException {
    public HasNotLoginException(String message) {
        super(message);
    }
}
