package com.bdqn.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bdqn.dao.impl.BaseDao;
import com.bdqn.entity.News;
import com.bdqn.entity.Topic;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: ldw
 * @Date: created in 8:58 2018/4/13
 * @Description:
 */

public class TestDbUtil {

    @Test
    public void test() {
        QueryRunner queryRunner = new QueryRunner();
//        queryRunner.update();//增删改的通用方法
//        queryRunner.query();//查询的方法
    }


    @Test
    public void testQuery() throws SQLException, InvocationTargetException, IllegalAccessException {
        DataSource dataSource = null;
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from news n,topic t where n.t_id=t.tid and n.nid=?";
        Map<String, Object> ma = queryRunner.query(sql, new MapHandler(), 1);
        News news = new News();
        Topic topic = new Topic();
        BeanUtils.populate(news, ma);
        System.out.println(news.getNcontent());
        BeanUtils.populate(topic, ma);
        news.setTopic(topic);
        System.out.println(news.getTopic().getTid());
        System.out.println(news.getNcontent() + news.getPdate());
    }

    @Test
    public void testQuery7() throws SQLException, InvocationTargetException, IllegalAccessException {
        DataSource dataSource = null;
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from news n,topic t where n.t_id=t.tid";
        List<Map<String, Object>> maps = queryRunner.query(sql, new MapListHandler());
        List<News> list = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            News news = new News();
            Topic topic = new Topic();
            BeanUtils.populate(news, map);
            System.out.println(news.getNcontent());
            BeanUtils.populate(topic, map);
            news.setTopic(topic);
            list.add(news);
        }

        System.out.println(list.get(2).getNcontent() + "==" + list.get(2).getTopic().getTname());
    }


    @Test
    public void testQuery2() throws SQLException {
        DataSource dataSource = null;
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select nid nid, ncontent ,pdate from News";
        List<News> newsList = queryRunner.query(sql, new BeanListHandler<>(News.class));


        System.out.println(newsList.get(1).getNcontent() + newsList.get(2).getPdate());


    }


    @Test
    public void testQuery3() throws SQLException {
        DataSource dataSource = null;
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from News where nid=?";
        Map<String, Object> map = queryRunner.query(sql, new MapHandler(), 1);

        System.out.println(map.get("ncontent"));


    }

    @Test
    public void testQuery4() throws SQLException {
        DataSource dataSource = null;
        Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select count(*) from News";
        Long count = queryRunner.query(sql, new ScalarHandler<Long>());
        System.out.println(count);


    }
}
