<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.dao.impl.NewsDaoImpl" %>
<%@ page import="com.bdqn.dao.NewsDao" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/28
  Time: 11:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除主题</title>
</head>
<body>
<%
    Integer tid = Integer.parseInt(request.getParameter("tid"));
    TopicDao topicDao = new TopicDaoImpl();
    NewsDao newsDao = new NewsDaoImpl();
    int count = newsDao.getNewsCountsByTid(tid);
    if (count > 0) {
%>
<%--主题下面有新闻不能删除--%>
<script type="text/javascript">
    alert("对不起,主题下面还有新闻,不能删除");
    location.href = "/util/do_topic_list.jsp";
</script>
<%
        return;
    }
    int row = topicDao.deleteTopicById(tid);
    if (row > 0) {
%>
<script type="text/javascript">
    alert("删除成功!");
    location.href = "/util/do_topic_list.jsp";
</script>
<%
    }
%>
</body>
</html>
