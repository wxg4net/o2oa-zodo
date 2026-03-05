package com.x.zodo.attendance.control.mybatisflex;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.x.base.core.entity.SliceJpaObject;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 考勤记录实体类
 * 对应表: center.stat_card
 */
@Table(value = "stat_card", schema = "center")
public class StatCard {

    /**
     * 主键ID
     */
    @Id(keyType = KeyType.Auto)
    @Column("ng_id")
    private Long ngId;

    /**
     * 0:从考勤机取得，1：手动添加
     */
    @Column("st_kind")
    private Integer stKind;

    /**
     * 用户ID
     */
    @Column("ng_user_id")
    private Long ngUserId;

    @Column("ng_branch_id")
    private Long ngBranchId;

    /**
     * 设备ID
     */
    @Column("ng_dev_id")
    private Long ngDevId;

    /**
     * 打卡时间
     */
    @Column("ts_card")
    private Date tsCard;

    /**
     * 保留字段：打卡类型 0:一般卡; 1:上班; 2:下班; 3:加班上班; 4:加班下班; 5:外出; 6:回来
     */
    @Column("st_card_type")
    private Long stCardType;

    /**
     * 设备类型 0:考勤机 1:门禁机
     */
    @Column("st_dev_class")
    private Integer stDevClass;

    /**
     * 验证字段，是EmployeeID，CardTime的校验和，防止手动添加【废弃字段】
     */
    @Column("sz_verify")
    private String szVerify;

    /**
     * 卡点是否有效 0:无效;1:有效
     */
    @Column("bt_validate")
    private Integer btValidate;

    /**
     * 漏打卡申请单
     */
    @Column("ng_forget_id")
    private Long ngForgetId;

    /**
     * 0:未修改; >0:修改该卡点的管理员ID
     */
    @Column("ng_modify_id")
    private Long ngModifyId;

    /**
     * 0:未赋值; 1:删除；2：修改时间； 3：修改类型；4：添加
     */
    @Column("st_modify_type")
    private Integer stModifyType;

    /**
     * 修改时间
     */
    @Column("ts_modify")
    private Date tsModify;

    /**
     * 打卡地点标识：0=异地，1=本地
     */
    @Column("bt_native")
    private Integer btNative;

    /**
     * 卡点照片存储路径
     */
    @Column("sz_photo_path")
    private String szPhotoPath;

    /**
     * 卡点照片存储路径
     */
    @Column("sz_register_path")
    private String szRegisterPath;

    /**
     * 条目创建者ID
     */
    @Column("ng_creator")
    private Long ngCreator;

    /**
     * 条目创建时间
     */
    @Column("ts_create")
    private Date tsCreate;

    @Column("sz_branch_name")
    private String szBranchName;

    @Column("sz_user_name")
    private String szUserName;

    @Column("sz_employ_id")
    private String szEmployId;

    @Column("sz_dev_name")
    private String szDevName;

    @Column("sz_dev_place")
    private String szDevPlace;

    /**
     * 人员类型0正式1临时
     */
    @Column("nt_employ_type")
    private Integer ntEmployType;

    /**
     * 识别模式
     */
    @Column("nt_reco_mode")
    private Integer ntRecoMode;

    /**
     * 通道式识别阈值
     */
    @Column("ft_threshold")
    private Float ftThreshold;

    /**
     * 通道式识别得分
     */
    @Column("ft_score")
    private Float ftScore;

    /**
     * 通道式背景图
     */
    @Column("sz_image_path")
    private String szImagePath;

    /**
     * 识别图片特征存储路径
     */
    @Column("sz_feature_path")
    private String szFeaturePath;

    /**
     * 人脸图在背景图中的位置，第一个字节代表左，第二个字节代表上，第三个字节代表右，第四个字节代表下。取值范围0-100，百分比
     */
    @Column("nt_position")
    private Integer ntPosition;

    /**
     * 与当前识别记录匹配的人员特征id
     */
    @Column("ng_feature_id")
    private Long ngFeatureId;

    /**
     * 与当前识别记录匹配的人员特征路径，冗余字段
     */
    @Column("sz_feature_photo_path")
    private String szFeaturePhotoPath;

    /**
     * 经度
     */
    @Column("sz_lng")
    private String szLng;

    /**
     * 纬度
     */
    @Column("sz_lat")
    private String szLat;

    /**
     * 体温
     */
    @Column("animal_heat")
    private String animalHeat;

    /**
     * 是否佩戴口罩(1:佩戴，2:未佩戴)
     */
    @Column("wear_mask")
    private Integer wearMask;

    /**
     * 海外英文版本专用字段
     */
    @Column("work_status")
    private String workStatus;

    /**
     * 海外英文版本专用字段
     */
    @Column("work_code")
    private String workCode;

