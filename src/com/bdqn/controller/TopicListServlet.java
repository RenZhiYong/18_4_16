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
import java.util.List;

@WebServlet("/TopicListServlet")
public class TopicListServlet extends BaseServlet {
    //查询所有主体
    public String topicList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TopicDao topicDao = new TopicDaoImpl();
            List<Topic> topics = topicDao.getAllTopics();
            request.setAttribute("topics", topics);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/newspages/topic_list.jsp";

    }

    //删除主题
    public String topicDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        return null;
    }

    //修改主题
    public void topicUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    //添加主题
    public void topicAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }


   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TopicDao topicDao = new TopicDaoImpl();
            List<Topic> topics = topicDao.getAllTopics();
            request.setAttribute("topics", topics);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/newspages/topic_list.jsp").forward(request, response);
    }*/
}
