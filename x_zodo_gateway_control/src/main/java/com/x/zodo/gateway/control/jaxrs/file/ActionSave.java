package com.x.zodo.gateway.control.jaxrs.file;


import javax.servlet.http.HttpServletRequest;

import com.x.zodo.gateway.control.jaxrs.BaseAction;

import com.google.gson.JsonElement;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

/**
 * 示例数据信息保存服务
 * @author sword
 */
public class ActionSave extends BaseAction {

    private static  Logger logger = LoggerFactory.getLogger( com.x.zodo.gateway.control.jaxrs.gateway.ActionSave.class );

    protected ActionResult<com.x.zodo.gateway.control.jaxrs.gateway.ActionSave.Wo> execute(HttpServletRequest request, EffectivePerson effectivePerson, JsonElement jsonElement) throws Exception {
        return null;
    }


    /**
     * 用于输出响应内容的帮助类
     *
     */
    public static class Wo  {
        public Wo( String id ) {
            setId( id );
        }

        private void setId(String id) {
        }
    }
}

