<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.entity.Topic" %>
<%@ page import="org.omg.CORBA.IRObject" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/28
  Time: 12:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理修改后的数据</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    int tid = Integer.parseInt(request.getParameter("tid"));
    String tname = request.getParameter("tname");
    TopicDao topicDao = new TopicDaoImpl();
    Topic topic = new Topic();
    topic.setTid(tid);
    topic.setTname(tname);
    int row = topicDao.updateTopicByTid(topic);
    if (row > 0) {
%>
    <script type="text/javascript">
        alert("修改成功");
        location.href="/util/do_topic_list.jsp";
    </script>
<%
    }
%>
</body>
</html>
