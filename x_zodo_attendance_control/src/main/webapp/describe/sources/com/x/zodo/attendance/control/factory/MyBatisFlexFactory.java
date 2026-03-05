package com.x.zodo.attendance.control.factory;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import com.x.zodo.attendance.control.mybatisflex.AttendanceRecordMapper;
import com.x.zodo.attendance.control.mybatisflex.DeviceMapper;
import com.x.zodo.attendance.control.mybatisflex.StatCardMapper;
import com.x.zodo.attendance.control.mybatisflex.SysUserMapper;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.sql.DataSource;

public class MyBatisFlexFactory {

    private static MybatisFlexBootstrap bootstrap;

    public static void init() {
        DataSource dataSource = HanvonDataSourceFactory.getDataSource();
        bootstrap = new MybatisFlexBootstrap();
        bootstrap.setDataSource(dataSource)
                .addMapper(AttendanceRecordMapper.class)
                .addMapper(DeviceMapper.class)
                .addMapper(StatCardMapper.class)
                .addMapper(SysUserMapper.class)
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
