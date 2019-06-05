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
</head>
<body>
	<h1>日付・オプション選択画面</h1>
	<c:out value="${car.id}"/><br>
	<c:out value="${car.name}"/><br>
	<c:out value="${car.grade.id}"/><br>
	<c:out value="${car.grade.name}"/><br>
	<div id="gradePrice">
		<fmt:formatNumber value="${car.grade.price}"/>円<br>
	</div>
	<c:out value="${car.shop.id}"/><br>
	<c:out value="${car.shop.name}"/><br>
	<c:out value="${car.shop.address}"/><br>
	<img src="/img/<c:out value="${car.imagePath}"/>" style="width:200px"><br>
	<form:form modelAttribute="reservationCarForm" action="${pageContext.request.contextPath}/keep/add">
		<input type="hidden" name="carId" value="${car.id}"/><br>

		開始時間<form:input path="startDate" class="flatpickr"/><br>
		返却時間<form:input path="endDate" class="flatpickr"/><br>
		<c:forEach var="option" items="${optionList}" varStatus="status">
			<form:checkbox path="optionList" value="${option.id}"/>
			<c:out value="${option.name} "/>
			<div class="optionPrice">
				<c:out value="${option.price}円"/><br>
			</div>
		</c:forEach>
		<input type="submit" value="キープする"><br>
	</form:form>
	<div id="totalPrice"></div>
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
			$('#totalPrice').text('金額: ' + totalPrice + '円');
			if (totalPrice > 0 == false) {
				$('#totalPrice').text('金額: --- 円 ');
			}
		}
	</script>
</body>
</html>