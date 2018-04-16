<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.bdqn.dao.impl.NewsDaoImpl" %>
<%@ page import="com.bdqn.dao.NewsDao" %>
<%@ page import="com.bdqn.entity.News" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.entity.Topic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新闻中国</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
    <script language="javascript">
        function check() {
            var login_username = document.getElementById("uname");
            var login_password = document.getElementById("upwd");
            if (login_username.value == "") {
                alert("用户名不能为空！请重新填入！");
                login_username.focus();
                return false;
            } else if (login_password.value == "") {
                alert("密码不能为空！请重新填入！");
                login_password.focus();
                return false;
            }
            return true;
        }

        function focusOnLogin() {
            var login_username = document.getElementById("uname");
            login_username.focus();
        }
    </script>
</head>
<%--<%
    request.getRequestDispatcher("/xxxserlct").forward(request,response);
%>--%>
<jsp:forward page="/IndexServlet"></jsp:forward>
</body>
</html>
