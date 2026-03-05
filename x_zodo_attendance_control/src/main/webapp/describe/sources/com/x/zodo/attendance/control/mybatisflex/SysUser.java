package com.x.zodo.attendance.control.mybatisflex;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统用户表
 * 对应表: center.sys_user
 */
@Table(value = "sys_user", schema = "center")
public class SysUser {

    @Id(keyType = KeyType.Auto)
    @Column("ng_id")
    private Long ngId;

    /**
     * 员工ID EMPLID
     */
    @Column("sz_employ_id")
    private String szEmployId;

    /**
     * 用户名，用户登录系统。必须有一个用户的user_name是【admin】，请手动添加。
     */
    @Column("sz_user_name")
    private String szUserName;

    /**
     * 加密后的密码
     */
    @Column("sz_password")
    private String szPassword;

    /**
     * 员工真实姓名 NAME
     */
    @Column("sz_name")
    private String szName;

    /**
     * 身份证号码
     */
    @Column("sz_card_id")
    private String szCardId;

    /**
     * 卡号
     */
    @Column("sz_card")
    private String szCard;

    /**
     * 邮箱
     */
    @Column("sz_email")
    private String szEmail;

    /**
     * -1未知 0：女 1男
     */
    @Column("nt_gender")
    private Integer ntGender;

    /**
     * 电话
     */
    @Column("sz_telephone")
    private String szTelephone;

    /**
     * 手机
     */
    @Column("sz_mobile")
    private String szMobile;

    /**
     * 出生日期
     */
    @Column("dt_birthday")
    private Date dtBirthday;

    /**
     * 居住地址
     */
    @Column("sz_address")
    private String szAddress;

    /**
     * 找回密码问题
     */
    @Column("sz_pwd_question")
    private String szPwdQuestion;

    /**
     * 找回密码答案
     */
    @Column("sz_pwd_answer")
    private String szPwdAnswer;

    /**
     * 入职日期
     */
    @Column("dt_entry")
    private Date dtEntry;

    /**
     * 开始上班时间
     */
    @Column("dt_start_work")
    private Date dtStartWork;

    /**
     * 用户登记的模版数量
     */
    @Column("nt_feature_count")
    private Integer ntFeatureCount;

    /**
     * 学历
     */
    @Column("sz_education")
    private String szEducation;

    /**
     * 民族
     */
    @Column("sz_nation")
    private String szNation;

    /**
     * 工作年限调整
     */
    @Column("nm_work_factor")
    private BigDecimal nmWorkFactor;

    /**
     * 人员照片数据存储路径
     */
    @Column("sz_photo_path")
    private String szPhotoPath;

    /**
     * 离职日期
     */
    @Column("dt_leave_date")
    private Date dtLeaveDate;

    /**
     * 离职原因
     */
    @Column("tx_leave_reason")
    private String txLeaveReason;

    @Column("nt_mobi_att_perm")
    private Integer ntMobiAttPerm;

    /**
     * 所属黑名单库id
     */
    @Column("ng_black_id")
    private Long ngBlackId;

    /**
     * 人员类型：1=白名单，2：黑名单
     */
    @Column("nt_type")
    private Integer ntType;

    /**
     * 1:正常，0：离职，-1：删除
     */
    @Column("nt_user_state")
    private Integer ntUserState;

    /**
     * 微信id
     */
    @Column("sz_openid")
    private String szOpenid;

    /**
     * 昵称，用户在考勤机上显示
     */
    @Column("sz_nick_name")
    private String szNickName;

    /**
     * 剩余的加班工时
     */
    @Column("nt_overtime_count")
    private BigDecimal ntOvertimeCount;

    /**
     * 是否黑名单人员 0：否 1：是
     */
    @Column("bt_blacklist")
    private Integer btBlacklist;

    /**
     * 最后卡点id，用于标示有新卡点来了从哪一个卡点开始计算
     */
    @Column("ng_last_card_id")
    private Long ngLastCardId;

    /**
     * 保留：是否参与考勤 0：否 1：是
     */
    @Column("bt_is_check")
    private Integer btIsCheck;

    /**
     * 保留： 上班签到规则 0:根据相应时段判断  1:必须签到
     */
    @Column("nt_begin_check")
    private Integer ntBeginCheck;

