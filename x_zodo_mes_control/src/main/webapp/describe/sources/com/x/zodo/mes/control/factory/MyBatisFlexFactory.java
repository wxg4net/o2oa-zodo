package com.x.zodo.mes.control.factory;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import com.x.zodo.mes.control.mybatisflex.TdinfMapper;


import javax.sql.DataSource;

public class MyBatisFlexFactory {

    private static MybatisFlexBootstrap bootstrap;

    public static void init() {
        DataSource dataSource = MesDataSourceFactory.getDataSource();
        bootstrap = new MybatisFlexBootstrap();
        bootstrap.setDataSource(dataSource)
                .addMapper(TdinfMapper.class)
//                .setLogImpl(StdOutImpl.class)
                .start();
        AuditManager.setAuditEnable(true);
        MessageCollector collector = new ConsoleMessageCollector();
        AuditManager.setMessageCollector(collector);
    }

    public static MybatisFlexBootstrap  getBootstrap() {
        if (null == bootstrap) {
            init();
        }
        return bootstrap;
    }
}
