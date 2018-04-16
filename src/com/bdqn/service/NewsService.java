package com.bdqn.service;

import com.bdqn.entity.Page;

/**
 * @Author: ldw
 * @Date: created in 11:07 2018/4/11
 * @Description:
 */

public interface NewsService {

    Page getAllNews(Integer currentPage, Integer pageSize) throws Exception;

}