    /**
     * 保留： 下班签到规则 0:根据相应时段判断  1:必须签到
     */
    @Column("nt_end_check")
    private Integer ntEndCheck;

    /**
     * 保留：是否有节日： 0：否 1：是
     */
    @Column("bt_have_holiday")
    private Integer btHaveHoliday;

    /**
     * 是否外派人员
     */
    @Column("bt_outbound")
    private Integer btOutbound;

    /**
     * 来源，0:系统中添加，1:从人力系统导入
     */
    @Column("nt_source")
    private Integer ntSource;

    /**
     * 用于在考勤机删除（离职/黑名单）人员模板后该字段标识模板已经清除，下次同步时对该人员不做处理
     */
    @Column("nt_sync_state")
    private Integer ntSyncState;

    /**
     * 是否已和云平台同步模板和照片，1=已同步，0=未同步
     */
    @Column("nt_sync_yun_state")
    private Integer ntSyncYunState;

    /**
     * 是否增量同步，1=是，0=否
     */
    @Column("nt_increment_sync")
    private Integer ntIncrementSync;

    /**
     * 同步云平台时所用的设备sn
     */
    @Column("sz_device_sn")
    private String szDeviceSn;

    /**
     * 同步云平台时所用的照片id
     */
    @Column("sz_picture_id")
    private String szPictureId;

    /**
     * 是否与HR数据同步人员
     */
    @Column("bt_sync")
    private Integer btSync;

    @Column("nt_check_msg")
    private Integer ntCheckMsg;

    @Column("nt_check_perm")
    private Integer ntCheckPerm;

    @Column("nt_workon_msg")
    private Integer ntWorkonMsg;

    @Column("nt_workon_perm")
    private Integer ntWorkonPerm;

    @Column("nt_workend_msg")
    private Integer ntWorkendMsg;

    @Column("nt_workend_perm")
    private Integer ntWorkendPerm;

    /**
     * 创建者ID
     */
    @Column("ng_creator")
    private Long ngCreator;

    /**
     * 创建时间
     */
    @Column("ts_create")
    private Date tsCreate;

    /**
     * 修改者ID
     */
    @Column("ng_modifier_id")
    private Long ngModifierId;

    /**
     * 修改时间
     */
    @Column("dt_modify_time")
    private Date dtModifyTime;

    @Column("sz_iccard")
    private String szIccard;

    @Column("sz_recogPermission")
    private String szRecogPermission;

    @Column("dt_effective_date")
    private Date dtEffectiveDate;

    @Column("sz_modul_path")
    private String szModulPath;

    @Column("is_need_meeting_permission")
    private String isNeedMeetingPermission;

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
     * 半径
     */
    @Column("sz_radius")
    private String szRadius;

    /**
     * 电子围栏开始日期
     */
    @Column("dt_fence_begin")
    private Date dtFenceBegin;

    /**
     * 电子围栏结束日期
     */
    @Column("dt_fence_end")
    private Date dtFenceEnd;

    /**
     * 毕业学校
     */
    @Column("graduate_school")
    private String graduateSchool;

    /**
     * 籍贯
     */
    @Column("native_place")
    private String nativePlace;

    /**
     * 健康状况
     */
    @Column("health")
    private String health;

    /**
     * 学历1初中 2 高中 3大学 4研究生及其以上 5其他
     */
    @Column("education")
    private Integer education;

    /**
     * 政治面貌 1团员 2 党员 3其他
     */
    @Column("political_affiliation")
    private Integer politicalAffiliation;

    /**
     * 婚姻状况 1已婚 2 未婚3 未知
     */
    @Column("marital_status")
    private Integer maritalStatus;

    /**
     * 毕业时间
     */
    @Column("graduate_time")
    private String graduateTime;

    /**
     * 居住地址
     */
    @Column("residential_address")
    private String residentialAddress;

    /**
     * 民族
     */
    @Column("nation")
    private Integer nation;

    /**
     * 门禁号
     */
    @Column("access_card")
    private String accessCard;

    /**
     * 所属系统，0：园区;1：社区
     */
    @Column("nt_module_type")
    private Integer ntModuleType;

    /**
     * 身份证照片
     */
    @Column("sz_card_photo_path")
    private String szCardPhotoPath;

    /**
     * 应用工作地编码
     */
    @Column("nt_working_place_code")
    private String ntWorkingPlaceCode;

