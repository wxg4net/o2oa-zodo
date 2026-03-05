package com.x.zodo.gateway.control.queueTask;

import com.google.gson.JsonElement;
import com.x.base.core.project.connection.ActionResponse;
import com.x.base.core.project.gson.XGsonBuilder;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.organization.Identity;
import com.x.base.core.project.queue.AbstractQueue;
import com.x.base.core.project.x_organization_assemble_express;
import com.x.base.core.project.x_processplatform_assemble_surface;
import com.x.zodo.gateway.control.ThisApplication;
import com.x.zodo.gateway.control.jaxrs.hr.KmsPersonFlagDto;
import com.x.zodo.gateway.control.jaxrs.hr.KmsSalaryDto;
import com.x.zodo.gateway.control.queueTask.queue.KmsProcessRecordQueue;
import java.util.*;

public class KmsProcessRecordTask extends AbstractQueue<KmsProcessRecordQueue> {
    private final static Logger logger = LoggerFactory.getLogger( KmsProcessRecordTask.class );

    protected void execute( KmsProcessRecordQueue kmsProcessRecordQueue ) throws Exception {

//      KmsSalaryDto kmsSalaryDto = kmsProcessRecordQueue.getKmsSalaryDto();
        Map<String, Object> kmsSalaryDto = kmsProcessRecordQueue.getKmsSalaryDto();
        KmsPersonFlagDto postBody = new KmsPersonFlagDto(
                List.of(kmsSalaryDto.get("userId").toString())
        );
        ActionResponse respObject = ThisApplication.context().applications().
                postQuery(x_organization_assemble_express.class,
                        "identity/list/major/person/object", postBody);

        List<Identity> personObjectDto = respObject.getDataAsList(Identity.class);
        if (personObjectDto.size() != 1) {
            throw new Exception( "person object has more than one object" );
        }
        String userName = kmsSalaryDto.get("userName").toString();

        String title = String.format("%s-%s的薪资(%s-%s)", kmsProcessRecordQueue.getSalaryType(), userName, kmsProcessRecordQueue.getStartDate(), kmsProcessRecordQueue.getEndDate());
        Map <String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("subject", title);
        map.put("startDate", kmsProcessRecordQueue.getStartDate());
        map.put("endDate", kmsProcessRecordQueue.getEndDate());
        map.put("salaryType", kmsProcessRecordQueue.getSalaryType());
        map.put("receiver", personObjectDto);
        map.put("data", kmsSalaryDto);

        KmsProcessCreateWi actionCreateWi = new KmsProcessCreateWi();
        JsonElement element = XGsonBuilder.compactInstance().toJsonTree(map);
        actionCreateWi.setData(element);
        actionCreateWi.setTitle(title);
        String kmsProcessId = kmsProcessRecordQueue.getTargetProcessId();
        ActionResponse respWork = ThisApplication.context().applications().
                postQuery(x_processplatform_assemble_surface.class,
                        "work/process/" + kmsProcessId, actionCreateWi);
        logger.info("系统发送柬埔寨员工工资确认单 => {}", XGsonBuilder.compactInstance().toJson(respWork));
    }
}
