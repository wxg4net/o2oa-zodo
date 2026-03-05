package com.x.zodo.attendance.control.jaxrs;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.zodo.attendance.control.factory.MyBatisFlexFactory;
import date.DateOperation;

public class BaseAction extends StandardJaxrsAction{
    public   MybatisFlexBootstrap mybatisFlex = MyBatisFlexFactory.getBootstrap();
    public   DateOperation dateOperation = new DateOperation();
}
