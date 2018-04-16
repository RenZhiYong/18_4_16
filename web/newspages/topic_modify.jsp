<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.bdqn.entity.Topic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");
		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</script>

<%
  Topic topic= (Topic) request.getAttribute("topic");
%>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改主题： </h1>
    <form action="/TopicUpdateServlet" method="post" onsubmit="return check()">
      <input type="hidden" name="tid" value="<%=topic.getTid()%>"/><%--隐藏表单--%>
      <p>
        <label> 主题名称 </label>
        <input name="tname" type="text" class="opt_input" value="<%=topic.getTname()%>"/>
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<%@include file="console_element/bottom.html" %>
