<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave Management</title>
<link rel="stylesheet" type="text/css" href="ressources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
</head>
<body>
<%
	Object error = request.getAttribute("Error");
	Object success = request.getAttribute("Success");
%>
<div class="container">
	<div class="col-md-offset-1 col-md-10 well vertical-center">
		<h1>Result of the request</h1>
		<div class="alert <% if(error != null) out.print("alert-danger"); else out.print("alert-success"); %>">
			<% if(error != null) out.print(error.toString()); else out.print(success.toString()); %>
		</div>
		<p>
			<a href="Verification">Back to leaving management</a>
		</p>
		<p>
			<a href="Logout">Log out</a>
		</p>
	</div>
</div>
</body>
</html>