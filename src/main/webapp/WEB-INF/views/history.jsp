<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="UTF-8">
<title>予約履歴</title>
</head>
<body>

<h3 class="text-center">予約履歴</h3>
	<table class="table table-striped">
		<tr>
			<th>
				車種
			</th>
			<th>
				レンタル期間
			</th>
			<th>
				オプション
			</th>
			<th>
				合計価格
			</th>
			<th>
				予約キャンセル
			</th>
		</tr>
	<c:forEach var="reservationHistoryList" items="${reservationHistoryList }">
		<tr>
			<td>
				<c:out value="${reservationHistoryList.carId }"/><br>
			</td>
			<td>
				<c:out value="${reservationHistoryList.startDate }"/><br>
				〜<br>
				<c:out value="${reservationHistoryList.endDate }"/><br>
			</td>
			<!-- オプション -->
			<td>
				<c:out value=" "/><br>
			</td>
			<!-- 合計価格 -->
			<td>
				<c:out value=" "/><br>
			</td>
			<td>
				<form action="${pageContext.request.contextPath }/history/cancel">
					<input type="hidden" name="cancelId" value="${reservationHistoryList.id }"/>
					<input type="submit" class="btn btn-danger btn-sm" value="予約キャンセル"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>