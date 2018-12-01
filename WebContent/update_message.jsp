<%@page import="package_java_test.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserInfo userInfo=(UserInfo)request.getAttribute("Info");
%>
<div>修改成功,修改的信息如下</div>
<div>
<span>学号</span><span><%=userInfo.getStudentID() %></span><br>
<span>姓名:</span><span><%=userInfo.getName() %></span><br>
<span>年龄:</span><span><%=userInfo.getAge() %></span><br>
<span>身份证号:</span><span><%=userInfo.getID_number() %></span><br>
<span>家庭住址:</span><span><%=userInfo.getAddress() %></span><br>
</div>
</body>
</html>