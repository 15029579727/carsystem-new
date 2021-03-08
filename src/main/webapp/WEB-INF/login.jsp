<!DOCTYPE html>
<%@page  contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="keyword" content="">
	<title></title>
	<link rel="stylesheet" href="/static/css/bootstrap.css" type="text/css">
	<link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="/static/css/style.css" rel="stylesheet">
	<link href="/static/css/style-responsive.css" rel="stylesheet">
	<script src="/static/js/jquery.js"></script>
	<script src="/static/js/jquery-1.8.3.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery.backstretch.min.js"></script>
</head>
<body>
<div id="login-page">
	<div class="container">
		<form class="form-login" action="/login/loginUser" method="get">
			<h2 class="form-login-heading">ログイン</h2>
			<div class="login-wrap">
				<input type="text" name="userName" class="form-control" placeholder="User ID" autofocus>
				<br>
				<input type="password" name="passWord" class="form-control" placeholder="Password">
				<button class="btn btn-theme btn-block" href="index.jsp" type="submit">
					<i class="fa fa-lock"></i>
					ログイン
				</button>
				<div class="login-wrap" style="text-align:center">
					<span name="loginfail"  style="color:red;">${loginMsg}</span>
				</div>
				<hr>
			</div>
		</form>
	</div>
</div>
<script>
	$.backstretch("/static/img/login-bg.jpg", {speed: 500});
</script>
</body>
</html>