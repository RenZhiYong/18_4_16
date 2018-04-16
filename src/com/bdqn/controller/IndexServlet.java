package com.bdqn.controller;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.TopicDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.dao.impl.TopicDaoImpl;
import com.bdqn.entity.News;
import com.bdqn.entity.Page;
import com.bdqn.entity.Topic;
import com.bdqn.service.NewsService;
import com.bdqn.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            //查询数据库 获取某个主题下的新闻列表
            NewsDao newsDao = new NewsDaoImpl();
            TopicDao topicDao = new TopicDaoImpl();
            List<News> ylNews = newsDao.getNewsByTid(3);
            List<News> outterNews = newsDao.getNewsByTid(2);
            List<News> innerNews = newsDao.getNewsByTid(1);

            List<News> allNews = null;
            allNews = (List<News>) request.getAttribute("allNews");
            //查询所有的主题和所有的新闻
            NewsService newsService = new NewsServiceImpl();


            //规定分页的相关信息

            //1.获取当前的页码
            String cPage = request.getParameter("currentPage");

            Integer currentPage;
            if (cPage == null) {
                currentPage = 1;
            } else {
                currentPage = Integer.parseInt(cPage);
            }

            //规定每页显示的条数
            Integer pageSize = 3;

            Page page = null;
            if (allNews == null) {
                page = newsService.getAllNews(currentPage, pageSize);
            }
            List<Topic> allTopics = topicDao.getAllTopics();
            //存值
            request.setAttribute("ylNews", ylNews);
            request.setAttribute("outterNews", outterNews);
            request.setAttribute("innerNews", innerNews);
            request.setAttribute("allTopics", allTopics);
            request.setAttribute("page", page);
            request.getRequestDispatcher("/index2.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
