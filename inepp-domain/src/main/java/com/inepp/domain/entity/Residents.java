package com.inepp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Residents
 * @Author
 * @Date 2022/3/26
 */
@Entity
@Table(name = "residents_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="residents_id")
    private Integer id;
    @Column(name="residents_name")
    private String name;
    @Column(name="residents_gender")
    private String gender;
    @Column(name="residents_age")
    private Integer age;
    @Column(name="residents_phone")
    private String phone;
    @Column(name="residents_identity")
    private String identity;
    @Column(name="residents_region")
    private String region;//当前所在行政区
    @Column(name="residents_vaccines")
    private String vaccines; //疫苗接种
    @Column(name="residents_overseas_arrival")
    private String overseasArrival;
    @Column(name="residents_health_code")
    private String healthCode; //健康码
    @Column(name="residents_dhsa")
    private String dhsa;//是否去过高风险
    @Column(name="residents_health_status")
    private String heathStatus;//健康状况
    @Column(name="residents_createby")
    private String createBy;
    @Column(name="residents_ceratetime")
    private Date createTime;


}
