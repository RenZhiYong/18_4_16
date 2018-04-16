<%@ page import="com.bdqn.dao.impl.NewsDaoImpl" %>
<%@ page import="com.bdqn.dao.NewsDao" %>
<%@ page import="com.bdqn.entity.News" %>
<%@ page import="java.util.List" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/29
  Time: 10:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点击某个主题  显示该主题下 新闻列表</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    int tid = Integer.parseInt(request.getParameter("tid"));
    NewsDao newsDao = new NewsDaoImpl();
    List<News> listNews = newsDao.getNewsByTid(tid);
    request.setAttribute("list",listNews);
    System.out.println("aaaaa");
    request.getRequestDispatcher("/index.jsp").forward(request,response);
%>
</body>
</html>
