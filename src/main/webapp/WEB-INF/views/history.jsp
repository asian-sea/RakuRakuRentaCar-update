<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" flush="true" />
<meta charset="UTF-8">
<title>予約履歴</title>
</head>
<body>

<h3 class="text-center">予約履歴</h3>
	<table>
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
					<input type="submit" value="予約キャンセル"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>