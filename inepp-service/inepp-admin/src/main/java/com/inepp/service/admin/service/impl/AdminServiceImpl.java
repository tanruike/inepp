package com.inepp.service.admin.service.impl;

import com.inepp.domain.dao.IGrantPrivsDao;
import com.inepp.domain.dao.IPrivsDao;
import com.inepp.domain.dao.IRoleDao;
import com.inepp.domain.entity.GrantPrivs;
import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import com.inepp.service.admin.service.IAdminService;

import com.inepp.service.admin.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: AdminServiceImpl
 * @Author
 * @Date 2022/4/3
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {


    @Override
    public List<Role> loadRoleExcel(InputStream in) {

       return new ExcelHelper<Role>(in).parse("role",Role.class);
    }

    private  IRoleDao rdao ;
    private IPrivsDao pdao;
    private IGrantPrivsDao gdao;


    private StringRedisTemplate  redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setIrdao(IRoleDao irdao) {
        this.rdao = irdao;
    }

    @Autowired
    public void setIpdao(IPrivsDao ipdao) {
        this.pdao = ipdao;
    }

    @Autowired
    public void setIgdao(IGrantPrivsDao igdao) {
        this.gdao = igdao;
    }


    @Override
    public List<GrantPrivs> loadGrantPrivsExcel(InputStream in) {

        return new ExcelHelper<GrantPrivs>(in).parse("gp",GrantPrivs.class);
    }

    @Override
    public List<Privs> loadPrivsExcel(InputStream in) {

        return new ExcelHelper<Privs>(in).parse("privs",Privs.class);
    }

    @Override
    public void addRole(List<Role> list) {
        list.forEach(e->rdao.save(e));
    }

    @Override
    public void addPrivs(List<Privs> list) {
        list.forEach(e->pdao.save(e));
    }

    @Override
    public void addGrantPrivs(List<GrantPrivs> list) {
        list.forEach(e->gdao.save(e));
    }

    @Override
    public void preLoadAuthority() {
        List<GrantPrivs> all = gdao.findAll();//拿到角色权限对应表
        for (GrantPrivs g : all){//根据角色id拿到对应的权限id
            Integer roleId = g.getRoleId();//角色id
            Integer privsId = g.getPrivsId();//权限id
            Privs privs = pdao.getById(privsId);
            String privsName = privs.getName();//拿到权限名
            System.out.println(privsName);
            redisTemplate.opsForSet().add("role_"+roleId,privsName);
        }

    }
}
