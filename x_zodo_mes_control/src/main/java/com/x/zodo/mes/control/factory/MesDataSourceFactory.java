package com.x.zodo.mes.control.factory;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;



public class MesDataSourceFactory {
    private static DataSource dataSource;
    public static DataSource getDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        try {
            Properties props = new Properties();
            InputStream in = MesDataSourceFactory.class
                    .getClassLoader()
                    .getResourceAsStream("mes.properties");
            props.load(in);

            HikariConfig config = new HikariConfig();
            config.setDriverClassName(props.getProperty("db.driver"));
            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.username"));
            config.setPassword(props.getProperty("db.password"));
            config.setMaximumPoolSize(Integer.parseInt(props.getProperty("db.pool.maximumPoolSize", "10")));
            config.setMinimumIdle(Integer.parseInt(props.getProperty("db.pool.minimumIdle", "2")));
            dataSource = new HikariDataSource(config);
            return dataSource;

        } catch (Exception e) {
            throw new RuntimeException("初始化数据源失败", e);
        }
    }
}
