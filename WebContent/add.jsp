<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Userservlet">
<span>学号</span><input name="studentID" type="text"><br>
<span>姓名:</span><input name="name" type="text"><br>
<span>年龄:</span><input name="age" type="text"><br>
<span>身份证号:</span><input name="number_ID" type="text"><br>
<span>家庭住址:</span><input name="address" type="text"><br>
<input type="submit" value="添加">
</form>
</body>
</html>