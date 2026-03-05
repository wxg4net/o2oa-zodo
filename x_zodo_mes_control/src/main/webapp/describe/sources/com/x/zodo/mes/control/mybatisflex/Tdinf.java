package com.x.zodo.mes.control.mybatisflex;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.util.Date;

/**
 * 实体类
 * 对应表: WMS.dbo.TDINF
 */
@Table(value = "TDINF", schema = "dbo")
public class Tdinf {

    @Id(keyType = KeyType.None)
    @Column("MACCD")
    private String macCd;

    @Column("DEVID")
    private String devId;

    @Column("REGCD")
    private String regCd;

    @Column("devIf")
    private String devIf;

    @Column("DEVFG")
    private String devFg;

    @Column("Enabled")
    private String enabled;

    @Column("SortCode")
    private String sortCode;

    @Column("DeleteMark")
    private Integer deleteMark;

    @Column("Remark")
    private String remark;

    @Column("CreateDate")
    private Date createDate;

    @Column("CreateUserId")
    private String createUserId;

    @Column("CreateUserName")
    private String createUserName;

    @Column("ModifyDate")
    private Date modifyDate;

    @Column("ModifyUserId")
    private String modifyUserId;

    @Column("ModifyUserName")
    private String modifyUserName;

    @Column("AppVersion")
    private String appVersion;

    @Column("LoginTime")
    private Date loginTime;

    @Column("LastLoginName")
    private String lastLoginName;

    public String getMacCd() {
        return macCd;
    }

    public void setMacCd(String macCd) {
        this.macCd = macCd;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getRegCd() {
        return regCd;
    }

    public void setRegCd(String regCd) {
        this.regCd = regCd;
    }

    public String getDevIf() {
        return devIf;
    }

    public void setDevIf(String devIf) {
        this.devIf = devIf;
    }

    public String getDevFg() {
        return devFg;
    }

    public void setDevFg(String devFg) {
        this.devFg = devFg;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public Integer getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastLoginName() {
        return lastLoginName;
    }

    public void setLastLoginName(String lastLoginName) {
        this.lastLoginName = lastLoginName;
    }

    @Override
    public String toString() {
        return "Tdinf{" +
                "macCd='" + macCd + '\'' +
                ", devId='" + devId + '\'' +
                ", regCd='" + regCd + '\'' +
                ", devIf='" + devIf + '\'' +
                ", devfg='" + devFg + '\'' +
                ", enabled='" + enabled + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", deleteMark=" + deleteMark +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                ", createUserId='" + createUserId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", modifyDate=" + modifyDate +
                ", modifyUserId='" + modifyUserId + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", loginTime=" + loginTime +
                ", lastLoginName='" + lastLoginName + '\'' +
                '}';
    }
}
