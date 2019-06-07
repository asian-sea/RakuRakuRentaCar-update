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
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
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
	<div class="m-5"></div>
	<div class="text-centermb-3"><h3>日付・オプション選択画面</h3></div>
	<div class="card text-center">
		<div class="card-header">車種</div>
		<div class="card-body border-bottom">
			<img src="/img/<c:out value="${car.imagePath}"/>" style="width:200px"><br>
			<div class="card-text"><c:out value="${car.name}"/><br></div>
		</div>

		<div class="card-header">クラス</div>
		<div class="card-body border-bottom">
			<div class="card-text"><c:out value="${car.grade.name}"/><br></div>
<!-- 		<div id="gradePrice"> -->
<%-- 		<fmt:formatNumber value="${car.grade.price}"/>円<br> --%>
		</div>

		<div class="card-header">営業所</div>
		<div class="card-body border-bottom">
			<div class="card-text"><c:out value="${car.shop.name}"/><br>
			<c:out value="${car.shop.address}"/><br></div>
		</div>

	<form:form modelAttribute="reservationCarForm" action="${pageContext.request.contextPath}/keep/add">
		<input type="hidden" name="carId" value="${car.id}"/><br>

		<div class="card-header">レンタル期間</div>
		<div class="card-body border-bottom">
		<div class="card-text">開始時間<form:input path="startDate" class="flatpickr"/><br>
		返却時間<form:input path="endDate" class="flatpickr"/><br></div>
		</div>

		<div class="card-header">オプション</div>
		<div class="card-body border-bottom">
		<div class="card-text"><c:forEach var="option" items="${optionList}" varStatus="status">
			<form:checkbox path="optionList" value="${option.id}"/>
			<c:out value="${option.name} "/>
			<div class="optionPrice">
				<c:out value="${option.price}円"/><br></div>
			</c:forEach>
			</div>
		</div>
		<div class="card my-4">
  			<h5 class="card-header">合計金額</h5>
  			<div class="card-body">
				<div id="totalPrice"></div>
		<input type="submit" class="btn btn-primary" value="キープする"><br>
			</div>
			</div>
	</form:form>
	<div class="mb-5"></div>
	</div>
	</div>
	<script>
		// カレンダー
		flatpickr(".flatpickr", {
			enableTime: true,
		});

		//===== 以下合計金額計算用ソース

		// jspファイル読み込み時に計算させる
		calc_price();

		// チェックボックスにイベントリスナー追加
		$('input:checkbox').on('change', function() {
			calc_price();
		});

		// カレンダーにイベントリスナー追加
		$('.flatpickr').on('change', function() {
			calc_price();
		});

		// 値段の計算をして変更する関数
		function calc_price() {

			// 基本料金
			var gradePriceStr = $('#gradePrice').text().replace(/[^0-9]/g, '');
			var gradePrice = parseInt(gradePriceStr);

			// オプションリスト料金
			var checked = $('input:checkbox:checked');
			var checkedListPrice = [];
			$.each(checked, function(i, value) {
				var checkedPriceStr = value.nextElementSibling.nextElementSibling.textContent.replace(/[^0-9]/g, '');
				checkedListPrice.push(parseInt(checkedPriceStr));
			})
			var optionPrice = 0;
			checkedListPrice.forEach(i => {
				optionPrice += i;
			});

			// 時間倍率計算
			var startDateStr = $('input[name="startDate"]').val().replace(/-/g, '/');
			var endDateStr = $('input[name="endDate"]').val().replace(/-/g, '/');
			var startDate = new Date(startDateStr);
			var endDate = new Date(endDateStr);
			var diffTime = endDate.getTime() - startDate.getTime();
			var diffHour = Math.ceil(diffTime / (1000 * 60 * 60))
			console.log(diffHour);

			// 合計金額
			var totalPrice = gradePrice * diffHour + optionPrice;
			if (totalPrice > 0 == false) {
				$('#totalPrice').text(' --- 円 ');
				$('input:submit').prop('disabled', true);
			} else {
				$('#totalPrice').text(' ' + totalPrice + '円');
				$('input:submit').prop('disabled', false);
			}
		}
	</script>
</body>
</html>