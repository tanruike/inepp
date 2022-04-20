package com.inepp.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: Account
 * @Author
 * @Date 2022/3/26
 */
@ApiModel(description = "居民信息对象")
@Entity
@Table(name = "account_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;
    @ApiModelProperty(value = "电话号码",example = "1234567",required = true)
    @Column(name = "account_username")
    private String username;
    @Column(name = "account_password")
    private String password;
    @Column(name = "account_residents")
    private Integer residentsId;
    @Column(name = "account_role")
    private Integer roleId;
    @Column(name = "accpunt_init_password")
    private  String initPassword;
    @Column(name = "account_createby")
    private String createBy;
    @Column(name = "account_createTime")
    private Date createTime;
}
