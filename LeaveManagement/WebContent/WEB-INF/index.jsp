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
<div class="container">
	<div class="col-md-offset-3 col-md-6 well vertical-center">
		<h1>Leave Management</h1>
		<form action="Authentification" method="post">
			<div class="form-group">
				<label for="login">Login</label>
				<input type="text" name="login" id="login" class="form-control">
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" class="form-control">
			</div>
			<button type="submit" class="btn btn-default">Log in</button>
		</form>
	</div>
</div>
</body>
</html>