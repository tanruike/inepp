package com.inepp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: GrantPrivs
 * @Author
 * @Date 2022/3/26
 */
@Entity
@Table(name = "gp_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrantPrivs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gp_id")
    private Integer id;
    @Column(name = "gp_role")
    private Integer roleId;
    @Column(name = "gp_privs")
    private Integer privsId;

    @Column(name = "gp_createby")
    private String createBy;
    @Column(name = "gp_createTime")
    private Date createTime;
}
