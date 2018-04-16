package com.bdqn.controller;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.TopicDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.dao.impl.TopicDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TopicDeleteServlet")
public class TopicDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Integer tid = Integer.parseInt(request.getParameter("tid"));
            TopicDao topicDao = new TopicDaoImpl();
            NewsDao newsDao = new NewsDaoImpl();
            int count = newsDao.getNewsCountsByTid(tid);
            if (count>0){
                request.setAttribute("info","删除失败");
            }else{
                int row = topicDao.deleteTopicById(tid);
                request.setAttribute("info","删除成功");
            }
            request.getRequestDispatcher("/TopicListServlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
