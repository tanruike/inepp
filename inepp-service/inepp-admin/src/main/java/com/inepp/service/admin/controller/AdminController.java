package com.inepp.service.admin.controller;

import com.inepp.common.dto.HttpResp;
import com.inepp.common.dto.RespEnum;
import com.inepp.domain.entity.GrantPrivs;
import com.inepp.domain.entity.Privs;
import com.inepp.domain.entity.Role;
import com.inepp.service.admin.service.IAdminService;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName: AdminController
 * @Author
 * @Date 2022/4/3
 */
@Api(tags = "管理员模块")
@RestController
@RequestMapping("/aip/admin")
@Slf4j
public class AdminController {



    private IAdminService ias;

    @Autowired
    public void setIas(IAdminService ias) {
        this.ias = ias;
    }

    @PostMapping("/loadRole")
    @SneakyThrows
    public HttpResp loadRole(MultipartFile file){
        List<Role> roles;
        roles = ias.loadRoleExcel(file.getInputStream());
        log.debug(""+roles);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), roles, LocalDate.now());
    }


    @PostMapping("/loadPrivs")
    @SneakyThrows
    public HttpResp loadPrivs(MultipartFile file){
        List<Privs> privs;
        privs = ias.loadPrivsExcel(file.getInputStream());
        log.debug(""+privs);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), privs, LocalDate.now());
    }


    @PostMapping("/loadGP")
    @SneakyThrows
    public HttpResp loadGP(MultipartFile file){
        List<GrantPrivs> grantPrivs;
        grantPrivs = ias.loadGrantPrivsExcel(file.getInputStream());
        log.debug(""+grantPrivs);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), grantPrivs, LocalDate.now());
    }

    @PostMapping("/addRole")
    @SneakyThrows

    public HttpResp addRole(MultipartFile file){
        List<Role> roles;
        roles = ias.loadRoleExcel(file.getInputStream());

        ias.addRole(roles);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), roles, LocalDate.now());

    }


    @PostMapping("/addPrivs")
    @SneakyThrows

    public HttpResp addPrivs(MultipartFile file){
        List<Privs> Privs;
        Privs = ias.loadPrivsExcel(file.getInputStream());

        ias.addPrivs(Privs);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), Privs, LocalDate.now());

    }


    @PostMapping("/addGrantPrivs")
    @SneakyThrows

    public HttpResp addGrantPrivs(MultipartFile file){
        List<GrantPrivs> GrantPrivs;
        GrantPrivs = ias.loadGrantPrivsExcel(file.getInputStream());

        ias.addGrantPrivs(GrantPrivs);
        return new HttpResp(RespEnum.LOAD_SUCCESS.getCode(), RespEnum.LOAD_SUCCESS.getMsg(), GrantPrivs, LocalDate.now());

    }




}
