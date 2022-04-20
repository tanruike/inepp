package com.inepp.service.admin;

import com.inepp.common.startup.BrowserStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @ClassName: AdminApp
 * @Author
 * @Date 2022/4/3
 */

@SpringBootApplication
@EntityScan(basePackages = "com.inepp.domain.entity")
@EnableJpaRepositories(basePackages = "com.inepp.domain.dao")
@ComponentScan(basePackages = {"com.inepp.common","com.inepp.service","com.inepp.security.service"})
public class AdminApp {
    public static void main(String[] args) {


        SpringApplication.run(AdminApp.class);
        new BrowserStartup().run("8093");

    }
}
