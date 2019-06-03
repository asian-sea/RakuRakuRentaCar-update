<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>予約内容確認</h1>
	予約ID:<c:out value="${reservationCar.id}"/><br>
	車両ID:<c:out value="${reservationCar.carId}"/><br>
	予約ID:<c:out value="${reservationCar.reservationId}"/><br>
	利用開始日時:<c:out value="${reservationCar.startDate}"/><br>
	返却日時:<c:out value="${reservationCar.endDate}"/><br>
	オプション:<c:out value="${reservationCar.option}"/><br>

	<h2>お支払い方法</h2>
	<form:form modelAttribute="reservationForm" action="${pageContext.request.contextPath}/reservation/fix">
		決済方法<form:radiobuttons path="settlement" items="${settlementMap}"/><br>
		<input type="submit" value="予約">
	</form:form>
</body>
</html>