<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.entity.Topic" %>
<%@ page import="java.util.List" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/28
  Time: 11:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取所有的主题</title>
</head>
<body>
    <%--从数据库里查询所有主题--%>
    <%
        TopicDao topicDao = new TopicDaoImpl();
        List<Topic> topics = topicDao.getAllTopics();
        request.setAttribute("topics",topics);
        request.getRequestDispatcher("/newspages/topic_list.jsp").forward(request,response);
    %>
</body>
</html>
