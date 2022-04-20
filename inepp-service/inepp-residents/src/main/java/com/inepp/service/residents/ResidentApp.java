package com.inepp.service.residents;

import com.inepp.common.startup.BrowserStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @ClassName: ResidentApp
 * @Author
 * @Date 2022/3/27
 */
@SpringBootApplication
@EntityScan(basePackages = "com.inepp.domain.entity")
@EnableJpaRepositories(basePackages = "com.inepp.domain.dao")
@ComponentScan(basePackages = {
        "com.inepp.common",
        "com.inepp.security.service",
        "com.inepp.service.residents"
})
public class ResidentApp {
    public static void main(String[] args) {

        SpringApplication.run(ResidentApp.class);
        new BrowserStartup().run("8092");
    }
}
