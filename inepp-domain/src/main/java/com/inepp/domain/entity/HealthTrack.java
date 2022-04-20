package com.inepp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: HealthTrack
 * @Author
 * @Date 2022/3/26
 */
@Entity
@Table(name = "health_track_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ht_id")
    private Integer id;
    @Column(name = "ht_nat")
    private String nat;
    @Column(name = "ht_temp")
    private Double temp;
    @Column(name = "ht_region")
    private String region;
    @Column(name = "ht_from_resion")
    private String fromRegion;
    @Column(name = "ht_to_resion")
    private String toRegion;
    @Column(name = "ht_date")
    private Date date;
    @Column(name = "ht_residents")
    private int residentsId;
    @Column(name = "ht_createby")
    private String createBy;
    @Column(name = "ht_createtime")
    private Date createTime;
}
