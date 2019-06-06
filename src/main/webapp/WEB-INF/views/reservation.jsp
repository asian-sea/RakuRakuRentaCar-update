<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約内容確認</title>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
body{
	margin-top:80px;
	margin-bottom:10px;
}
</style>
</head>
<body>
<div class="container">
	<div class="text-center mt-5 mb-3"><h3>予約内容確認</h3></div>
		<div class="card text-center">
			<div class="card-header">予約ID</div>
				<div class="card-body border-bottom">
					<div class="card-text"><c:out value="${reservationCar.id}"/></div>
				</div>

			<div class="card-header">車種</div>
				<div class="card-body border-bottom">
					<div class="card-text"><c:out value="${car.name}"/></div>
				</div>

			<div class="card-header">レンタル期間</div>
				<div class="card-body border-bottom">
					<div class="card-text">
					開始日：<c:out value="${reservationCar.startDate}"/><br>
					返却日：<c:out value="${reservationCar.endDate}"/>
					</div>
				</div>

			<div class="card-header">お支払い方法を選択</div>
				<div class="card-body">
					<div class="card-text">
					<form:form modelAttribute="reservationForm" action="${pageContext.request.contextPath}/reservation/fix">
						<form:radiobuttons path="settlement" items="${settlementMap}"/>
						<br>
						<div class="mt-3">
						<input type="hidden" name="id" value="${reservationCar.id }" />
						<input type="submit" class="btn btn-primary" value="予約"/>
						</div>
					</form:form>

					</div>
				</div>

		</div>

	</div>
</body>
</html>