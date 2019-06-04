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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>
<body>
	<h1>日付・オプション選択画面</h1>
	<c:out value="${car.id}"/><br>
	<c:out value="${car.name}"/><br>
	<c:out value="${car.grade.id}"/><br>
	<c:out value="${car.grade.name}"/><br>
	<fmt:formatNumber value="${car.grade.price}"/>円/3時間<br>
	<c:out value="${car.shop.id}"/><br>
	<c:out value="${car.shop.name}"/><br>
	<c:out value="${car.shop.address}"/><br>
	<img src="/img/<c:out value="${car.imagePath}"/>" style="width:200px"><br>
	<form:form modelAttribute="reservationCarForm" action="${pageContext.request.contextPath}/keep/add">
		<input type="hidden" name="carId" value="${car.id}"/><br>
		開始時間<form:input path="startDate" id="flatpickr"/><br>
		返却時間<form:input path="endDate" id="flatpickr"/><br>
		<form:checkboxes path="optionList" items="${optionList}" itemLabel="name" itemValue="id" delimiter="<br>"/><br>
		<input type="submit" value="キープする"><br>
	</form:form>
	<script>
		flatpickr("#flatpickr", {
			enableTime: true,
		});
	</script>
</body>
</html>