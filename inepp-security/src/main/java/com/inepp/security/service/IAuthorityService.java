package com.inepp.security.service;

import com.inepp.domain.entity.Account;
import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @ClassName: IAuthorityService
 * @Author
 * @Date 2022/3/26
 */
public interface IAuthorityService {
    /**
     *  创建权限
     * @param username 用户名
     * @param password 密码
     */
    void createAccount(String username,String password);

    /**
     * 创建角色
     * @param role
     */
    void createRole(Role role);

    /**
     * 创建权限
     * @param privs
     */
    void createPrivs(Privs privs);

    /**
     * 给角色授予多个权限
     * @param roleId
     * @param privsId
     */
    void grantPrivsToRole(int roleId, int  privsId);

    /**
     * 给账户授予角色
     * @param accountId
     * @param roleId
     */
    void grantRoleToAccount(int accountId, int roleId);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Account login(String username, String password);

    /**
     * 查看所有角色
     * @return
     */
    List<Role> findAllRole();
}
