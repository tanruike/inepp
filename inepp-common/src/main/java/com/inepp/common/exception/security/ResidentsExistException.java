package com.inepp.common.exception.security;

/**
 * @ClassName: ResidentsExistException
 * @Author
 * @Date 2022/3/29
 */
public class ResidentsExistException extends SecurityException{
    public ResidentsExistException(String message) {
        super(message);
    }
}
