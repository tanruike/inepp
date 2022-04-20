package com.inepp.security.service.impl;

import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import com.inepp.security.service.IAuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: AuthorityServiceImplTest
 * @Author
 * @Date 2022/3/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorityServiceImplTest {

    @Autowired
    private IAuthorityService ias;


    @Test
    public void createAccount() {
        ias.createAccount("chen","123");
    }



    @Test
    public void createRole() {

        String[] roles = {
                "小区物业","普通居民",
                "防疫部门",
                "医疗机构","志愿者",
                "时空伴随者",
                "境外人员","低风险人员"
        };

        for(int i=0;i<roles.length;i++){
            ias.createRole(new Role(null, roles[i],roles[i]+"的描述","admin",new Date()));
        }
    }

    @Test
    public void createPrivs() {
        String[] privses = {"查询个人健康码",
                "查询本小区人员健康码", "检验核酸", "查询所有居民核酸结果",
                "填写核酸结果",
                "修改个人登录密码",
                "注册系统“，”查询本人行踪轨迹"};

        for(int i=0;i<privses.length;i++){
            ias.createPrivs(new Privs(null,privses[i],privses[i]+"的描述","admin",new Date()));
        }
    }

    @Test
    public void grantPrivsToRole() {
    }

    @Test
    public void grantRoleToAccount() {
    }

    @Test
    public void login() {
    }

    @Test
    public void findAllRole() {
        List<Role> list = ias.findAllRole();
        list.forEach(System.out::println);
    }
}