package com.bdqn.dao;

import com.bdqn.entity.Topic;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:05 2018/3/28
 * @Description:
 */

public interface TopicDao {

    /**
     * 查询所有的主题
     * @return 主题的集合
     */
    List<Topic> getAllTopics() throws Exception;

    /**
     * 通过id删除主题
     * @param tid 主题id
     * @return
     */
    int deleteTopicById(Integer tid) throws Exception;


    /**
     * 通过主题id查询单个主题
     * @param tid 主题id
     * @return
     */
    Topic getTopicByTid(Integer tid) throws Exception;

    /**
     * 通过tid修改topic
     * @param topic 主题对象
     * @return
     */
    int updateTopicByTid(Topic topic) throws Exception;

}
