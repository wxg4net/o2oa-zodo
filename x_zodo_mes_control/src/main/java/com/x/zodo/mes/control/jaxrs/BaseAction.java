package com.x.zodo.mes.control.jaxrs;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.zodo.mes.control.factory.MyBatisFlexFactory;


public class BaseAction extends StandardJaxrsAction{
    public   MybatisFlexBootstrap mybatisFlex = MyBatisFlexFactory.getBootstrap();

}
