package com.bdqn.service.impl;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.entity.News;
import com.bdqn.entity.Page;
import com.bdqn.service.NewsService;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:08 2018/4/11
 * @Description:
 */

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();


    @Override
    public Page getAllNews(Integer currentPage, Integer pageSize) throws Exception {
        int minVal = (currentPage - 1) * pageSize;
        //准备page对象需要的所有参数,然后封装到page对象里
        List<News> newsList = newsDao.getAllNews(minVal, pageSize);

        //数据库查询总记录数
        Integer totalRows = newsDao.findAllCounts();

        //求总页数 101/10
        Integer totalPages = totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;

        Page page = new Page();

        page.setCurrentPage(currentPage);
        page.setNewsList(newsList);
        page.setTotalRows(totalRows);
        page.setPageSize(pageSize);
        page.setTotalPages(totalPages);

        return page;
    }
}
