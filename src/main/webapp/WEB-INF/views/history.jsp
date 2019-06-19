<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>予約履歴</title>
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
<div class="h3 text-center">予約履歴</div>
<br>
	<table class="table table-striped">
	<c:forEach var="reservationHistoryList" items="${reservationHistoryList }" varStatus="status">
		<tr><td colspan="3" class="text-right">予約番号：<c:out value="${reservationHistroyList.reservationId }"/></td></tr>
		<tr>
			<td rowspan="3">
			<c:out value="${car.imagePath }"/><br>
			<c:out value="${car.name }"/>
			</td>
			<td>レンタル期間</td>
			<td>
				開始日時：<c:out value="${reservationHistoryList.startDateStr }"/><br>
				返却日時：<c:out value="${reservationHistoryList.endDateStr }"/><br>
			</td>
		</tr>
		<!-- オプション -->
		<tr>
			<td>オプション</td>
			<td>
				<c:forEach var="optionList" items="${optionManyList}" begin="${status.index}" end="${status.index}">
					<c:forEach var="option" items="${optionList}">
						・<c:out value="${option.name} "/>
					</c:forEach>
				</c:forEach>
			</td>
		</tr>
		<!-- 合計金額 -->
		<tr>
			<td>合計金額</td>
			<td>
				<fmt:formatNumber value="${reservationHistoryList.totalPrice }"/>円<br>
			</td>
		</tr>
		<tr>
			<td colspan="3" class="text-right">
				<form action="${pageContext.request.contextPath }/history/cancel">
					<input type="hidden" name="cancelId" value="${reservationHistoryList.id }"/>
					<input type="submit" class="btn btn-danger btn-sm" value="予約キャンセル" onClick="return check()"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>

</div>
<script>

	function check() {
		return  confirm('本当に予約をキャンセルしますか？');
	}
</script>
</body>
</html>