    /**
     * 掌纹模板数量
     */
    @Column("nt_palm_print_feature_count")
    private Integer ntPalmPrintFeatureCount;

    /**
     * 掌纹模板照片路径
     */
    @Column("sz_palm_print_photo_path")
    private String szPalmPrintPhotoPath;

    /**
     * 开门密码
     */
    @Column("open_door_password")
    private String openDoorPassword;

    /**
     * 指纹模板数量
     */
    @Column("nt_finger_feature_count")
    private Integer ntFingerFeatureCount;

    /**
     * Q系列设备裁剪照片路径
     */
    @Column("q_device_photo_path")
    private String qDevicePhotoPath;

    @Column("sz_pw_backup")
    private String szPwBackup;

    /**
     * 国密CPU卡
     */
    @Column("sz_cpu_card")
    private String szCpuCard;

    /**
     * 国密CPU卡状态（0 待激活，1 未发卡， 2 已激活，3 已挂失，4 已注销）
     */
    @Column("nt_cpu_status")
    private Integer ntCpuStatus;

    /**
     * 发卡时间
     */
    @Column("distribute_cpu_time")
    private Date distributeCpuTime;

    /**
     * 更新时间
     */
    @Column("update_cpu_time")
    private Date updateCpuTime;

    /**
     * 微信用户的openid
     */
    @Column("sz_open_id")
    private String szOpenId;

    /**
     * 小程序可视对讲开关 1：开启 0：关闭
     */
    @Column("wx_applet_talk_state")
    private Integer wxAppletTalkState;

    /**
     * 小程序应用开关 1：开启 0：关闭
     */
    @Column("wx_applet_state")
    private Integer wxAppletState;

    /**
     * 微信服务号openid
     */
    @Column("sz_mp_open_id")
    private String szMpOpenId;

    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public String getSzEmployId() {
        return szEmployId;
    }

    public void setSzEmployId(String szEmployId) {
        this.szEmployId = szEmployId;
    }

    public String getSzUserName() {
        return szUserName;
    }

    public void setSzUserName(String szUserName) {
        this.szUserName = szUserName;
    }

    public String getSzPassword() {
        return szPassword;
    }

    public void setSzPassword(String szPassword) {
        this.szPassword = szPassword;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName;
    }

    public String getSzCardId() {
        return szCardId;
    }

    public void setSzCardId(String szCardId) {
        this.szCardId = szCardId;
    }

    public String getSzCard() {
        return szCard;
    }

    public void setSzCard(String szCard) {
        this.szCard = szCard;
    }

    public String getSzEmail() {
        return szEmail;
    }

    public void setSzEmail(String szEmail) {
        this.szEmail = szEmail;
    }

    public Integer getNtGender() {
        return ntGender;
    }

    public void setNtGender(Integer ntGender) {
        this.ntGender = ntGender;
    }

    public String getSzTelephone() {
        return szTelephone;
    }

    public void setSzTelephone(String szTelephone) {
        this.szTelephone = szTelephone;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile;
    }

    public Date getDtBirthday() {
        return dtBirthday;
    }

    public void setDtBirthday(Date dtBirthday) {
        this.dtBirthday = dtBirthday;
    }

    public String getSzAddress() {
        return szAddress;
    }

    public void setSzAddress(String szAddress) {
        this.szAddress = szAddress;
    }

    public String getSzPwdQuestion() {
        return szPwdQuestion;
    }

    public void setSzPwdQuestion(String szPwdQuestion) {
        this.szPwdQuestion = szPwdQuestion;
    }

    public String getSzPwdAnswer() {
        return szPwdAnswer;
    }

    public void setSzPwdAnswer(String szPwdAnswer) {
        this.szPwdAnswer = szPwdAnswer;
    }

    public Date getDtEntry() {
        return dtEntry;
    }

    public void setDtEntry(Date dtEntry) {
        this.dtEntry = dtEntry;
    }

    public Date getDtStartWork() {
        return dtStartWork;
    }

    public void setDtStartWork(Date dtStartWork) {
        this.dtStartWork = dtStartWork;
    }

    public Integer getNtFeatureCount() {
        return ntFeatureCount;
    }

    public void setNtFeatureCount(Integer ntFeatureCount) {
        this.ntFeatureCount = ntFeatureCount;
    }

    public String getSzEducation() {
        return szEducation;
    }

