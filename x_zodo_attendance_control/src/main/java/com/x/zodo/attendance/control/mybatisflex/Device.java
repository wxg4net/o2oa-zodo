package com.x.zodo.attendance.control.mybatisflex;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.util.Date;


/**
* 考勤机实体类
* 对应表: center.dev_device
*/
@Table(value = "dev_device", schema = "center")
public  class Device {

    /**
     * 主键ID
     */
    @Id(keyType = KeyType.Auto)
    @Column("ng_id")
    private Long ngId;

    /**
     * 考勤机名称
     */
    @Column("sz_name")
    private String szName;

    /**
     * 考勤机类型，如C330，C226
     */
    @Column("sz_type")
    private String szType;

    /**
     * 考勤机识别算法版本，用于判断模板兼容性
     */
    @Column("sz_algorithm_edition")
    private String szAlgorithmEdition;

    /**
     * 设备类型 0:考勤机  1:门禁机
     */
    @Column("st_dev_class")
    private Integer stDevClass;

    /**
     * 考勤机ip地址
     */
    @Column("sz_ip_addr")
    private String szIpAddr;

    /**
     * 最后一次下载记录的时间
     */
    @Column("ts_last_rcd")
    private Date tsLastRcd;

    /**
     * 通信密码
     */
    @Column("sz_dev_pwd")
    private String szDevPwd;

    /**
     * 子网掩码
     */
    @Column("sz_mask")
    private String szMask;

    /**
     * 网关
     */
    @Column("sz_gateway")
    private String szGateway;

    /**
     * MAC地址
     */
    @Column("sz_mac")
    private String szMac;

    /**
     * 设备序列号
     */
    @Column("sz_serial")
    private String szSerial;

    /**
     * 考勤机软件版本号
     */
    @Column("sz_rom_edition")
    private String szRomEdition;

    /**
     * 音量
     */
    @Column("sz_volume")
    private String szVolume;

    /**
     * 安装位置
     */
    @Column("sz_place")
    private String szPlace;

    /**
     * 用户总容量，程序自动更新
     */
    @Column("nt_user_capacity")
    private Integer ntUserCapacity;

    /**
     * 用户容量的使用量，程序自动维护
     */
    @Column("nt_user_used")
    private Integer ntUserUsed;

    /**
     * 记录总容量，程序自动维护
     */
    @Column("nt_rcd_capacity")
    private Integer ntRcdCapacity;

    /**
     * 设备监控程序ID
     */
    @Column("dev_monitor_id")
    private Long devMonitorId;

    /**
     * 记录已经使用的容量，程序自动维护
     */
    @Column("nt_rcd_used")
    private Integer ntRcdUsed;

    /**
     * 考勤机的最后活动时间，程序自动维护
     */
    @Column("ts_last_active")
    private Date tsLastActive;

    /**
     * 1=设备启用；0=设备停用
     */
    @Column("nt_state")
    private Integer ntState;

    /**
     * 备注
     */
    @Column("tx_comment")
    private String txComment;

    /**
     * 未上传卡点数量
     */
    @Column("nt_rcd_fresh")
    private Integer ntRcdFresh;

    /**
     * 设备Web服务器IP地址
     */
    @Column("sz_server_ip")
    private String szServerIp;

    /**
     * 设备Web服务器端口号
     */
    @Column("nt_server_port")
    private Integer ntServerPort;

    /**
     * 设备管理员密码
     */
    @Column("sz_admin_pwd")
    private String szAdminPwd;

    /**
     * 创建人
     */
    @Column("ng_creator")
    private Long ngCreator;

    /**
     * 创建时间
     */
    @Column("ts_create")
    private Date tsCreate;

    /**
     * 天波对讲号码
     */
    @Column("tp_number")
    private String tpNumber;

    /**
     * 天波对讲号码加密后字符串
     */
    @Column("api_token")
    private String apiToken;

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
     * 是否需要佩戴口罩(1:需要,2:不需要)
     */
    @Column("sz_needMask")
    private Integer szNeedMask;

    /**
     * 门禁设备类型（1单门 2 双门 4四门）
     */
    @Column("sz_control_type")
    private Byte szControlType;

    /**
     * 门禁节假日设置
     */
    @Column("sz_holiday_id")
    private Integer szHolidayId;

    /**
     * 是否支持可视对讲（1：不支持，2：支持）
     */
    @Column("talk_state")
    private Integer talkState;

    /**
     * 设备方向 1：进  2：出 0：不限
     */
    @Column("access")
    private Integer access;

    /**
     * 未佩戴口罩提示语包含人名
     */
    @Column("contain_name")
    private Integer containName;

    /**
     * 呼叫编号
     */
    @Column("call_number")
    private String callNumber;

