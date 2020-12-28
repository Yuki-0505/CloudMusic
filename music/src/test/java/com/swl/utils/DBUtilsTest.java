package com.swl.utils;

import org.junit.Test;

import java.sql.DatabaseMetaData;

public class DBUtilsTest {
    @Test
    public void test() throws Exception {
        DBUtils.init();
        DatabaseMetaData conn = DBUtils.getConnection().getMetaData();
        System.out.println(conn.getDriverName());
        System.out.println(conn.getURL());
        System.out.println(conn.getUserName());

    }
}
