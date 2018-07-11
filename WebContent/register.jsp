<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${message }<br>
	<form action="${pageContext.request.contextPath }/registerServlet" method="post">
		num:<input type="text" name="num"/><br>
		password:<input type="text" name="password"/><br>
		name:<input type="text" name="name"/><br>
		score:<input type="text" name="score"/><br>
		<input type="submit" value="注册"/>
	</form>
	<a href="">register</a>
</body>
</html>