<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>車種一覧</title>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.container{
	float:left;
}
</style>
</head>
<body>
<h1>車種一覧</h1>
<div class="container">
	<c:forEach var="car" items="${carList}">
		<img src="/img/<c:out value='${car.imagePath }' />" style="width:200px">
		<br>
		<div class="text-center">
		<a href="<c:url value='${pageContext.request.contextPath}/car/detail/${car.id }' />">
		<c:out value="${car.name }" /></a>
		</div>
	</c:forEach>
</div>
</body>
</html>