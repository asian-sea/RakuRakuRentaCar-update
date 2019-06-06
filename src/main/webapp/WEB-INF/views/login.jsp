<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<jsp:include page="header-logout.jsp" flush="true" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login/loginform">
	<div class="border col-12">
		<div class="text-center">
		<label for="inputEmail" class="mt-4">メールアドレス:</label>
		<form:input path="email" placeholder="Email"/>
		<br><form:errors path="email" cssStyle="color:red"/><br>
		<br>

		<label for="inputPassword">パスワード:</label>
		<form:password path="password" placeholder="Password"/>
		<br><form:errors path="password" cssStyle="color:red"/>
		<br><form:errors cssStyle="color:red"/>

		<br><input class="btn btn-primary" type="submit" value="ログイン">
		<br>
		<br><a href="/account/newAccount">新規ユーザ登録はこちら</a>
		<div class="mb-4"></div>
		</div>
	</div>
</form:form>
</div>

<!-- <!-- end container -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js"></script> -->
</body>
</html>