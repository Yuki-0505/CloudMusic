package com.swl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtils {

    // 数据库连接池
    private static DataSource dataSource;

    // 初始化连接池
    public static void init() throws Exception {
        //读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/db.properties");
        Properties properties = new Properties();
        properties.load(in);

        dataSource = DruidDataSourceFactory.createDataSource(properties);
    }

    // 获取数据库连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // 关闭连接
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // 获取列表
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        List<T> list = new ArrayList<T>();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            //设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //获取结果集
            rs = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int colnum = rsmd.getColumnCount();

            while (rs.next()) {
                T bean = clazz.newInstance();
                for (int i = 1; i <= colnum; i++) {
                    //列名
                    String columnName = rsmd.getColumnLabel(i);
                    //值
                    Object columnValue = rs.getObject(columnName);
                    //执行set方法
                    BeanUtils.setProperty(bean, columnName, columnValue);
                }
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, rs);
        }
        return list;
    }

    // 保存数据
    public static boolean save(String sql, Object... args) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        Integer count = null;
        try {
            ps = conn.prepareStatement(sql);
            //设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //返回更新数
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, null);
        }
        return count != null && count > 0 ? true : false;
    }

    // 获取数据并封装为T类型
    public static <T> T getSingleBean(Class<T> clazz, String sql, Object... args) {
        T bean = null;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            //设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //获取结果集
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int colnum = rsmd.getColumnCount();
            while (rs.next()) {
                bean = clazz.newInstance();
                for (int i = 1; i <= colnum; i++) {
                    //列名
                    String columnName = rsmd.getColumnLabel(i);
                    //值
                    Object columnValue = rs.getObject(columnName);
                    BeanUtils.setProperty(bean, columnName, columnValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, rs);
        }
        return bean;
    }

//    public static Integer getCount(String sql, Object... args) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Integer count = null;
//        try {
//            conn = DBUtils.getConnection();
//
//            ps = conn.prepareStatement(sql);
//            //设置参数
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1, args[i]);
//            }
//            //获取结果集
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                count = rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close(null, ps, rs);
//        }
//        return count;
//    }

    // 更新数据，返回更新条数
    public static boolean update(String sql, Object... args) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            ps = conn.prepareStatement(sql);

            //设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //获取结果集
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, null);
        }
        return count > 0 ? true : false;
    }

    // 更新数据，返回更新主键
    public static Integer updateForPrimary(String sql, Object... args) {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //设置参数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                primaryKey = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, rs);
        }
        return primaryKey;
    }

}
