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
</style>
</head>
<body>
<div class="container">
	<div class="text-center mt-5 mb-3"><h3>車種一覧</h3></div>
		<c:forEach var="car" items="${carList}">
		<div class="float-left">
			<img src="/img/<c:out value='${car.imagePath }' />" style="width:200px;"><br>
			<div class="text-center"><c:out value="${car.name }"/></div>
			<br>
			<div class="text-center">
			<a href="<c:url value='${pageContext.request.contextPath}/car/detail/${car.id }' />">
			<input type="submit" class="btn btn-warning" value="この車種で予約する"/></a>
			</div>
			<br>
		</div>
		</c:forEach>
</div>
</body>
</html>