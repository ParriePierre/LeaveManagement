<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connection error</title>
<link rel="stylesheet" type="text/css" href="ressources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
</head>
<body>
<div class="container">
	<div class="col-md-offset-3 col-md-6 alert alert-danger vertical-center">
		<h3>Error:</h3>
		<p>
			<%
				out.println(request.getAttribute("ErrorType").toString());
			%>
		</p>
		<p>
			<a href='/LeaveManagement/Authentification'>Go back to the log in page.</a>
		</p>
	</div>
</div>
</body>
</html>