package com.inepp.service.admin.config;

import com.inepp.service.admin.schedule.AuthorityAdminQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时器
 * @ClassName: QuartzConfiguration
 * @Author
 * @Date 2022/3/29
 */
@Configuration
public class QuartzAdminConfiguration {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(AuthorityAdminQuartz.class)
                .withIdentity("privs-quartz")
                .storeDurably().build();
    }

    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("privs-quartz")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(
                                "0 53 12 * * ? *"
                        )
                ).build();
    }
}
