<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>車種一覧</title>
</head>
<body>
<h1>車種一覧</h1>
<c:forEach var="car" items="${carList}">
		<c:out value="${car.id }" />
		<br>
		<a href="<c:url value='${pageContext.request.contextPath}/detail/${car.id }' />">
		<c:out value="${car.name }" /></a>
		<br>
		<c:out value="${car.imagePath }" />
		<br>
	</c:forEach>
</body>
</html>