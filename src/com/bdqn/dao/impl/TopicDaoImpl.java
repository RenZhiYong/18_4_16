package com.bdqn.dao.impl;

import com.bdqn.dao.TopicDao;
import com.bdqn.entity.Topic;
import com.bdqn.resultHandle.IResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:06 2018/3/28
 * @Description:
 */

public class TopicDaoImpl extends BaseDao implements TopicDao {
    @Override
    public List<Topic> getAllTopics() throws Exception {
        String sql = "select tid,tname from topic";
        return query(sql, new IResultHandler<List<Topic>>() {
            @Override
            public List<Topic> handleResult(ResultSet rs) throws SQLException {
                List<Topic> list = new ArrayList<>();
                Topic topic = null;
                while (rs.next()) {
                    topic = new Topic();
                    topic.setTid(rs.getInt(1));
                    topic.setTname(rs.getString(2));
                    list.add(topic);
                }
                return list;
            }
        });

    }

    @Override
    public int deleteTopicById(Integer tid) throws Exception {
        String sql = "delete from topic where tid=?";
        return allChange(sql, tid);
    }

    @Override
    public Topic getTopicByTid(Integer tid) throws Exception {
        String sql = "select tid,tname from topic where tid=?";
        return query(sql, new IResultHandler<Topic>() {
            @Override
            public Topic handleResult(ResultSet rs) throws SQLException {
                Topic topic = null;
                if (rs.next()) {
                    topic = new Topic();
                    topic.setTname(rs.getString(2));
                    topic.setTid(rs.getInt(1));
                }
                return topic;
            }
        }, tid);
    }

    @Override
    public int updateTopicByTid(Topic topic) throws Exception {
        String sql = "update topic set tname=? where tid=?";
        return allChange(sql, topic.getTname(), topic.getTid());
    }
}
