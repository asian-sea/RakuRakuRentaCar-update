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
<div class="p-4"></div>
	<div class="h3 text-center">予約内容確認</div>
	<br>
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
				<div class="card-body">
					<div class="card-text">
					開始日：<c:out value="${reservationCar.startDateStr}"/><br>
					返却日：<c:out value="${reservationCar.endDateStr}"/>
					</div>
				</div>

			<div class="card-header">お支払い方法を選択</div>
				<div class="card-body">
					<div class="card-text">
					<form:form modelAttribute="reservationForm" action="${pageContext.request.contextPath}/reservation/fix">
						<form:radiobuttons path="settlement" items="${settlementMap}"/>　

<%-- 						クレジットカード番号：<form:input type="text" path="cardnum" placeHolder="カード番号"/> --%>
<!-- 						<small class="text-muted">※半角数字、ハイフンなし、14桁または16桁</small> -->

<%-- 						有効期限：<form:select name="month"> --%>
<!-- 						<option value="">-</option> -->
<!-- 						<option value="1">1</option> -->
<!-- 						<option value="2">2</option> -->
<!-- 						<option value="3">3</option> -->
<!-- 						<option value="4">4</option> -->
<!-- 						<option value="5">5</option> -->
<!-- 						<option value="6">6</option> -->
<!-- 						<option value="7">7</option> -->
<!-- 						<option value="8">8</option> -->
<!-- 						<option value="9">9</option> -->
<!-- 						<option value="10">10</option> -->
<!-- 						<option value="11">11</option> -->
<!-- 						<option value="12">12</option> -->
<%-- 						</form:select> --%>
<%-- 						<form:select name="year"> --%>
<!-- 						<option value="">-</option> -->
<!-- 						<option value="2019">2019</option> -->
<!-- 						<option value="2020">2020</option> -->
<!-- 						<option value="2021">2021</option> -->
<!-- 						<option value="2022">2022</option> -->
<!-- 						<option value="2023">2023</option> -->
<!-- 						<option value="2024">2024</option> -->
<!-- 						<option value="2025">2025</option> -->
<!-- 						<option value="2026">2026</option> -->
<!-- 						<option value="2027">2027</option> -->
<!-- 						<option value="2028">2028</option> -->
<!-- 						<option value="2029">2029</option> -->
<!-- 						<option value="2030">2030</option> -->
<%-- 						</form:select> --%>
<!-- 						カード名義人：<input type="text" name="cardname"/> -->
<!-- 						セキュリティーコード：<input type="text" name="security"/> -->
<!-- 						<br> -->
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