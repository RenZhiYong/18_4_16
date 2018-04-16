<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" %>
<%@ page import="com.bdqn.entity.Topic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加主题--管理后台</title>
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        <%
        String info=(String) request.getAttribute("info");
        if (info!=null){
            %>
        alert("<%=info%>");
        <%
        }else{
            %>
        alert("删除失败");
        <%
        }
        %>
    </script>
</head>


<body>
<div id="header">
    <div id="welcome">
        欢迎使用新闻管理系统！
    </div>
    <div id="nav">
        <div id="logo"><img src="../images/logo.jpg" alt="新闻中国"/></div>
        <div id="a_b01"><img src="../images/a_b01.gif" alt=""/></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员： 登录 &#160;&#160;&#160;&#160; <a href="/util/do_logout.jsp?action=loginout">login out</a></div>
    <div id="channel"></div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
    <div id="opt_area">
        <ul class="classlist">
            <%--循环遍历--%>
            <%
                List<Topic> topics = (List<Topic>) request.getAttribute("topics");
                if (topics.size() != 0) {
                    for (Topic topic : topics) {
            %>
            <li><%=topic.getTname()%>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="/TopicUpdateServlet?tid=<%=topic.getTid()%>">修改</a>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="/TopicDeleteServlet?tid=<%=topic.getTid()%>">删除</a>
            </li>
            <%
                    }
                }
            %>
        </ul>
    </div>
    <div id="footer">
        <%@include file="console_element/bottom.html" %>
    </div>
</body>
</html>
