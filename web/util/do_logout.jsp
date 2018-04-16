<%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/28
  Time: 10:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理注销业务</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("/index.jsp");
%>
</body>
</html>
