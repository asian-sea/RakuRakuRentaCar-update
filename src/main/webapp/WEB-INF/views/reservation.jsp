<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body{
	margin-top:80px;
	margin-bottom:10px;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.card-detail').hide();
  		$('[name="settlement"]:radio').change(function(){
  			if($('[value=0]').prop('checked')){
  				$('.card-detail').hide();
  			}else if($('[value=1]').prop('checked')){
  				$('.card-detail').show();
  			}
  		});
	});
</script>
</head>
<body>
<div class="container">
<div class="p-4"></div>
	<div class="h3 text-center">予約内容確認</div>
	<br>
		<div class="card text-center">

			<div class="card-header">車種</div>
				<div class="card-body border-bottom">
					<img src="${pageContext.request.contextPath }/img/<c:out value="${car.imagePath }"/>" style="width:200px"><br>
					<div class="card-text"><c:out value="${car.name}"/></div>
				</div>

			<div class="card-header">レンタル期間</div>
				<div class="card-body">
					<div class="card-text">
					開始日：<c:out value="${reservationCar.startDateStr}"/><br>
					返却日：<c:out value="${reservationCar.endDateStr}"/>
					</div>
				</div>

			<div class="card-header border-top">オプション</div>
				<div class="card-body">
					<div class="card-text">
<%-- 					<c:forEach var="optionList" items="${optionManyList}" begin="${status.index}" end="${status.index}"> --%>
							<c:forEach var="option" items="${optionManyList}">
								・<c:out value="${option.name} "/>
							</c:forEach>
<%-- 					</c:forEach> --%>
					</div>
				</div>

			<div class="card-header border-top">合計金額</div>
				<div class="card-body">
					<div class="card-text">
						<fmt:formatNumber value="${reservationCarList.totalPrice }"/>円<br>
				</div>

			<div class="card-header border-top">お支払い方法を選択</div>
				<div class="card-body">
					<div class="card-text">
					<form:form modelAttribute="reservationForm" action="${pageContext.request.contextPath}/reservation/fix">
						<form:radiobutton id="settlement" name="settlement" path="settlement" value="0" checked="checked"/>代金引換
						　<form:radiobutton id="settlement" name="settlement" path="settlement" value="1"/>クレジットカード決済
					<div class="card-detail">
						<br>
						クレジットカード番号：<input type="text" name="cardnum"
						pattern="[0-9]{14}|[0-9]{16}" title="14桁または16桁の半角数字" required/><br>
						<small class="text-muted">※半角数字、ハイフンなし、14桁または16桁</small><br>
						<br>
						有効期限：<select name="month" required>
						<option value="">-</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						</select>
						<select name="year" required>
						<option value="">-</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
						<option value="2023">2023</option>
						<option value="2024">2024</option>
						<option value="2025">2025</option>
						<option value="2026">2026</option>
						<option value="2027">2027</option>
						<option value="2028">2028</option>
						<option value="2029">2029</option>
						<option value="2030">2030</option>
						</select><br>
						<br>
						カード名義人：<input type="text" name="cardname" placeholder="例)TARO YAMADA"
						pattern="[A-Z\s]{1,50}" title="半角英字(大文字)" required/><br>
						<small class="text-muted">※半角英字</small><br>
						<br>
						セキュリティーコード：<input type="text" name="security" pattern="[0-9]{3}" title="3文字の半角数字" required/><br>
						<small class="text-muted">※3文字の半角数字</small><br>
					</div>
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
</div>
	<script>
		$.post('http://172.16.0.13:8080/web-api-sample/credit-card/payment',
				'user_id="" & order_number="" & amount="" & card_number=""')
	</script>
</body>
</html>