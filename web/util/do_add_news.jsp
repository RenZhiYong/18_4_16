<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.entity.Topic" %>
<%@ page import="java.util.List" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/29
  Time: 11:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理添加新闻</title>
</head>
<body>

<%
    //查询所有的主体
    TopicDao topicDao = new TopicDaoImpl();
    List<Topic> allTopics = topicDao.getAllTopics();
    request.setAttribute("topics",allTopics);
    request.getRequestDispatcher("/newspages/news_add.jsp").forward(request,response);
%>
</body>
</html>
