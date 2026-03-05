package com.x.zodo.gateway.control.queueTask.queue;

import com.x.zodo.gateway.control.jaxrs.hr.KmsSalaryDto;

import java.util.Map;

public class KmsProcessRecordQueue {

    private String targetProcessId;
    private String startDate;
    private String endDate;
    private String salaryType;
    private Map kmsSalaryDto;

    public KmsProcessRecordQueue() {
    }

    public KmsProcessRecordQueue(String targetProcessId, String salaryType, String startDate, String endDate, Map kmsSalaryDto) {
        this.targetProcessId = targetProcessId;
        this.salaryType = salaryType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kmsSalaryDto = kmsSalaryDto;
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

    public Map<String, Object> getKmsSalaryDto() {
        return kmsSalaryDto;
    }

    public void setKmsSalaryDto(Map<String, Object> kmsSalaryDto) {
        this.kmsSalaryDto = kmsSalaryDto;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getTargetProcessId() {
        return targetProcessId;
    }

    public void setTargetProcessId(String targetProcessId) {
        this.targetProcessId = targetProcessId;
    }
}
