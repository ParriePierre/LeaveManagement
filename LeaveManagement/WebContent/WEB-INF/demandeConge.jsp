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
	<div class="col-md-offset-1 col-md-10 well vertical-center">
		<h1>Request of leaving</h1>
		<form method="post">
			<div class="form-group">
				<label for="day">Day</label>
				<input type="text" name="day" id="day" class="form-control">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<p>
			<a href="Logout">Log out</a>
		</p>
	</div>
</div>
</body>
</html>