    public void setSzEducation(String szEducation) {
        this.szEducation = szEducation;
    }

    public String getSzNation() {
        return szNation;
    }

    public void setSzNation(String szNation) {
        this.szNation = szNation;
    }

    public BigDecimal getNmWorkFactor() {
        return nmWorkFactor;
    }

    public void setNmWorkFactor(BigDecimal nmWorkFactor) {
        this.nmWorkFactor = nmWorkFactor;
    }

    public String getSzPhotoPath() {
        return szPhotoPath;
    }

    public void setSzPhotoPath(String szPhotoPath) {
        this.szPhotoPath = szPhotoPath;
    }

    public Date getDtLeaveDate() {
        return dtLeaveDate;
    }

    public void setDtLeaveDate(Date dtLeaveDate) {
        this.dtLeaveDate = dtLeaveDate;
    }

    public String getTxLeaveReason() {
        return txLeaveReason;
    }

    public void setTxLeaveReason(String txLeaveReason) {
        this.txLeaveReason = txLeaveReason;
    }

    public Integer getNtMobiAttPerm() {
        return ntMobiAttPerm;
    }

    public void setNtMobiAttPerm(Integer ntMobiAttPerm) {
        this.ntMobiAttPerm = ntMobiAttPerm;
    }

    public Long getNgBlackId() {
        return ngBlackId;
    }

    public void setNgBlackId(Long ngBlackId) {
        this.ngBlackId = ngBlackId;
    }

    public Integer getNtType() {
        return ntType;
    }

    public void setNtType(Integer ntType) {
        this.ntType = ntType;
    }

    public Integer getNtUserState() {
        return ntUserState;
    }

    public void setNtUserState(Integer ntUserState) {
        this.ntUserState = ntUserState;
    }

    public String getSzOpenid() {
        return szOpenid;
    }

    public void setSzOpenid(String szOpenid) {
        this.szOpenid = szOpenid;
    }

    public String getSzNickName() {
        return szNickName;
    }

    public void setSzNickName(String szNickName) {
        this.szNickName = szNickName;
    }

    public BigDecimal getNtOvertimeCount() {
        return ntOvertimeCount;
    }

    public void setNtOvertimeCount(BigDecimal ntOvertimeCount) {
        this.ntOvertimeCount = ntOvertimeCount;
    }

    public Integer getBtBlacklist() {
        return btBlacklist;
    }

    public void setBtBlacklist(Integer btBlacklist) {
        this.btBlacklist = btBlacklist;
    }

    public Long getNgLastCardId() {
        return ngLastCardId;
    }

    public void setNgLastCardId(Long ngLastCardId) {
        this.ngLastCardId = ngLastCardId;
    }

    public Integer getBtIsCheck() {
        return btIsCheck;
    }

    public void setBtIsCheck(Integer btIsCheck) {
        this.btIsCheck = btIsCheck;
    }

    public Integer getNtBeginCheck() {
        return ntBeginCheck;
    }

    public void setNtBeginCheck(Integer ntBeginCheck) {
        this.ntBeginCheck = ntBeginCheck;
    }

    public Integer getNtEndCheck() {
        return ntEndCheck;
    }

    public void setNtEndCheck(Integer ntEndCheck) {
        this.ntEndCheck = ntEndCheck;
    }

    public Integer getBtHaveHoliday() {
        return btHaveHoliday;
    }

    public void setBtHaveHoliday(Integer btHaveHoliday) {
        this.btHaveHoliday = btHaveHoliday;
    }

    public Integer getBtOutbound() {
        return btOutbound;
    }

    public void setBtOutbound(Integer btOutbound) {
        this.btOutbound = btOutbound;
    }

    public Integer getNtSource() {
        return ntSource;
    }

    public void setNtSource(Integer ntSource) {
        this.ntSource = ntSource;
    }

    public Integer getNtSyncState() {
        return ntSyncState;
    }

    public void setNtSyncState(Integer ntSyncState) {
        this.ntSyncState = ntSyncState;
    }

    public Integer getNtSyncYunState() {
        return ntSyncYunState;
    }

    public void setNtSyncYunState(Integer ntSyncYunState) {
        this.ntSyncYunState = ntSyncYunState;
    }

    public Integer getNtIncrementSync() {
        return ntIncrementSync;
    }

