package com.x.zodo.attendance.control.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

import com.x.base.core.project.tools.DateTools;
import com.x.zodo.attendance.control.Business;
import com.x.zodo.attendance.control.ThisApplication;

import com.x.zodo.attendance.control.mybatisflex.StatCard;
import com.x.zodo.attendance.control.mybatisflex.StatCardMapper;
import com.x.zodo.attendance.control.queueTask.queue.AttendanceRecordQueue;
import org.apache.ibatis.cursor.Cursor;

import java.util.*;

import static com.x.zodo.attendance.control.mybatisflex.table.StatCardTableDef.STAT_CARD;


public class AttendanceTsCardSyncService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceTsCardSyncService.class);

    public void execute() throws Exception {
        logger.info("attendance ts_card sync start");
        this.hanvonSync();
        logger.info("attendance ts_card sync completed");
    }

    protected void hanvonSync() throws Exception {
        Date hitDate = new Date();
        Date lastDate = DateTools.getAdjustTimeDay(hitDate, -1, null, null, null);
        StatCardMapper statCardMapper = Business.flexBootstrap().getMapper(StatCardMapper.class);
        QueryWrapper query = new QueryWrapper();
        query.where(STAT_CARD.TS_CREATE.ge(String.format("%s 00:00:00", DateTools.formatDate(lastDate))))
		.and(STAT_CARD.TS_CREATE.lt(String.format("%s 00:00:00", DateTools.formatDate(hitDate))))
                .and(STAT_CARD.ACCESS.eq(0));
        Db.tx(() -> {
            Cursor<StatCard> statCards = statCardMapper.selectCursorByQuery(query);
            for (StatCard statCard : statCards) {
                String userId = statCard.getSzEmployId();
                String userName = statCard.getSzUserName();
                String hitTime = DateTools.format(statCard.getTsCard());
                try {
                    // logger.info("attendance ts_card sync => {} {} {}", userId, userName, hitTime);
                    ThisApplication.attendanceRecordQueueTask.send( new AttendanceRecordQueue( userId, userName, hitTime) );
                } catch (Exception e) {
                    logger.error(e);
                    throw new RuntimeException(e);
                }
            }
            return true;
        });
    }

}
