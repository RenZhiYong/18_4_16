<%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/27
  Time: 10:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/util/doLogin.jsp" method="post">
    用户名:<input type="text" name="username"><br>
    密码<input type="password" name="password"><br>
    <%
        String info = (String) session.getAttribute("info");
        if (info != null) {
    %>
     <span><%=info%></span>
    <%
        }
    %>
    <input type="submit" value="登录">
</form>


</body>
</html>
