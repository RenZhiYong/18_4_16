package com.bdqn.controller;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理  首页点击某个主题 显示对应主题的新闻
 */
@WebServlet("/SnewsTopServlet")
public class SnewsTopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            int tid = Integer.parseInt(request.getParameter("tid"));
            NewsDao newsDao = new NewsDaoImpl();
            List<News> listNews = newsDao.getNewsByTid(tid);
            request.setAttribute("list", listNews);
            System.out.println("aaaaa");
            request.setAttribute("allNews", listNews);
            request.getRequestDispatcher("/IndexServlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