    public void setNtIncrementSync(Integer ntIncrementSync) {
        this.ntIncrementSync = ntIncrementSync;
    }

    public String getSzDeviceSn() {
        return szDeviceSn;
    }

    public void setSzDeviceSn(String szDeviceSn) {
        this.szDeviceSn = szDeviceSn;
    }

    public String getSzPictureId() {
        return szPictureId;
    }

    public void setSzPictureId(String szPictureId) {
        this.szPictureId = szPictureId;
    }

    public Integer getBtSync() {
        return btSync;
    }

    public void setBtSync(Integer btSync) {
        this.btSync = btSync;
    }

    public Integer getNtCheckMsg() {
        return ntCheckMsg;
    }

    public void setNtCheckMsg(Integer ntCheckMsg) {
        this.ntCheckMsg = ntCheckMsg;
    }

    public Integer getNtCheckPerm() {
        return ntCheckPerm;
    }

    public void setNtCheckPerm(Integer ntCheckPerm) {
        this.ntCheckPerm = ntCheckPerm;
    }

    public Integer getNtWorkonMsg() {
        return ntWorkonMsg;
    }

    public void setNtWorkonMsg(Integer ntWorkonMsg) {
        this.ntWorkonMsg = ntWorkonMsg;
    }

    public Integer getNtWorkonPerm() {
        return ntWorkonPerm;
    }

    public void setNtWorkonPerm(Integer ntWorkonPerm) {
        this.ntWorkonPerm = ntWorkonPerm;
    }

    public Integer getNtWorkendMsg() {
        return ntWorkendMsg;
    }

    public void setNtWorkendMsg(Integer ntWorkendMsg) {
        this.ntWorkendMsg = ntWorkendMsg;
    }

    public Integer getNtWorkendPerm() {
        return ntWorkendPerm;
    }

