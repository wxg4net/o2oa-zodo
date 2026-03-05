package com.x.zodo.attendance.entity;

import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.SliceJpaObject;
import com.x.base.core.entity.annotation.CheckPersist;
import com.x.base.core.entity.annotation.ContainerEntity;
import com.x.base.core.entity.annotation.RestrictFlag;
import com.x.base.core.project.annotation.FieldDescribe;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.openjpa.persistence.jdbc.Index;

import javax.persistence.*;

/**
 * 考勤门禁设备实体
 * @author wxg
 */
@Schema(name = "考勤门禁设备实体", description = "考勤、门禁、设备实体.")
@ContainerEntity(dumpSize = 1000, type = ContainerEntity.Type.content, reference = ContainerEntity.Reference.strong)
@Entity
@Table(name = PersistenceProperties.Attendance.table, uniqueConstraints = {
        @UniqueConstraint(name = PersistenceProperties.Attendance.table + JpaObject.IndexNameMiddle
                + JpaObject.DefaultUniqueConstraintSuffix, columnNames = { JpaObject.IDCOLUMN,
                JpaObject.CREATETIMECOLUMN, JpaObject.UPDATETIMECOLUMN, JpaObject.SEQUENCECOLUMN }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AttendanceDevice extends SliceJpaObject {

    private static final long serialVersionUID = 1325197931747463979L;
    private static final String TABLE = PersistenceProperties.Attendance.table;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @FieldDescribe("数据库主键,自动生成.")
    @Id
    @Column(length = length_id, name = ColumnNamePrefix + id_FIELDNAME)
    private String id = createId();

    @Override
    public void onPersist() {
    }
    /*
     * =============================================================================
     * ===== 以上为 JpaObject 默认字段
     * =============================================================================
     */

    /*
     * =============================================================================
     * ===== 以下为具体不同的业务及数据表字段要求
     * =============================================================================
     */

    public static final String name_FIELDNAME = "name";
    @FieldDescribe("设备名称")
    @Index(name = TABLE + IndexNameMiddle + name_FIELDNAME)
    @Column(length = length_255B, name = ColumnNamePrefix + name_FIELDNAME)
    @CheckPersist(allowEmpty = false, simplyString = true)
    private String name;

    public static final String deviceType_FIELDNAME = "deviceType";
    @FieldDescribe("设备类型")
    @Column(length = length_255B, name = ColumnNamePrefix + deviceType_FIELDNAME)
    @CheckPersist(allowEmpty = false, simplyString = true)
    private String deviceType;

    public static final String sn_FIELDNAME = "sn";
    @RestrictFlag
    @FieldDescribe("设备编码")
    @Column(length = length_255B, name = ColumnNamePrefix + sn_FIELDNAME)
    @Index(name = TABLE + IndexNameMiddle + sn_FIELDNAME)
    @CheckPersist(allowEmpty = true, simplyString = true)
    private String sn;

    public static final String model_FIELDNAME = "model";
    @FieldDescribe("型号")
    @Column(name = ColumnNamePrefix + model_FIELDNAME)
    private String model;

    public static final String factory_FIELDNAME = "factory";
    @FieldDescribe("工厂")
    @Column(length = length_255B, name = ColumnNamePrefix + factory_FIELDNAME)
    @CheckPersist(allowEmpty = true, simplyString = true)
    private String factory;

    public static final String host_FIELDNAME = "host";
    @FieldDescribe("主机地址")
    @Column(length = length_255B, name = ColumnNamePrefix + host_FIELDNAME)
    @CheckPersist(allowEmpty = true, simplyString = true)
    private String host;

    public static final String port_FIELDNAME = "port";
    @FieldDescribe("主机端口")
    @Column(name = ColumnNamePrefix + port_FIELDNAME)
    @CheckPersist(allowEmpty = false, simplyString = true)
    private String port;

    public static final String password_FIELDNAME = "password";
    @FieldDescribe("通讯密码")
    @Column(name = ColumnNamePrefix + password_FIELDNAME)
    private String password;

    public static final String brand_FIELDNAME = "brand";
    @FieldDescribe("品牌")
    @Column(name = ColumnNamePrefix + brand_FIELDNAME)
    private String brand;

    public static final String active_FIELDNAME = "active";
    @FieldDescribe("是否禁用")
    @Column(name = ColumnNamePrefix + active_FIELDNAME)
    private Boolean active = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
