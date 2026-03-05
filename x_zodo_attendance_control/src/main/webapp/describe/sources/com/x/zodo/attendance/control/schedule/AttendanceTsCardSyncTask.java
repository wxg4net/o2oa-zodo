package com.x.zodo.attendance.control.schedule;

import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.schedule.AbstractJob;
import com.x.zodo.attendance.control.service.AttendanceTsCardSyncService;
import org.quartz.JobExecutionContext;

public class AttendanceTsCardSyncTask extends AbstractJob {

    private final Logger logger = LoggerFactory.getLogger(AttendanceTsCardSyncTask.class);
    private final AttendanceTsCardSyncService atdTsCardSyncService = new AttendanceTsCardSyncService();

    @Override
    public void schedule(JobExecutionContext jobExecutionContext) throws Exception {
        logger.info("AttendanceTsCardSyncTask execute started.");
        atdTsCardSyncService.execute();
        logger.info("AttendanceTsCardSyncTask execute completed.");
    }

}