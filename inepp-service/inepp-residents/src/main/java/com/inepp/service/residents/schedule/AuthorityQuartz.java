package com.inepp.service.residents.schedule;



import com.inepp.service.residents.service.IResidentsService;
import org.quartz.JobExecutionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * @ClassName: AuthorityQuartz
 * @Author
 * @Date 2022/3/29
 */

public class AuthorityQuartz extends QuartzJobBean {
    @Autowired
    private IResidentsService irs;





    @Override
    protected void executeInternal(JobExecutionContext context) {
        irs.loadAllUserName();

    }
}
