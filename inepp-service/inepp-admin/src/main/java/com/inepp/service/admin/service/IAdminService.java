package com.inepp.service.admin.service;

import com.inepp.domain.entity.GrantPrivs;
import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: IAdminService
 * @Author
 * @Date 2022/4/3
 */

public interface IAdminService {
    List<Role> loadRoleExcel(InputStream in);
    List<GrantPrivs> loadGrantPrivsExcel(InputStream in);
    List<Privs> loadPrivsExcel(InputStream in);



    void addRole(List<Role> list);
    void addPrivs(List<Privs> list);
    void addGrantPrivs(List<GrantPrivs> list);

   void preLoadAuthority();//将角色对应的权限 存取缓存

}
