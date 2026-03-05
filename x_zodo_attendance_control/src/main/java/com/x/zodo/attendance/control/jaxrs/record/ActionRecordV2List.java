package com.x.zodo.attendance.control.jaxrs.record;

import com.google.gson.JsonElement;
import com.mybatisflex.core.query.QueryWrapper;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

import com.x.base.core.project.tools.DateTools;
import com.x.zodo.attendance.control.dto.QueryRecord;
import com.x.zodo.attendance.control.jaxrs.BaseAction;
import com.x.zodo.attendance.control.mybatisflex.StatCard;
import com.x.zodo.attendance.control.mybatisflex.StatCardMapper;
import date.DateOperation;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.x.zodo.attendance.control.mybatisflex.table.StatCardTableDef.STAT_CARD;

/**
 * 示例数据信息保存服务
 * @author sword
 */
public class ActionRecordV2List extends BaseAction {
    private static  Logger logger = LoggerFactory.getLogger( ActionRecordV2List.class );

    protected ActionResult<List<Wo>> execute( HttpServletRequest request, EffectivePerson effectivePerson, JsonElement jsonElement ) throws Exception {
        ActionResult<List<Wo>> result = new ActionResult<>();
        Wi wi = this.convertToWrapIn(jsonElement, Wi.class);
        StatCardMapper statCardMapper = mybatisFlex.getMapper(StatCardMapper.class);

        QueryWrapper query = new QueryWrapper();
        if (StringUtils.isNotBlank(wi.getUserName())) {
                query.where(STAT_CARD.SZ_USER_NAME.eq(wi.getUserName()));
        }
        if (StringUtils.isNotBlank(wi.getUserId())) {
            query.where(STAT_CARD.SZ_EMPLOY_ID.eq(wi.getUserId()));
        }
        String format = "%s 00:00:00";
        if (wi.getHitDate() != null){
            Date hitDate = wi.getHitDate();
            Date lastDate = DateTools.getAdjustTimeDay(hitDate, 1, null,null, null);
            query.where(STAT_CARD.TS_CARD.ge(String.format(format, DateTools.formatDate(hitDate))));
            query.where(STAT_CARD.TS_CARD.lt(String.format(format, DateTools.formatDate(lastDate))));
        }
        if (wi.getStartDate() != null){
            query.where(STAT_CARD.TS_CARD.lt(String.format(format, DateTools.formatDate(wi.getStartDate()))));
        }
        if (wi.getEndDate() != null){
            query.where(STAT_CARD.TS_CARD.lt(String.format(format, DateTools.formatDate(wi.getEndDate()))));
        }
        query.limit(100).orderBy(STAT_CARD.TS_CARD.desc());
        List<StatCard> data = statCardMapper.selectListByQuery(query);
        List<Wo> copier = new ArrayList<>();
        copier = Wo.copier.copy(data, copier);
        result.setData(copier);
        return result;
    }

    /**
     * 用于接受前端传入的对象型参数的帮助类
     *
     */
    public static class Wi extends  QueryRecord{

        public static final WrapCopier<Wi, QueryRecord> copier = WrapCopierFactory.wi( Wi.class, QueryRecord.class,  null, JpaObject.FieldsUnmodify );

    }

    /**
     * 用于输出响应内容的帮助类
     *
     */
    public static class Wo extends StatCard {

        private static final List<String> includes = new ArrayList<>(
                Arrays.asList("szUserId", "tsCard", "szUserName", "szEmployId", "szDevName", "szDevPlace")
        );
        static final WrapCopier<StatCard, Wo> copier = WrapCopierFactory.wo(StatCard.class, Wo.class, includes
                , null);
    }
}

