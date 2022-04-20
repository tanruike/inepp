package com.inepp.service.admin.schedule;

import com.inepp.service.admin.service.IAdminService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName: AuthorityQuartz
 * @Author
 * @Date 2022/3/29
 */

/**
 * 任务表
 */
public class AuthorityAdminQuartz extends QuartzJobBean {
    private IAdminService ias;





    @Autowired
    public void setIrs(IAdminService ias) {
        this.ias = ias;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ias.preLoadAuthority();
    }
}
