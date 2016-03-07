<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
</head>
<body>
<h1>Welcome ${sessionScope.username}!</h1>
<p>Have a nice day!</p>
<form action="Logout" method="get">
<input type="submit" name="logout" value="Logout">
<%
session.invalidate();
%>
</form>

</body>
</html>