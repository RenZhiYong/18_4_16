<%@ page import="com.bdqn.entity.User" %><%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/27
  Time: 11:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎<%=((User) session.getAttribute("user")).getUsername()%>登录成功
</body>
</html>
