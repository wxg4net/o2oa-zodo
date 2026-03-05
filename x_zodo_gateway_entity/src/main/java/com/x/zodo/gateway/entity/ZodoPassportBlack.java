package com.x.zodo.gateway.entity;

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
@Schema(name = "ZodoPassportBlack", description = "通行证黑名单")
@ContainerEntity(dumpSize = 1000, type = ContainerEntity.Type.content, reference = ContainerEntity.Reference.strong)
@Entity
@Table(name = PersistenceProperties.ZodoGateway.passportBlackTable, uniqueConstraints = {
        @UniqueConstraint(name = PersistenceProperties.ZodoGateway.passportBlackTable + JpaObject.IndexNameMiddle
                + JpaObject.DefaultUniqueConstraintSuffix, columnNames = { JpaObject.IDCOLUMN,
                JpaObject.CREATETIMECOLUMN, JpaObject.UPDATETIMECOLUMN, JpaObject.SEQUENCECOLUMN }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ZodoPassportBlack extends SliceJpaObject {

    private static final long serialVersionUID = 1325197931747463979L;
    private static final String TABLE = PersistenceProperties.ZodoGateway.passportBlackTable;

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

    public static final String jobId_FIELDNAME = "jobId";
    @FieldDescribe("流程任务ID")
    @RestrictFlag
    @Index(name = TABLE + IndexNameMiddle + jobId_FIELDNAME)
    @Column(length = length_255B, name = ColumnNamePrefix + jobId_FIELDNAME)
    @CheckPersist(allowEmpty = false)
    private String jobId;

    public static final String reason_FIELDNAME = "reason";
    @FieldDescribe("屏蔽理由")
    @Column(name = ColumnNamePrefix + reason_FIELDNAME)
    private String reason;


    // jobId 字段的 getter 和 setter
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    // reason 字段的 getter 和 setter
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
