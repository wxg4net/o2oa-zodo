package com.x.zodo.attendance.control.jaxrs.user;

import com.mybatisflex.core.query.QueryWrapper;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.jaxrs.BaseAction;
import com.x.zodo.attendance.control.mybatisflex.StatCard;
import com.x.zodo.attendance.control.mybatisflex.StatCardMapper;
import com.x.zodo.attendance.control.mybatisflex.SysUser;
import com.x.zodo.attendance.control.mybatisflex.SysUserMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.x.zodo.attendance.control.mybatisflex.table.StatCardTableDef.STAT_CARD;
import static com.x.zodo.attendance.control.mybatisflex.table.SysUserTableDef.SYS_USER;

/**
 * 示例数据信息保存服务
 * @author sword
 */
public class ActionUser extends BaseAction {
    private static  Logger logger = LoggerFactory.getLogger( ActionUser.class );

    protected ActionResult<List<Wo>> execute( HttpServletRequest request, EffectivePerson effectivePerson, String name ) throws Exception {
        ActionResult<List<Wo>> result = new ActionResult<>();

        SysUserMapper sysUserMapper = mybatisFlex.getMapper(SysUserMapper.class);

        QueryWrapper query = new QueryWrapper();
        query.limit(10).orderBy(SYS_USER.TS_CREATE.desc());
        List<SysUser> data = sysUserMapper.selectListByQuery(query);
        List<Wo> copier = new ArrayList<>();
        copier = Wo.copier.copy(data, copier);
        result.setData(copier);
        return result;
    }


    /**
     * 用于输出响应内容的帮助类
     *
     */
    public static class Wo extends SysUser {

        private static final List<String> includes = new ArrayList<>(
                Arrays.asList("ngId", "szEmployId", "szUserName", "szName", "szCardId", "ntGender", "szMobile")
        );
        static final WrapCopier<SysUser, Wo> copier = WrapCopierFactory.wo(SysUser.class, Wo.class, includes
                , null);
    }
}

