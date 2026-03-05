package com.x.zodo.mes.control.jaxrs.device;

import com.mybatisflex.core.query.QueryWrapper;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.mes.control.jaxrs.BaseAction;
import com.x.zodo.mes.control.mybatisflex.Tdinf;
import com.x.zodo.mes.control.mybatisflex.TdinfMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.x.zodo.mes.control.mybatisflex.table.TdinfTableDef.TDINF;

/**
 * 示例数据信息保存服务
 * @author sword
 */
public class ActionPda extends BaseAction {
    private static  Logger logger = LoggerFactory.getLogger( ActionPda.class );

    protected ActionResult<List<Wo>> execute( HttpServletRequest request, EffectivePerson effectivePerson, String flag ) throws Exception {
        ActionResult<List<Wo>> result = new ActionResult<>();

        TdinfMapper tdinfMapper = mybatisFlex.getMapper(TdinfMapper.class);
        QueryWrapper query = new QueryWrapper();
        query.where(TDINF.MAC_CD.eq(flag))
                .or(TDINF.DEV_ID.eq(flag));
        List<Tdinf> data = tdinfMapper.selectListByQuery(query);
        List<Wo> copier = new ArrayList<>();
        copier = Wo.copier.copy(data, copier);
        result.setData(copier);
        return result;
    }


    /**
     * 用于输出响应内容的帮助类
     *
     */
    public static class Wo extends Tdinf {

        private static final List<String> includes = new ArrayList<>(
                Arrays.asList("macCd", "devId", "enabled", "createDate", "createUserName", "lastLoginName", "modifyDate")
        );
        static final WrapCopier<Tdinf, Wo> copier = WrapCopierFactory.wo(Tdinf.class, Wo.class, includes
                , null);
    }
}