    public void setNtWorkendPerm(Integer ntWorkendPerm) {
        this.ntWorkendPerm = ntWorkendPerm;
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

    public Long getNgModifierId() {
        return ngModifierId;
    }

    public void setNgModifierId(Long ngModifierId) {
        this.ngModifierId = ngModifierId;
    }

    public Date getDtModifyTime() {
        return dtModifyTime;
    }

    public void setDtModifyTime(Date dtModifyTime) {
        this.dtModifyTime = dtModifyTime;
    }

    public String getSzIccard() {
        return szIccard;
    }

    public void setSzIccard(String szIccard) {
        this.szIccard = szIccard;
    }

    public String getSzRecogPermission() {
        return szRecogPermission;
    }

    public void setSzRecogPermission(String szRecogPermission) {
        this.szRecogPermission = szRecogPermission;
    }

    public Date getDtEffectiveDate() {
        return dtEffectiveDate;
    }

    public void setDtEffectiveDate(Date dtEffectiveDate) {
        this.dtEffectiveDate = dtEffectiveDate;
    }

    public String getSzModulPath() {
        return szModulPath;
    }

    public void setSzModulPath(String szModulPath) {
        this.szModulPath = szModulPath;
    }

    public String getIsNeedMeetingPermission() {
        return isNeedMeetingPermission;
    }

    public void setIsNeedMeetingPermission(String isNeedMeetingPermission) {
        this.isNeedMeetingPermission = isNeedMeetingPermission;
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

    public String getSzRadius() {
        return szRadius;
    }

    public void setSzRadius(String szRadius) {
        this.szRadius = szRadius;
    }

    public Date getDtFenceBegin() {
        return dtFenceBegin;
    }

    public void setDtFenceBegin(Date dtFenceBegin) {
        this.dtFenceBegin = dtFenceBegin;
    }

    public Date getDtFenceEnd() {
        return dtFenceEnd;
    }

    public void setDtFenceEnd(Date dtFenceEnd) {
        this.dtFenceEnd = dtFenceEnd;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getPoliticalAffiliation() {
        return politicalAffiliation;
    }

    public void setPoliticalAffiliation(Integer politicalAffiliation) {
        this.politicalAffiliation = politicalAffiliation;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(String graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public String getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(String accessCard) {
        this.accessCard = accessCard;
    }

    public Integer getNtModuleType() {
        return ntModuleType;
    }

    public void setNtModuleType(Integer ntModuleType) {
        this.ntModuleType = ntModuleType;
    }

    public String getSzCardPhotoPath() {
        return szCardPhotoPath;
    }

    public void setSzCardPhotoPath(String szCardPhotoPath) {
        this.szCardPhotoPath = szCardPhotoPath;
    }

    public String getNtWorkingPlaceCode() {
        return ntWorkingPlaceCode;
    }

    public void setNtWorkingPlaceCode(String ntWorkingPlaceCode) {
        this.ntWorkingPlaceCode = ntWorkingPlaceCode;
    }

    public Integer getNtPalmPrintFeatureCount() {
        return ntPalmPrintFeatureCount;
    }

    public void setNtPalmPrintFeatureCount(Integer ntPalmPrintFeatureCount) {
        this.ntPalmPrintFeatureCount = ntPalmPrintFeatureCount;
    }

    public String getSzPalmPrintPhotoPath() {
        return szPalmPrintPhotoPath;
    }

    public void setSzPalmPrintPhotoPath(String szPalmPrintPhotoPath) {
        this.szPalmPrintPhotoPath = szPalmPrintPhotoPath;
    }

    public String getOpenDoorPassword() {
        return openDoorPassword;
    }

    public void setOpenDoorPassword(String openDoorPassword) {
        this.openDoorPassword = openDoorPassword;
    }

    public Integer getNtFingerFeatureCount() {
        return ntFingerFeatureCount;
    }

    public void setNtFingerFeatureCount(Integer ntFingerFeatureCount) {
        this.ntFingerFeatureCount = ntFingerFeatureCount;
    }

    public String getQDevicePhotoPath() {
        return qDevicePhotoPath;
    }

    public void setQDevicePhotoPath(String qDevicePhotoPath) {
        this.qDevicePhotoPath = qDevicePhotoPath;
    }

    public String getSzPwBackup() {
        return szPwBackup;
    }

    public void setSzPwBackup(String szPwBackup) {
        this.szPwBackup = szPwBackup;
    }

    public String getSzCpuCard() {
        return szCpuCard;
    }

    public void setSzCpuCard(String szCpuCard) {
        this.szCpuCard = szCpuCard;
    }

    public Integer getNtCpuStatus() {
        return ntCpuStatus;
    }

    public void setNtCpuStatus(Integer ntCpuStatus) {
        this.ntCpuStatus = ntCpuStatus;
    }

    public Date getDistributeCpuTime() {
        return distributeCpuTime;
    }

    public void setDistributeCpuTime(Date distributeCpuTime) {
        this.distributeCpuTime = distributeCpuTime;
    }

    public Date getUpdateCpuTime() {
        return updateCpuTime;
    }

    public void setUpdateCpuTime(Date updateCpuTime) {
        this.updateCpuTime = updateCpuTime;
    }

    public String getSzOpenId() {
        return szOpenId;
    }

    public void setSzOpenId(String szOpenId) {
        this.szOpenId = szOpenId;
    }

    public Integer getWxAppletTalkState() {
        return wxAppletTalkState;
    }

    public void setWxAppletTalkState(Integer wxAppletTalkState) {
        this.wxAppletTalkState = wxAppletTalkState;
    }

    public Integer getWxAppletState() {
        return wxAppletState;
    }

    public void setWxAppletState(Integer wxAppletState) {
        this.wxAppletState = wxAppletState;
    }

    public String getSzMpOpenId() {
        return szMpOpenId;
    }

    public void setSzMpOpenId(String szMpOpenId) {
        this.szMpOpenId = szMpOpenId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "ngId=" + ngId +
                ", szEmployId='" + szEmployId + '\'' +
                ", szUserName='" + szUserName + '\'' +
                ", szPassword='" + szPassword + '\'' +
                ", szName='" + szName + '\'' +
                ", szCardId='" + szCardId + '\'' +
                ", szCard='" + szCard + '\'' +
                ", szEmail='" + szEmail + '\'' +
                ", ntGender=" + ntGender +
                ", szTelephone='" + szTelephone + '\'' +
                ", szMobile='" + szMobile + '\'' +
                ", dtBirthday=" + dtBirthday +
                ", szAddress='" + szAddress + '\'' +
                ", szPwdQuestion='" + szPwdQuestion + '\'' +
                ", szPwdAnswer='" + szPwdAnswer + '\'' +
                ", dtEntry=" + dtEntry +
                ", dtStartWork=" + dtStartWork +
                ", ntFeatureCount=" + ntFeatureCount +
                ", szEducation='" + szEducation + '\'' +
                ", szNation='" + szNation + '\'' +
                ", nmWorkFactor=" + nmWorkFactor +
                ", szPhotoPath='" + szPhotoPath + '\'' +
                ", dtLeaveDate=" + dtLeaveDate +
                ", txLeaveReason='" + txLeaveReason + '\'' +
                ", ntMobiAttPerm=" + ntMobiAttPerm +
                ", ngBlackId=" + ngBlackId +
                ", ntType=" + ntType +
                ", ntUserState=" + ntUserState +
                ", szOpenid='" + szOpenid + '\'' +
                ", szNickName='" + szNickName + '\'' +
                ", ntOvertimeCount=" + ntOvertimeCount +
                ", btBlacklist=" + btBlacklist +
                ", ngLastCardId=" + ngLastCardId +
                ", btIsCheck=" + btIsCheck +
                ", ntBeginCheck=" + ntBeginCheck +
                ", ntEndCheck=" + ntEndCheck +
                ", btHaveHoliday=" + btHaveHoliday +
                ", btOutbound=" + btOutbound +
                ", ntSource=" + ntSource +
                ", ntSyncState=" + ntSyncState +
                ", ntSyncYunState=" + ntSyncYunState +
                ", ntIncrementSync=" + ntIncrementSync +
                ", szDeviceSn='" + szDeviceSn + '\'' +
                ", szPictureId='" + szPictureId + '\'' +
                ", btSync=" + btSync +
                ", ntCheckMsg=" + ntCheckMsg +
                ", ntCheckPerm=" + ntCheckPerm +
                ", ntWorkonMsg=" + ntWorkonMsg +
                ", ntWorkonPerm=" + ntWorkonPerm +
                ", ntWorkendMsg=" + ntWorkendMsg +
                ", ntWorkendPerm=" + ntWorkendPerm +
                ", ngCreator=" + ngCreator +
                ", tsCreate=" + tsCreate +
                ", ngModifierId=" + ngModifierId +
                ", dtModifyTime=" + dtModifyTime +
                ", szIccard='" + szIccard + '\'' +
                ", szRecogPermission='" + szRecogPermission + '\'' +
                ", dtEffectiveDate=" + dtEffectiveDate +
                ", szModulPath='" + szModulPath + '\'' +
                ", isNeedMeetingPermission='" + isNeedMeetingPermission + '\'' +
                ", szLng='" + szLng + '\'' +
                ", szLat='" + szLat + '\'' +
                ", szRadius='" + szRadius + '\'' +
                ", dtFenceBegin=" + dtFenceBegin +
                ", dtFenceEnd=" + dtFenceEnd +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", health='" + health + '\'' +
                ", education=" + education +
                ", politicalAffiliation=" + politicalAffiliation +
                ", maritalStatus=" + maritalStatus +
                ", graduateTime='" + graduateTime + '\'' +
                ", residentialAddress='" + residentialAddress + '\'' +
                ", nation=" + nation +
                ", accessCard='" + accessCard + '\'' +
                ", ntModuleType=" + ntModuleType +
                ", szCardPhotoPath='" + szCardPhotoPath + '\'' +
                ", ntWorkingPlaceCode='" + ntWorkingPlaceCode + '\'' +
                ", ntPalmPrintFeatureCount=" + ntPalmPrintFeatureCount +
                ", szPalmPrintPhotoPath='" + szPalmPrintPhotoPath + '\'' +
                ", openDoorPassword='" + openDoorPassword + '\'' +
                ", ntFingerFeatureCount=" + ntFingerFeatureCount +
                ", qDevicePhotoPath='" + qDevicePhotoPath + '\'' +
                ", szPwBackup='" + szPwBackup + '\'' +
                ", szCpuCard='" + szCpuCard + '\'' +
                ", ntCpuStatus=" + ntCpuStatus +
                ", distributeCpuTime=" + distributeCpuTime +
                ", updateCpuTime=" + updateCpuTime +
                ", szOpenId='" + szOpenId + '\'' +
                ", wxAppletTalkState=" + wxAppletTalkState +
                ", wxAppletState=" + wxAppletState +
                ", szMpOpenId='" + szMpOpenId + '\'' +
                '}';
    }
}
