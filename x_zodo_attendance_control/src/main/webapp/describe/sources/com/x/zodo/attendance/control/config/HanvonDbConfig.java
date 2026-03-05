package com.x.zodo.attendance.control.config;

import java.util.HashMap;
import java.util.Map;

public class HanvonDbConfig {

    public static Map<String, String> PERSISTENCE_HANVON = new HashMap<String, String>(){{
        put("openjpa.ConnectionURL", "jdbc:mysql://192.168.3.159:3377;databaseName=center;useUnicode=true;characterEncoding=UTF-8;encrypt=false;trustServerCertificate=true;");
        put("openjpa.ConnectionDriverName", "com.mysql.cj.jdbc.Drive");
        put("openjpa.ConnectionUserName", "root");
        put("openjpa.ConnectionPassword", "zodo@yqdb_123654");
        put("openjpa.jdbc.DBDictionary", "mysql");
        put("openjpa.jdbc.SynchronizeMappings", "buildSchema(SchemaAction=none)");
        put("openjpa.jdbc.SchemaFactory", "dynamic");
//        put("openjpa.Log", "DefaultLevel=TRACE");
        put("javax.persistence.schema-generation.database.action", "none");
    }};


    public static final String ATTENDANCE_QUERY_SQL = "select sc.ts_card, sc.ts_create, sc.sz_dev_name  " +
            "from center.stat_card sc " +
            "where sc.sz_employ_id ='%s' and  date(sc.ts_create ) = CURDATE()";


}
