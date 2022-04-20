package com.inepp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: Role
 * @Author
 * @Date 2022/3/26
 */
@Entity
@Table(name = "privs_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privs_id")
    private Integer id;
    @Column(name = "privs_name")
    private String name;
    @Column(name = "privs_desc")
    private String desc;
    @Column(name = "privs_createby")
    private String createBy;
    @Column(name = "privs_createtime")
    private Date createTime;
}
