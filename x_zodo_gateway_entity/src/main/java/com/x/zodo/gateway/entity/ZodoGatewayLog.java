package com.x.zodo.gateway.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.x.base.core.entity.annotation.*;
import org.apache.openjpa.persistence.jdbc.Index;

import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.SliceJpaObject;
import com.x.base.core.project.annotation.FieldDescribe;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 示例实体类
 * @author sword
 */
@Schema(name = "ZodoGatewayLog", description = "网关日志.")
@ContainerEntity(dumpSize = 1000, type = ContainerEntity.Type.content, reference = ContainerEntity.Reference.strong)
@Entity
@Table(name = PersistenceProperties.ZodoGateway.table, uniqueConstraints = {
        @UniqueConstraint(name = PersistenceProperties.ZodoGateway.table + JpaObject.IndexNameMiddle
                + JpaObject.DefaultUniqueConstraintSuffix, columnNames = { JpaObject.IDCOLUMN,
                JpaObject.CREATETIMECOLUMN, JpaObject.UPDATETIMECOLUMN, JpaObject.SEQUENCECOLUMN }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ZodoGatewayLog extends SliceJpaObject {

    private static final long serialVersionUID = 1325197931747463979L;
    private static final String TABLE = PersistenceProperties.ZodoGateway.table;

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
    @FieldDescribe("名称")
    @RestrictFlag
    @Index(name = TABLE + IndexNameMiddle + name_FIELDNAME)
    @Column(length = length_255B, name = ColumnNamePrefix + name_FIELDNAME)
    @CheckPersist(allowEmpty = false)
    private String name;

    public static final String category_FIELDNAME = "category";
    @RestrictFlag
    @FieldDescribe("分类")
    @Column(length = length_255B, name = ColumnNamePrefix + category_FIELDNAME)
    @Index(name = TABLE + IndexNameMiddle + category_FIELDNAME)
    @CheckPersist(allowEmpty = true, simplyString = true)
    private String category;

    public static final String userName_FIELDNAME = "userName";
    @FieldDescribe("用户")
    @Column(name = ColumnNamePrefix + userName_FIELDNAME)
    private String userName;

    public static final String userId_FIELDNAME = "userId";
    @FieldDescribe("用户ID")
    @Column(name = ColumnNamePrefix + userId_FIELDNAME)
    private String userId;

    public static final String body_FIELDNAME = "body";
    @FieldDescribe("日志")
    @Column(name = ColumnNamePrefix + body_FIELDNAME)
    @CheckPersist(allowEmpty = false)
    private String body;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

}