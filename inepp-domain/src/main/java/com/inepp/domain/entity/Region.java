package com.inepp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName: Region
 * @Author
 * @Date 2022/3/26
 */
@Entity
@Table(name = "region_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="region_id")
    private Integer id;
    @Column(name ="region_name")
    private String name;
    @Column(name ="region_pid")
    private Integer pid;
}
