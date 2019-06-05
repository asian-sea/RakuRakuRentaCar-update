<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME画面</title>
<jsp:include page="header.jsp" flush="true" />
</head>
<body>
	<h1>楽楽レンタカー</h1>
	<br>
	<br>
	<h2>検索</h2>
	<form:form modelAttribute="carForm" action="${pageContext.request.contextPath}/car/toCarList2">
		<form:select path="shopId" items="${shopMap}"/><br>
		<form:select path="gradeId" items="${gradeMap}"/><br>
		<input type="submit" value="検索">
	</form:form>

	<br>
	<br>
	<h2>営業所から選ぶ</h2>
	<c:forEach var="shop" items="${shopList}">
		<c:out value="${shop.id }" />
		<br>
		<a href="<c:url value='${pageContext.request.contextPath}/car/toCarList/${shop.id }' />">
			<c:out value="${shop.name }" />
		</a>
		<br>
		<c:out value="${shop.address }" />
		<br>
	</c:forEach>
	<br>
	<br>
	<h2>クラスから選ぶ</h2>
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