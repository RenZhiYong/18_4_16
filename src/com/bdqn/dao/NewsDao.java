package com.bdqn.dao;

import com.bdqn.entity.News;
import com.bdqn.entity.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:48 2018/3/28
 * @Description:
 */

public interface NewsDao {

    /**
     * 通过主题的id查询当前主题下新闻数量
     * @param tid 主题的id
     * @return
     */
    int getNewsCountsByTid(Integer tid) throws Exception;


    /**
     * 通过主题id查询对应的新闻列表
     * @return
     */
     List<News> getNewsByTid(Integer tid) throws Exception;



     List<News> getAllNews(Integer minValue, Integer pageSize) throws Exception;

    Integer findAllCounts() throws Exception;
}
