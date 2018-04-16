<%--
  Created by BDQN-北大青鸟.
  Date: 2018/4/3
  Time: 16:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>配置信息</title>
</head>
<body>
    <jsp:useBean id="user" class="com.bdqn.entity.User"></jsp:useBean>
    <jsp:setProperty name="user" property="username" value="admin"></jsp:setProperty>
    <jsp:getProperty name="user" property="username"></jsp:getProperty>

</body>
</html>