    /**
     * 0=未通过，1=通过，2=手动强制通过，其他值=未通过
     */
    @Column("sz_pass")
    private String szPass;

    /**
     * 区别掌纹设备='1'、单人脸设备='0'
     */
    @Column("dev_type")
    private String devType;

    @Column("sz_palm_print_photo_path")
    private String szPalmPrintPhotoPath;

    /**
     * 0:人脸 1：掌纹 2：指纹
     */
    @Column("nt_reco_type")
    private Integer ntRecoType;

    @Column("sz_signature")
    private String szSignature;

    /**
     * 设备方向 1：进 2：出 0：不限
     */
    @Column("access")
    private Integer access;

    // Getter和Setter方法
    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public Integer getStKind() {
        return stKind;
    }

    public void setStKind(Integer stKind) {
        this.stKind = stKind;
    }

    public Long getNgUserId() {
        return ngUserId;
    }

    public void setNgUserId(Long ngUserId) {
        this.ngUserId = ngUserId;
    }

    public Long getNgBranchId() {
        return ngBranchId;
    }

    public void setNgBranchId(Long ngBranchId) {
        this.ngBranchId = ngBranchId;
    }

    public Long getNgDevId() {
        return ngDevId;
    }

    public void setNgDevId(Long ngDevId) {
        this.ngDevId = ngDevId;
    }

    public Date getTsCard() {
        return tsCard;
    }

    public void setTsCard(Date tsCard) {
        this.tsCard = tsCard;
    }

    public Long getStCardType() {
        return stCardType;
    }

    public void setStCardType(Long stCardType) {
        this.stCardType = stCardType;
    }

    public Integer getStDevClass() {
        return stDevClass;
    }

    public void setStDevClass(Integer stDevClass) {
        this.stDevClass = stDevClass;
    }

    public String getSzVerify() {
        return szVerify;
    }

    public void setSzVerify(String szVerify) {
        this.szVerify = szVerify;
    }

    public Integer getBtValidate() {
        return btValidate;
    }

    public void setBtValidate(Integer btValidate) {
        this.btValidate = btValidate;
    }

    public Long getNgForgetId() {
        return ngForgetId;
    }

    public void setNgForgetId(Long ngForgetId) {
        this.ngForgetId = ngForgetId;
    }

    public Long getNgModifyId() {
        return ngModifyId;
    }

    public void setNgModifyId(Long ngModifyId) {
        this.ngModifyId = ngModifyId;
    }

    public Integer getStModifyType() {
        return stModifyType;
    }

    public void setStModifyType(Integer stModifyType) {
        this.stModifyType = stModifyType;
    }

    public Date getTsModify() {
        return tsModify;
    }

    public void setTsModify(Date tsModify) {
        this.tsModify = tsModify;
    }

    public Integer getBtNative() {
        return btNative;
    }

    public void setBtNative(Integer btNative) {
        this.btNative = btNative;
    }

    public String getSzPhotoPath() {
        return szPhotoPath;
    }

    public void setSzPhotoPath(String szPhotoPath) {
        this.szPhotoPath = szPhotoPath;
    }

    public String getSzRegisterPath() {
        return szRegisterPath;
    }

    public void setSzRegisterPath(String szRegisterPath) {
        this.szRegisterPath = szRegisterPath;
    }

    public Long getNgCreator() {
        return ngCreator;
    }

    public void setNgCreator(Long ngCreator) {
        this.ngCreator = ngCreator;
    }

    public Date getTsCreate() {
        return tsCreate;
    }

    public void setTsCreate(Date tsCreate) {
        this.tsCreate = tsCreate;
    }

    public String getSzBranchName() {
        return szBranchName;
    }

    public void setSzBranchName(String szBranchName) {
        this.szBranchName = szBranchName;
    }

    public String getSzUserName() {
        return szUserName;
    }

    public void setSzUserName(String szUserName) {
        this.szUserName = szUserName;
    }

    public String getSzEmployId() {
        return szEmployId;
    }

    public void setSzEmployId(String szEmployId) {
        this.szEmployId = szEmployId;
    }

    public String getSzDevName() {
        return szDevName;
    }

    public void setSzDevName(String szDevName) {
        this.szDevName = szDevName;
    }

    public String getSzDevPlace() {
        return szDevPlace;
    }

    public void setSzDevPlace(String szDevPlace) {
        this.szDevPlace = szDevPlace;
    }

    public Integer getNtEmployType() {
        return ntEmployType;
    }

    public void setNtEmployType(Integer ntEmployType) {
        this.ntEmployType = ntEmployType;
    }

    public Integer getNtRecoMode() {
        return ntRecoMode;
    }

    public void setNtRecoMode(Integer ntRecoMode) {
        this.ntRecoMode = ntRecoMode;
    }

    public Float getFtThreshold() {
        return ftThreshold;
    }

