<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP画面</title>
</head>
<body>
	<h1>楽楽レンタカー</h1>
	<c:forEach var="shop" items="${shopList}">
		<c:out value="${shop.id }" />
		<br>
		<a
			href="<c:url value='${pageContext.request.contextPath}/car/toCarList/${shop.id }' />">
			<c:out value="${shop.name }" />
		</a>
		<br>
		<c:out value="${shop.address }" />
		<br>
	</c:forEach>
	<br>
	<br>
	<c:forEach var="grade" items="${gradeList}">
		<c:out value="${grade.id }" />
		<br>
		<a
			href="<c:url value='${pageContext.request.contextPath}/car/toCarList1/${grade.id }' />">
			<c:out value="${grade.name }" />
		</a>
		<br>
		<c:out value="${grade.price }" />
		<br>
	</c:forEach>
</body>
</html>