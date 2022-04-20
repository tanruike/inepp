package com.inepp.common.dto;

/**
 * @ClassName: RespEnum
 * @Author
 * @Date 2022/3/26
 */
public enum RespEnum {
    EMPTY_ACCOUNT(4000,"账号为空"),
    UNKNOWN_ACCOUNT(4001,"账号不存在"),
    INCORRECT_CREDENTIALS(4002,"用户名/密码错误"),
    HOST_UNAUTHORIZED(4010,"权限异常"),
    LOGIN_SUCCESS(2001,"用户登录成功"),
    LOGINOUT_SUCCESS(2002,"用户退出成功"),
    REGISTER_SUCCESS(3000,"注册成功"),
    ACCOUNT_EXISTS(4444,"账户已经存在"),
    CHANGE_PASSWORD_SUCCESS(3000,"密码修改成功"),
    NOT_LOGIN(40000,"未登录"),
    EXISTS_RESIDENTS(30001,"用户已经存在"),
    LOAD_SUCCESS(110,"加载成功")
    ;

    private int code;
    private String msg;

    RespEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
