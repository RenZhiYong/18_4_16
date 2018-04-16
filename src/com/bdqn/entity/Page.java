package com.bdqn.entity;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 11:03 2018/4/11
 * @Description:
 */

public class Page {

    private Integer pageSize;//每页显示记录数
    private Integer totalRows;//总记录数
    private Integer totalPages;//总页数
    private Integer currentPage;//当前页数
    private List<News> newsList;//对应每页的显示内容


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
