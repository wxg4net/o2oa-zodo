package com.x.zodo.gateway.control.schedule;


import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.schedule.AbstractJob;
import org.quartz.JobExecutionContext;


public class GatewayTask extends AbstractJob {

    private final Logger logger = LoggerFactory.getLogger(GatewayTask.class);
//    private final ProcessSyncService processSyncService = new ProcessSyncService();

    @Override
    public void schedule(JobExecutionContext jobExecutionContext) throws Exception {
        logger.info("GatewayTask execute started.");
        logger.info("GatewayTask execute completed.");
    }

}
