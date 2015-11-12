<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave Management</title>
</head>
<body>
<h1>Leave Management</h1>
<form action="localhost:8888/LeaveManagement/Authentification" method="post">
	<table>
		<tr>
			<td>Login</td>
			<td><input type="text" name="login"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login">
	</table>
</form>
</body>
</html>