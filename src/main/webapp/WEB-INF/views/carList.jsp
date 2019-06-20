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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body{
	margin-top:80px;
	margin-bottom:10px;
}
</style>
</head>
<body>
<div class="container">
	<div class="p-4"></div>
	<div class="h3 text-center">車種一覧</div>
	<br>
		<div class="row">
		<c:forEach var="car" items="${carList}">
		<div class="col-6 col-sm-4">
			<div class="text-center">
			<img src="/img/<c:out value='${car.imagePath }' />" style="width:200px;"><br>
			<c:out value="${car.name }"/><br>
			<br>
			<a href="<c:url value='${pageContext.request.contextPath}/car/detail/${car.id }' />">
			<input type="submit" class="btn btn-warning" value="この車種で予約する"/></a>
			<br><br>
			</div>
		</div>
		</c:forEach>
		</div>
</div>
</body>
</html>