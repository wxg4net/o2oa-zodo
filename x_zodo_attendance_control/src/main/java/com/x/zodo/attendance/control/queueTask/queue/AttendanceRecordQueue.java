package com.x.zodo.attendance.control.queueTask.queue;


public class AttendanceRecordQueue {
    private String userId = null;
    private String userName = null;
    private String hitTime = null;

    public AttendanceRecordQueue() {
    }

    public AttendanceRecordQueue( String userId, String userName, String hitTime) {
        this.userId = userId;
        this.userName = userName;
        this.hitTime = hitTime;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getHitTime() {
        return hitTime;
    }
    public void setHitTime(String hitTime) {
        this.hitTime = hitTime;
    }

}