    /**
     * 区别掌纹设备='1'、单人脸设备='0'
     */
    @Column("dev_type")
    private String devType;

    /**
     * 掌纹模板算法版本
     */
    @Column("sz_palm_print_algorithm_edition")
    private String szPalmPrintAlgorithmEdition;

    /**
     * 设备系列字段
     */
    @Column("model")
    private String model;

    /**
     * 指纹模板算法版本
     */
    @Column("sz_finger_algorithm_edition")
    private String szFingerAlgorithmEdition;

    /**
     * 当前掌纹容量
     */
    @Column("nt_real_palm")
    private Integer ntRealPalm;

    /**
     * 最大掌纹容量
     */
    @Column("nt_max_palm")
    private Integer ntMaxPalm;

    // Getter和Setter方法
    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName;
    }

    public String getSzType() {
        return szType;
    }

    public void setSzType(String szType) {
        this.szType = szType;
    }

    public String getSzAlgorithmEdition() {
        return szAlgorithmEdition;
    }

    public void setSzAlgorithmEdition(String szAlgorithmEdition) {
        this.szAlgorithmEdition = szAlgorithmEdition;
    }

    public Integer getStDevClass() {
        return stDevClass;
    }

    public void setStDevClass(Integer stDevClass) {
        this.stDevClass = stDevClass;
    }

    public String getSzIpAddr() {
        return szIpAddr;
    }

    public void setSzIpAddr(String szIpAddr) {
        this.szIpAddr = szIpAddr;
    }

    public Date getTsLastRcd() {
        return tsLastRcd;
    }

    public void setTsLastRcd(Date tsLastRcd) {
        this.tsLastRcd = tsLastRcd;
    }

    public String getSzDevPwd() {
        return szDevPwd;
    }

    public void setSzDevPwd(String szDevPwd) {
        this.szDevPwd = szDevPwd;
    }

    public String getSzMask() {
        return szMask;
    }

    public void setSzMask(String szMask) {
        this.szMask = szMask;
    }

    public String getSzGateway() {
        return szGateway;
    }

    public void setSzGateway(String szGateway) {
        this.szGateway = szGateway;
    }

    public String getSzMac() {
        return szMac;
    }

    public void setSzMac(String szMac) {
        this.szMac = szMac;
    }

    public String getSzSerial() {
        return szSerial;
    }

    public void setSzSerial(String szSerial) {
        this.szSerial = szSerial;
    }

    public String getSzRomEdition() {
        return szRomEdition;
    }

    public void setSzRomEdition(String szRomEdition) {
        this.szRomEdition = szRomEdition;
    }

    public String getSzVolume() {
        return szVolume;
    }

    public void setSzVolume(String szVolume) {
        this.szVolume = szVolume;
    }

    public String getSzPlace() {
        return szPlace;
    }

    public void setSzPlace(String szPlace) {
        this.szPlace = szPlace;
    }

    public Integer getNtUserCapacity() {
        return ntUserCapacity;
    }

    public void setNtUserCapacity(Integer ntUserCapacity) {
        this.ntUserCapacity = ntUserCapacity;
    }

    public Integer getNtUserUsed() {
        return ntUserUsed;
    }

    public void setNtUserUsed(Integer ntUserUsed) {
        this.ntUserUsed = ntUserUsed;
    }

    public Integer getNtRcdCapacity() {
        return ntRcdCapacity;
    }

    public void setNtRcdCapacity(Integer ntRcdCapacity) {
        this.ntRcdCapacity = ntRcdCapacity;
    }

    public Long getDevMonitorId() {
        return devMonitorId;
    }

    public void setDevMonitorId(Long devMonitorId) {
        this.devMonitorId = devMonitorId;
    }

    public Integer getNtRcdUsed() {
        return ntRcdUsed;
    }

    public void setNtRcdUsed(Integer ntRcdUsed) {
        this.ntRcdUsed = ntRcdUsed;
    }

    public Date getTsLastActive() {
        return tsLastActive;
    }

    public void setTsLastActive(Date tsLastActive) {
        this.tsLastActive = tsLastActive;
    }

    public Integer getNtState() {
        return ntState;
    }

    public void setNtState(Integer ntState) {
        this.ntState = ntState;
    }

    public String getTxComment() {
        return txComment;
    }

    public void setTxComment(String txComment) {
        this.txComment = txComment;
    }

    public Integer getNtRcdFresh() {
        return ntRcdFresh;
    }

    public void setNtRcdFresh(Integer ntRcdFresh) {
        this.ntRcdFresh = ntRcdFresh;
    }

    public String getSzServerIp() {
        return szServerIp;
    }

    public void setSzServerIp(String szServerIp) {
        this.szServerIp = szServerIp;
    }

    public Integer getNtServerPort() {
        return ntServerPort;
    }

    public void setNtServerPort(Integer ntServerPort) {
        this.ntServerPort = ntServerPort;
    }

    public String getSzAdminPwd() {
        return szAdminPwd;
    }

    public void setSzAdminPwd(String szAdminPwd) {
        this.szAdminPwd = szAdminPwd;
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

    public String getTpNumber() {
        return tpNumber;
    }

    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
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

    public Integer getSzNeedMask() {
        return szNeedMask;
    }

    public void setSzNeedMask(Integer szNeedMask) {
        this.szNeedMask = szNeedMask;
    }

    public Byte getSzControlType() {
        return szControlType;
    }

    public void setSzControlType(Byte szControlType) {
        this.szControlType = szControlType;
    }

    public Integer getSzHolidayId() {
        return szHolidayId;
    }

    public void setSzHolidayId(Integer szHolidayId) {
        this.szHolidayId = szHolidayId;
    }

    public Integer getTalkState() {
        return talkState;
    }

    public void setTalkState(Integer talkState) {
        this.talkState = talkState;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getContainName() {
        return containName;
    }

    public void setContainName(Integer containName) {
        this.containName = containName;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getSzPalmPrintAlgorithmEdition() {
        return szPalmPrintAlgorithmEdition;
    }

    public void setSzPalmPrintAlgorithmEdition(String szPalmPrintAlgorithmEdition) {
        this.szPalmPrintAlgorithmEdition = szPalmPrintAlgorithmEdition;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSzFingerAlgorithmEdition() {
        return szFingerAlgorithmEdition;
    }

    public void setSzFingerAlgorithmEdition(String szFingerAlgorithmEdition) {
        this.szFingerAlgorithmEdition = szFingerAlgorithmEdition;
    }

    public Integer getNtRealPalm() {
        return ntRealPalm;
    }

    public void setNtRealPalm(Integer ntRealPalm) {
        this.ntRealPalm = ntRealPalm;
    }

    public Integer getNtMaxPalm() {
        return ntMaxPalm;
    }

    public void setNtMaxPalm(Integer ntMaxPalm) {
        this.ntMaxPalm = ntMaxPalm;
    }

    @Override
    public String toString() {
        return "DevDevice{" +
                "ngId=" + ngId +
                ", szName='" + szName + '\'' +
                ", szType='" + szType + '\'' +
                ", szAlgorithmEdition='" + szAlgorithmEdition + '\'' +
                ", stDevClass=" + stDevClass +
                ", szIpAddr='" + szIpAddr + '\'' +
                ", tsLastRcd=" + tsLastRcd +
                ", szDevPwd='" + szDevPwd + '\'' +
                ", szMask='" + szMask + '\'' +
                ", szGateway='" + szGateway + '\'' +
                ", szMac='" + szMac + '\'' +
                ", szSerial='" + szSerial + '\'' +
                ", szRomEdition='" + szRomEdition + '\'' +
                ", szVolume='" + szVolume + '\'' +
                ", szPlace='" + szPlace + '\'' +
                ", ntUserCapacity=" + ntUserCapacity +
                ", ntUserUsed=" + ntUserUsed +
                ", ntRcdCapacity=" + ntRcdCapacity +
                ", devMonitorId=" + devMonitorId +
                ", ntRcdUsed=" + ntRcdUsed +
                ", tsLastActive=" + tsLastActive +
                ", ntState=" + ntState +
                ", txComment='" + txComment + '\'' +
                ", ntRcdFresh=" + ntRcdFresh +
                ", szServerIp='" + szServerIp + '\'' +
                ", ntServerPort=" + ntServerPort +
                ", szAdminPwd='" + szAdminPwd + '\'' +
                ", ngCreator=" + ngCreator +
                ", tsCreate=" + tsCreate +
                ", tpNumber='" + tpNumber + '\'' +
                ", apiToken='" + apiToken + '\'' +
                ", szLng='" + szLng + '\'' +
                ", szLat='" + szLat + '\'' +
                ", szNeedMask=" + szNeedMask +
                ", szControlType=" + szControlType +
                ", szHolidayId=" + szHolidayId +
                ", talkState=" + talkState +
                ", access=" + access +
                ", containName=" + containName +
                ", callNumber='" + callNumber + '\'' +
                ", devType='" + devType + '\'' +
                ", szPalmPrintAlgorithmEdition='" + szPalmPrintAlgorithmEdition + '\'' +
                ", model='" + model + '\'' +
                ", szFingerAlgorithmEdition='" + szFingerAlgorithmEdition + '\'' +
                ", ntRealPalm=" + ntRealPalm +
                ", ntMaxPalm=" + ntMaxPalm +
                '}';
    }
}

