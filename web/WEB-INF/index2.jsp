<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.bdqn.dao.impl.NewsDaoImpl" %>
<%@ page import="com.bdqn.dao.NewsDao" %>
<%@ page import="com.bdqn.entity.News" %>
<%@ page import="com.bdqn.dao.TopicDao" %>
<%@ page import="com.bdqn.dao.impl.TopicDaoImpl" %>
<%@ page import="com.bdqn.entity.Topic" %>
<%@ page import="com.sun.org.apache.bcel.internal.generic.NEW" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    function checkPage() {
        var cpage=document.getElementById("currpage").value;
        cpage=parseInt(cpage);
        var totalPage=${requestScope.page.totalPages};
        if(cpage > totalPage || cpage < 1){
            alert("输入的页码!!");
        }
    }

    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">
    <div id="top_login">
        <form action="/UserLoginServlet" method="post" onsubmit="return check()">
            <label> 登录名 </label>
            <input type="text" name="uname" value="" id="uname" class="login_input"/>
            <label> 密&#160;&#160;码 </label>
            <input type="password" name="upwd" id="upwd" value="" class="login_input"/>
            <input type="submit" class="login_sub" value="登录"/>
            <label id="error"> </label>
            <img src="/images/friend_logo.gif" alt="Google" id="friend_logo"/>
        </form>
    </div>
    <div id="nav">
        <div id="logo"><img src="/images/logo.jpg" alt="新闻中国"/></div>
        <div id="a_b01"><img src="/images/a_b01.gif" alt=""/></div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">
    <div class="sidebar">
        <h1><img src="/images/title_1.gif" alt="国内新闻"/></h1>
        <div class="side_list">
            <ul>

                <c:if test="${requestScope.innerNews.size()<0}">
                    测试size是否起作用
                </c:if>

                <c:forEach items="${requestScope.innerNews}" var="news">
                    <li><a href='#'><b>${news.ncontent}</b></a></li>
                </c:forEach>
            </ul>
        </div>
        <h1><img src="/images/title_2.gif" alt="国际新闻"/></h1>
        <div class="side_list">
            <ul>

                <c:forEach items="${requestScope.outterNews}" var="news">
                    <li><a href='#'><b>${news.ncontent}</b></a></li>
                </c:forEach>
            </ul>
        </div>
        <h1><img src="/images/title_3.gif" alt="娱乐新闻"/></h1>
        <div class="side_list">
            <ul>


                <c:forEach items="${requestScope.ylNews}" var="news">
                    <li><a href='#'><b>${news.ncontent}</b></a></li>
                </c:forEach>

            </ul>
        </div>
    </div>
    <div class="main">
        <div class="class_type"><img src="/images/class_type.gif" alt="新闻中心"/></div>
        <div class="content">
            <ul class="class_date">
                <c:set var="count" value="1"></c:set>
                <c:forEach items="${requestScope.allTopics}" var="topic">
                    <c:if test="${count % 11==1}">
                        <li id='class_month'>
                    </c:if>
                    <a href='/SnewsTopServlet?tid=${topic.tid}'><b>${topic.tname}</b></a>
                    <c:if test="${count % 11==0}">
                        </li>
                    </c:if>
                    <c:set value="${count+1}" var="count"></c:set>
                </c:forEach>
            </ul>


            <%--显示的列表--%>
            <ul class="classlist">
                <c:forEach items="${requestScope.page.newsList}" var="news" varStatus="status">
                    <c:if test="${status.count % 6==0}">
                        <li class='space'></li>
                    </c:if>
                    <li><a href='newspages/news_read.jsp'>${news.ncontent}
                    </a><span> ${news.pdate} </span>
                    </li>
                </c:forEach>
                <p align="right">
                    当前页数:${requestScope.page.currentPage}&nbsp;总页数${requestScope.page.totalPages}总记录数${requestScope.page.totalRows}
                    <a href="/IndexServlet?currentPage=1">首页</a>
                    <c:if test="${requestScope.page.currentPage>1}">
                    <a href="/IndexServlet?currentPage=${requestScope.page.currentPage-1}">上一页</a>
                    </c:if>
                    <c:if test="${requestScope.page.currentPage<requestScope.page.totalPages}">
                    <a href="/IndexServlet?currentPage=${requestScope.page.currentPage+1}">下一页</a>
                    </c:if>
                    <a
                            href="/IndexServlet?currentPage=${requestScope.page.totalPages}">末页</a>

                <form action="/IndexServlet" method="get">
                    跳转到<input type="text" name="currentPage" id="currpage" onblur="checkPage()">页<input type="submit" value="跳转"/>
                </form>
                </p>
            </ul>
        </div>
        <div class="picnews">
            <ul>
                <li><a href="#"><img src="images/Picture1.jpg" width="249" alt=""/> </a><a href="#">幻想中穿越时空</a></li>
                <li><a href="#"><img src="images/Picture2.jpg" width="249" alt=""/> </a><a href="#">国庆多变的发型</a></li>
                <li><a href="#"><img src="images/Picture3.jpg" width="249" alt=""/> </a><a href="#">新技术照亮都市</a></li>
                <li><a href="#"><img src="images/Picture4.jpg" width="249" alt=""/> </a><a href="#">群星闪耀红地毯</a></li>
            </ul>
        </div>
    </div>
</div>
<%@include file="index-elements/index_bottom.html" %>
</body>
</html>
