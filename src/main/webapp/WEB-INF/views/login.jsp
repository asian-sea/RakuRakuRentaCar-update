<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<jsp:include page="header.jsp" flush="true" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
body{
	margin-top:120px;
	margin-bottom:10px;
}
</style>
</head>
<body>
<div class="container">
<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login/loginform">
	<div class="row">
		<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header">ログイン</div>
					<div class="card-body">
					<div class="form-group">
					<label for="inputEmail">メールアドレス</label><br>
					<form:input path="email" id="inputEmail" class="form-control" placeholder="Email"/>
					<br><form:errors path="email" cssStyle="color:red"/><br>
					<br>

					<label for="inputPassword">パスワード</label><br>
					<form:password path="password" id="inputPasword" class="form-control" placeholder="Password"/>
					<br><form:errors path="password" cssStyle="color:red"/>
					<br><form:errors cssStyle="color:red"/>

					<div class="text-center">
					<input class="btn btn-primary" type="submit" value="ログイン">
					<br>
					<br><a href="/account/newAccount">新規ユーザ登録はこちら</a>
					<div class="mb-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</form:form>
</div>

<!-- <!-- end container -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js"></script> -->
</body>
</html>