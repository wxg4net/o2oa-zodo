package com.x.zodo.attendance.control.queueTask;


import com.x.attendance.entity.v2.AttendanceV2CheckInRecord;
import com.x.attendance.entity.v2.AttendanceV2Group;
import com.x.attendance.entity.v2.AttendanceV2Shift;
import com.x.attendance.entity.v2.AttendanceV2ShiftCheckTime;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.annotation.CheckPersistType;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.organization.Person;
import com.x.base.core.project.queue.AbstractQueue;
import com.x.base.core.project.tools.DateTools;
import com.x.zodo.attendance.control.Business;
import com.x.zodo.attendance.control.ExceptionNotExistObject;
import com.x.zodo.attendance.control.ExceptionWithMessage;
import com.x.zodo.attendance.control.dto.WoGroupShift;
import com.x.zodo.attendance.control.queueTask.queue.AttendanceRecordQueue;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class AttendanceRecordQueueTask extends AbstractQueue<AttendanceRecordQueue> {

    private static Logger logger = LoggerFactory.getLogger( AttendanceRecordQueueTask.class );
    private final HashMap<String, Integer> hitMap = new HashMap<String, Integer>();
    private final long[] durations = {999999, 999999, 999999, 999999, 999999, 999999};
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    protected void execute( AttendanceRecordQueue attendanceRecordQueue ) throws Exception {
        Arrays.fill(durations, 999999);
        try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
            String userId = attendanceRecordQueue.getUserId();
            String userName = attendanceRecordQueue.getUserName();
            String userTime = attendanceRecordQueue.getHitTime();
            Date hitDate = DateTools.parse(userTime, DateTools.format_yyyyMMddHHmmss);
            String woDate = DateTools.formatDate(hitDate);

            Business business = new Business(emc);
            Person p = business.organization().person().getObject(userId);
            if (p == null || StringUtils.isEmpty(p.getDistinguishedName())) {
                throw new ExceptionNotExistObject("人员对象找不到：" + userId);
            }
            logger.info("找到考勤人员 => {}", p.getDistinguishedName());
            List<AttendanceV2CheckInRecord> recordList = business.getAttendanceV2ManagerFactory().listRecordWithPersonAndDate(p.getDistinguishedName(), woDate);

            WoGroupShift woGroupShift = business.getAttendanceV2ManagerFactory()
                    .getGroupShiftByPersonDate(p.getDistinguishedName(), woDate);
            if (woGroupShift == null || woGroupShift.getGroup() == null) {
                throw new ExceptionNotExistObject("没有对应的考勤组");
            }

            AttendanceV2Group group = woGroupShift.getGroup(); // 考勤组
            AttendanceV2Shift shift = woGroupShift.getShift(); // 班次

            if ((group.getCheckType().equals(AttendanceV2Group.CHECKTYPE_Fixed)
                    || group.getCheckType().equals(AttendanceV2Group.CHECKTYPE_Arrangement)) && shift != null) {
                List<AttendanceV2ShiftCheckTime> timeList = shift.getProperties().getTimeList();
                if (timeList == null || timeList.isEmpty()) {
                    throw new ExceptionWithMessage("没有对应的上下班打卡时间");
                }
                AttendanceV2ShiftCheckTime shiftCheckTime = null;

                for (int i = 0; i < timeList.size(); i++) {
                    shiftCheckTime = timeList.get(i);
                    LocalTime localTime1 = LocalTime.parse(DateTools.format(hitDate, DateTools.format_HHmm), formatter);
                    LocalTime localTime2 = LocalTime.parse(shiftCheckTime.getOnDutyTime(), formatter);
                    LocalTime localTime3 = LocalTime.parse(shiftCheckTime.getOffDutyTime(), formatter);
                    Duration duration1 = Duration.between(localTime1 , localTime2);
                    Duration duration2 = Duration.between(localTime1 , localTime3);
                    durations[2*i] = Math.abs(duration1.toMinutes());
                    durations[2*i+1] = Math.abs(duration2.toMinutes());
                }
                int minIndex = IntStream.range(0, durations.length)
                        .reduce((i, j) -> durations[i] > durations[j] ? j : i)
                        .orElse(-1);

                if (recordList.size() > minIndex) {
                    minIndex += 1;
                }
                int useTimeIndex = Math.min(minIndex / 2, timeList.size() - 1);
                int useOnOffIndex = minIndex % 2;
                shiftCheckTime = timeList.get(useTimeIndex);

                if (useOnOffIndex == 0) {
                    saveRecord(AttendanceV2CheckInRecord.OnDuty, p.getDistinguishedName(), woDate,
                            hitDate,
                            shiftCheckTime.getOnDutyTime(), shiftCheckTime.getOnDutyTimeBeforeLimit(),
                            shiftCheckTime.getOnDutyTimeAfterLimit(),
                            group, shift, emc);
                }
                else {
                    saveRecord(AttendanceV2CheckInRecord.OffDuty, p.getDistinguishedName(), woDate,
                            hitDate,
                            shiftCheckTime.getOffDutyTime(), shiftCheckTime.getOffDutyTimeBeforeLimit(),
                            shiftCheckTime.getOffDutyTimeAfterLimit(),
                            group, shift, emc);
                }

            } else {
                int times = recordList.size();
                if (times % 2 == 0) {
                    saveRecord(AttendanceV2CheckInRecord.OnDuty, p.getDistinguishedName(), woDate, hitDate,
                            null, null, null,
                            group, null, emc);
                }
                else {
                    saveRecord(AttendanceV2CheckInRecord.OffDuty, p.getDistinguishedName(), woDate, hitDate,
                            null, null, null,
                            group, null, emc);
                }

            }
        }
    }

    protected void saveRecord(String dutyType, String person, String date, Date recordDate, String preDutyTime, String dutyTimeBeforeLimit, String dutyTimeAfterLimit,
                              AttendanceV2Group group, AttendanceV2Shift shift, EntityManagerContainer emc) throws Exception {
        AttendanceV2CheckInRecord noCheckRecord = new AttendanceV2CheckInRecord();
        noCheckRecord.setCheckInType(dutyType);
        noCheckRecord.setUserId(person);
        // 打卡时间
        if (StringUtils.isEmpty(preDutyTime)) {
            if (AttendanceV2CheckInRecord.OnDuty.equals(dutyType)) {
                preDutyTime = "09:00";
            } else {
                preDutyTime = "18:00";
            }
        }
        String checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NORMAL;
        if (recordDate != null) {
            // 根据班次判断打卡结果
            if (group.getCheckType().equals(AttendanceV2Group.CHECKTYPE_Fixed) && shift != null) {
                // 上班打卡
                if (dutyType.equals(AttendanceV2CheckInRecord.OnDuty)) {
                    Date dutyTime = DateTools.parse(date + " " + preDutyTime, DateTools.format_yyyyMMddHHmm);
                    checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NORMAL;
                    // 迟到
                    if (recordDate.after(dutyTime)) {
                        checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_Late;
                    }
                    // 严重迟到
                    if (shift.getSeriousTardinessLateMinutes() > 0) {
                        Date seriousLateTime = DateTools.addMinutes(dutyTime, shift.getSeriousTardinessLateMinutes());
                        if (recordDate.after(seriousLateTime)) {
                            checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_SeriousLate;
                        }
                    }
                    // 可以晚到
                    if (StringUtils.isNotEmpty(shift.getLateAndEarlyOnTime())) {
                        int minute = -1;
                        try {
                            minute = Integer.parseInt(shift.getLateAndEarlyOnTime());
                        } catch (Exception ignored) {
                        }
                        if (minute > 0) {
                            Date lateAndEarlyOnTime = DateTools.addMinutes(dutyTime, minute);
                            if (recordDate.before(lateAndEarlyOnTime)) {
                                checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NORMAL;
                            }
                        }
                    }
                } else if (dutyType.equals(AttendanceV2CheckInRecord.OffDuty)) {
                    Date offDutyTime = DateTools.parse(date + " " + preDutyTime, DateTools.format_yyyyMMddHHmm);
                    checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NORMAL;
                    // 早退
                    if (recordDate.before(offDutyTime)) {
                        checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_Early;
                    }
                    // 可以早走
                    if (StringUtils.isNotEmpty(shift.getLateAndEarlyOffTime())) {
                        int minute = -1;
                        try {
                            minute = Integer.parseInt(shift.getLateAndEarlyOffTime());
                        } catch (Exception e) {
                        }
                        if (minute > 0) {
                            Date lateAndEarlyOffTime = DateTools.addMinutes(offDutyTime, -minute);
                            if (recordDate.after(lateAndEarlyOffTime)) {
                                checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NORMAL;
                            }
                        }
                    }

                }
            }

        } else { // 没有打卡
            recordDate = DateTools.parse(date+" "+preDutyTime, DateTools.format_yyyyMMddHHmm);
            checkInResult = AttendanceV2CheckInRecord.CHECKIN_RESULT_NotSigned;
        }
        noCheckRecord.setCheckInResult(checkInResult);
        noCheckRecord.setRecordDate(recordDate);
        noCheckRecord.setRecordDateString(date);
        noCheckRecord.setPreDutyTime(preDutyTime);
        noCheckRecord.setPreDutyTimeBeforeLimit(dutyTimeBeforeLimit);
        noCheckRecord.setPreDutyTimeAfterLimit(dutyTimeAfterLimit);
        noCheckRecord.setSourceType(AttendanceV2CheckInRecord.SOURCE_TYPE_SYSTEM_IMPORT);
        noCheckRecord.setSourceDevice("其他");
        noCheckRecord.setDescription("");
        noCheckRecord.setGroupId(group.getId());
        noCheckRecord.setGroupName(group.getGroupName());
        noCheckRecord.setGroupCheckType(group.getCheckType());
        if (shift != null) {
            noCheckRecord.setShiftId(shift.getId());
            noCheckRecord.setShiftName(shift.getShiftName());
        }
        emc.beginTransaction(AttendanceV2CheckInRecord.class);
        emc.persist(noCheckRecord, CheckPersistType.all);
        emc.commit();
        logger.info("打卡记录保存：{}, {}, {} ", person, date, checkInResult);
    }

}
