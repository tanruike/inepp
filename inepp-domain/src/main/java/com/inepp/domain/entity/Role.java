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
@Table(name = "role_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role_name")
    private String name;
    @Column(name = "role_desc")
    private String desc;
    @Column(name = "role_createby")
    private String createBy;
    @Column(name = "role_createtime")
    private Date createTime;
}
