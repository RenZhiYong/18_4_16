<%@ page import="com.bdqn.dao.impl.NewsUserDaoImpl" %>
<%@ page import="com.bdqn.dao.NewsUserDao" %>
<%@ page import="com.bdqn.entity.User" %>
<%--
  Created by BDQN-北大青鸟.
  Date: 2018/3/27
  Time: 11:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理登录业务</title>
</head>
<body>
<%
    //处理编码
    request.setCharacterEncoding("utf-8");
    //获取参数
    String name = request.getParameter("uname");
    String pwd = request.getParameter("upwd");

    //访问数据库
    NewsUserDao newsUserDao = new NewsUserDaoImpl();
    User user = newsUserDao.getUser(name, pwd);
    System.out.println(user + "===");
    if (user == null) {
        //用户登录不成功
        System.out.println("buchengong");
        session.setAttribute("info", "用户名或者密码错误");

        //response.sendRedirect("/login.jsp");
%>
<script type="text/javascript">
    alert("用户名或者密码错误!");
    location.href = "/index.jsp";
</script>
<%
    } else {
        session.setAttribute("user", user);
        request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
    }
%>
</body>
</html>
