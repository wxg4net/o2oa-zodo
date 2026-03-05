package com.x.zodo.attendance.control.dto;


import com.x.base.core.project.annotation.FieldDescribe;

import java.util.Date;

public class QueryRecord {
    @FieldDescribe("员工编号")
    private String userId;
    @FieldDescribe("用户姓名")
    private String userName;
    @FieldDescribe("指定日期")
    private Date hitDate;
    @FieldDescribe("开始日期")
    private Date startDate;
    @FieldDescribe("结束日期")
    private Date endDate;

    @FieldDescribe("页数")
    private Integer pageSize;
    @FieldDescribe("总行数")
    private Integer totalRow;
    @FieldDescribe("当前页")
    private Integer pageNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getHitDate() {
        return hitDate;
    }

    public void setHitDate(Date hitDate) {
        this.hitDate = hitDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
