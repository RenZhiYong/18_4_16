package com.bdqn.controller;

import com.bdqn.dao.TopicDao;
import com.bdqn.dao.impl.TopicDaoImpl;
import com.bdqn.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TopicUpdateServlet")
public class TopicUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            int tid = Integer.parseInt(request.getParameter("tid"));
            String tname = request.getParameter("tname");
            TopicDao topicDao = new TopicDaoImpl();
            Topic topic = new Topic();
            topic.setTid(tid);
            topic.setTname(tname);
            int row = topicDao.updateTopicByTid(topic);
            if (row > 0) {
                request.getRequestDispatcher("/TopicListServlet").forward(request, response);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //通过tid查询该主题原始信息
            Integer tid = Integer.parseInt(request.getParameter("tid"));
            TopicDao topicDao = new TopicDaoImpl();
            Topic topic = topicDao.getTopicByTid(tid);
            request.setAttribute("topic", topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/newspages/topic_modify.jsp").forward(request, response);
    }
}
