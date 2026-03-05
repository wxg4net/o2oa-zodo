package com.x.zodo.gateway.control.jaxrs.hr;

import com.x.base.core.project.annotation.FieldDescribe;

public class QueryKmsWorkDto {

    @FieldDescribe( "工作流ID" )
    private String workId;

    @FieldDescribe( "目标流程ID" )
    private String targetProcessId;
    public String getWorkId() {return workId; }
    public void setWorkId(String workId) {this.workId = workId;}

    public String getTargetProcessId() {
        return targetProcessId;
    }

    public void setTargetProcessId(String targetProcessId) {
        this.targetProcessId = targetProcessId;
    }
}
