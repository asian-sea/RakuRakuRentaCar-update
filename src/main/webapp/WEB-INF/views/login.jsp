<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<jsp:include page="header.jsp" flush="true" />
</head>
<body>



<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login/loginform">


<label for="inputEmail">メールアドレス:</label>
<form:input path="email" placeholder="Email"/>
<br><form:errors path="email" cssStyle="color:red"/><br>

<label for="inputPassword">パスワード:</label>
<form:password path="password" placeholder="Password"/>
<br><form:errors path="password" cssStyle="color:red"/>
<br><form:errors cssStyle="color:red"/>

<br><input class="btn btn-primary" type="submit" value="ログイン">
</form:form>



<br><a href="/account/newAccount">新規ユーザ登録はこちら</a>


</body>
</html>