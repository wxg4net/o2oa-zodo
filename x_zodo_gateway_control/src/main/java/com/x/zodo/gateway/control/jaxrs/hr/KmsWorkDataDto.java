package com.x.zodo.gateway.control.jaxrs.hr;

import com.google.gson.JsonElement;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.organization.core.entity.Person;

import java.util.Date;
import java.util.List;

public class KmsWorkDataDto {
    @FieldDescribe( "数据表格" )
    private JsonElement datatable;
    @FieldDescribe( "人力资源" )
    private List<Person> hrManager;
    @FieldDescribe( "定时发布" )
    private Date kmsPublishTime;
    @FieldDescribe( "流程主题" )
    private String subject;
    @FieldDescribe( "流程主题" )
    private String title;
    @FieldDescribe( "薪资开始日期" )
    private String startDate;
    @FieldDescribe( "薪资类型" )
    private String salaryType;

    @FieldDescribe( "薪资结束日期" )
    private String endDate;

    public JsonElement getDatatable() {
        return datatable;
    }
    public void setDatatable(JsonElement datatable) {
        this.datatable = datatable;
    }

    public List<Person> getHrManager() {
        return hrManager;
    }

    public void setHrManager(List<Person> hrManager) {
        this.hrManager = hrManager;
    }

    public Date getKmsPublishTime() {
        return kmsPublishTime;
    }

    public void setKmsPublishTime(Date kmsPublishTime) {
        this.kmsPublishTime = kmsPublishTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }


}