package com.x.zodo.gateway.control.jaxrs.hr;

import com.x.base.core.project.gson.GsonPropertyObject;

public class KmsSalaryDto extends GsonPropertyObject {
    private String userId;
    private String userName;
    private String amount;
    private String netSalary;

    public KmsSalaryDto() {
    }

    public KmsSalaryDto(String userId, String userName, String amount, String netSalary) {
        this.userId = userId;
        this.userName = userName;
        this.amount = amount;
        this.netSalary = netSalary;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(String netSalary) {
        this.netSalary = netSalary;
    }
}
