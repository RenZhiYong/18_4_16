package com.bdqn.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bdqn.resultHandle.IResultHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: ldw
 * @Date: created in 10:14 2018/3/27
 * @Description:
 */

public class BaseDao {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //增删改通用方法
    public int allChange(String sql, Object... params) throws Exception {
        Connection conn = dataSource.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        //执行
        int row = pstm.executeUpdate();
        closeRes(null, pstm, conn);
        return row;
    }

    //查询通用方法
    public <T> T query(String sql, IResultHandler<T> handler, Object... params) throws Exception {
        Connection conn = dataSource.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }

        ResultSet resultSet = pstm.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();


        T t = handler.handleResult(resultSet);
        closeRes(resultSet, pstm, conn);
        return t;

    }


    public void closeRes(ResultSet rs, PreparedStatement stat, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
