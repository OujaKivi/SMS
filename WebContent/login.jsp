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
	<form action="${pageContext.request.contextPath }/loginServlet" method="post">
		num:<input type="text" name="num"/><br>
		password:<input type="text" name="password"/><br>
		<input type="submit" value="登录"/>
	</form>
	<a href="${pageContext.request.contextPath}/toRegisterServlet" >register</a>
</body>
</html>