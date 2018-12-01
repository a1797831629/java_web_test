<%@page import="package_java_test.UserInfo"%>
<%@page import="java.util.List"%>
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
List<UserInfo> list=(List)request.getAttribute("list");



	

%>
<table align="center" >
<tr>
<th>学号</th>
<th>姓名</th>
<th>年龄</th>
<th>身份证号</th>
<th>家庭住址</th>
<th>操作</th>
</tr>
<%for(UserInfo uInfo:list){ %>
<tr>
<td width="50px"><%=uInfo.getStudentID() %></td>
<td width="50px"><%=uInfo.getName() %></td>
<td width="50px"><%=uInfo.getAge() %></td>
<td width="200px"><%=uInfo.getID_number() %></td>
<td width="200px"><%=uInfo.getAddress() %></td>
<td>

<a href="Servlet_delete?StudentID=<%=uInfo.getStudentID()%>">删除</a>/
<a href="update.jsp?StudentID=<%=uInfo.getStudentID()%>">修改</a>


</td>
</tr>
<%} %>
</table>
</body>
<style>
table tr {
border:1px solid black ;
text-align:center;
}


</style>
</html>