package com.bdqn.dao.impl;

import com.bdqn.dao.NewsDao;
import com.bdqn.entity.News;
import com.bdqn.resultHandle.IResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:49 2018/3/28
 * @Description:
 */

public class NewsDaoImpl extends BaseDao implements NewsDao {
    @Override
    public int getNewsCountsByTid(Integer tid) throws Exception {
        String sql = "select count(*) from news where t_id=?";
        return query(sql, new IResultHandler<Integer>() {
            @Override
            public Integer handleResult(ResultSet rs) throws SQLException {
                Integer count = -1;
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                return count;
            }
        }, tid);
    }

    @Override
    public List<News> getNewsByTid(Integer tid) throws Exception {
        String sql = "select nid,ncontent,pdate from news where t_id=?  order by pdate desc limit 10";
        return query(sql, new HandleListNews(), tid);

    }

    @Override
    public List<News> getAllNews(Integer minValue, Integer pageSize) throws Exception {
        String sql = "select nid,ncontent,pdate from news order by pdate desc limit ?,?";
        return query(sql, new HandleListNews(), minValue, pageSize);

    }

    @Override
    public Integer findAllCounts() throws Exception {
        String sql = "select count(*) count from news";
        return query(sql, new IResultHandler<Integer>() {
            @Override
            public Integer handleResult(ResultSet rs) throws SQLException {
                Integer count = -1;
                if (rs.next()) {
                    count = rs.getInt("count");
                }
                return count;
            }
        });
    }


    class HandleListNews implements IResultHandler<List<News>> {
        @Override
        public List<News> handleResult(ResultSet rs) throws SQLException {
            NewsDao newsDao = new NewsDaoImpl();
            List<News> list = new ArrayList<>();
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt(1));
                news.setNcontent(rs.getString(2));
                news.setPdate(rs.getDate(3));
                list.add(news);
            }
            return list;
        }
    }
}
