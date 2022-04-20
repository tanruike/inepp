package com.inepp.security;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @ClassName: SecurityApp
 * @Author
 * @Date 2022/3/26
 */
@SpringBootApplication
@EntityScan(basePackages = "com.inepp.domain.entity")
@EnableJpaRepositories(basePackages = "com.inepp.domain.dao")
public class SecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class);
    }

}