    public void setFtThreshold(Float ftThreshold) {
        this.ftThreshold = ftThreshold;
    }

    public Float getFtScore() {
        return ftScore;
    }

    public void setFtScore(Float ftScore) {
        this.ftScore = ftScore;
    }

    public String getSzImagePath() {
        return szImagePath;
    }

    public void setSzImagePath(String szImagePath) {
        this.szImagePath = szImagePath;
    }

    public String getSzFeaturePath() {
        return szFeaturePath;
    }

    public void setSzFeaturePath(String szFeaturePath) {
        this.szFeaturePath = szFeaturePath;
    }

    public Integer getNtPosition() {
        return ntPosition;
    }

    public void setNtPosition(Integer ntPosition) {
        this.ntPosition = ntPosition;
    }

    public Long getNgFeatureId() {
        return ngFeatureId;
    }

    public void setNgFeatureId(Long ngFeatureId) {
        this.ngFeatureId = ngFeatureId;
    }

    public String getSzFeaturePhotoPath() {
        return szFeaturePhotoPath;
    }

    public void setSzFeaturePhotoPath(String szFeaturePhotoPath) {
        this.szFeaturePhotoPath = szFeaturePhotoPath;
    }

    public String getSzLng() {
        return szLng;
    }

    public void setSzLng(String szLng) {
        this.szLng = szLng;
    }

    public String getSzLat() {
        return szLat;
    }

    public void setSzLat(String szLat) {
        this.szLat = szLat;
    }

    public String getAnimalHeat() {
        return animalHeat;
    }

    public void setAnimalHeat(String animalHeat) {
        this.animalHeat = animalHeat;
    }

    public Integer getWearMask() {
        return wearMask;
    }

    public void setWearMask(Integer wearMask) {
        this.wearMask = wearMask;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getSzPass() {
        return szPass;
    }

    public void setSzPass(String szPass) {
        this.szPass = szPass;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getSzPalmPrintPhotoPath() {
        return szPalmPrintPhotoPath;
    }

    public void setSzPalmPrintPhotoPath(String szPalmPrintPhotoPath) {
        this.szPalmPrintPhotoPath = szPalmPrintPhotoPath;
    }

    public Integer getNtRecoType() {
        return ntRecoType;
    }

    public void setNtRecoType(Integer ntRecoType) {
        this.ntRecoType = ntRecoType;
    }

    public String getSzSignature() {
        return szSignature;
    }

    public void setSzSignature(String szSignature) {
        this.szSignature = szSignature;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "StatCard{" +
                "ngId=" + ngId +
                ", stKind=" + stKind +
                ", ngUserId=" + ngUserId +
                ", ngBranchId=" + ngBranchId +
                ", ngDevId=" + ngDevId +
                ", tsCard=" + tsCard +
                ", stCardType=" + stCardType +
                ", stDevClass=" + stDevClass +
                ", szVerify='" + szVerify + '\'' +
                ", btValidate=" + btValidate +
                ", ngForgetId=" + ngForgetId +
                ", ngModifyId=" + ngModifyId +
                ", stModifyType=" + stModifyType +
                ", tsModify=" + tsModify +
                ", btNative=" + btNative +
                ", szPhotoPath='" + szPhotoPath + '\'' +
                ", szRegisterPath='" + szRegisterPath + '\'' +
                ", ngCreator=" + ngCreator +
                ", tsCreate=" + tsCreate +
                ", szBranchName='" + szBranchName + '\'' +
                ", szUserName='" + szUserName + '\'' +
                ", szEmployId='" + szEmployId + '\'' +
                ", szDevName='" + szDevName + '\'' +
                ", szDevPlace='" + szDevPlace + '\'' +
                ", ntEmployType=" + ntEmployType +
                ", ntRecoMode=" + ntRecoMode +
                ", ftThreshold=" + ftThreshold +
                ", ftScore=" + ftScore +
                ", szImagePath='" + szImagePath + '\'' +
                ", szFeaturePath='" + szFeaturePath + '\'' +
                ", ntPosition=" + ntPosition +
                ", ngFeatureId=" + ngFeatureId +
                ", szFeaturePhotoPath='" + szFeaturePhotoPath + '\'' +
                ", szLng='" + szLng + '\'' +
                ", szLat='" + szLat + '\'' +
                ", animalHeat='" + animalHeat + '\'' +
                ", wearMask=" + wearMask +
                ", workStatus='" + workStatus + '\'' +
                ", workCode='" + workCode + '\'' +
                ", szPass='" + szPass + '\'' +
                ", devType='" + devType + '\'' +
                ", szPalmPrintPhotoPath='" + szPalmPrintPhotoPath + '\'' +
                ", ntRecoType=" + ntRecoType +
                ", szSignature='" + szSignature + '\'' +
                ", access=" + access +
                '}';
    }
}
