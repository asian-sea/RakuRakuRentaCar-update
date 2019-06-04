<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="item_list.html"> <!-- 企業ロゴ --> <img
						alt="main log" src="img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="cart_list.html" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
					</p>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		
		<!-- login form -->
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
				<div class="well">
						<fieldset>
							<legend>
								ログイン
							</legend>
							
							<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login/loginform">
							<div class="form-group">
 								<label for="inputEmail">メールアドレス:</label>
								<form:input path="email" placeholder="Email"/>
								<br><form:errors path="email" cssStyle="color:red"/>
							</div>
							<div class="form-group">
								<label for="inputPassword">パスワード:</label>
								<form:password path="password" placeholder="Password"/>
								<br><form:errors path="password" cssStyle="color:red"/>
							</div>
							<div class="form-group">
								<input class="btn btn-primary" type="submit" value="ログイン">
							</div>
							</form:form>
	
							
						</fieldset>
					
				</div>
			</div>
		</div>

		<div class="row">
			<div class="text-center">
				<a href="/account/newAccount">ユーザ登録はこちら</a>
			</div>
		</div>
		
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>