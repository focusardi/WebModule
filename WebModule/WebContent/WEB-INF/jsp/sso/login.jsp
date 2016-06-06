<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../resources/pages/pagebase.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="login" method="POST">
account: <input type="text" name="account" /><br />
password: <input type="password" name="password"><br />
<input type="submit" value="登入" />
</form>

</body>
</html>