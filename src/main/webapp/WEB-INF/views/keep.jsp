<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" flush="true" />
<meta charset="UTF-8">
<title>キープ内容</title>
</head>
<body>

<h3 class="text-center">キープ内容確認</h3>
	<table>
		<tr>
			<th>
				車種
			</th>
			<th>
				レンタル期間｜価格
			</th>
			<th>
				オプション｜価格
			</th>
			<th>
				合計
			</th>
			<th>
				予約/削除
			</th>
		</tr>
	<c:forEach var="reservationCarList" items="${reservationCarList }">
		<tr>
			<td>
				<c:out value="${reservationCarList.carId }"/><br>
			</td>
			<td>
				<c:out value="${reservationCarList.startDate }"/><br>
				〜<br>
				<c:out value="${reservationCarList.endDate }"/><br>
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
				<form action="${pageContext.request.contextPath }/reservation">
					<input type="hidden" name="reservationId" value="${reservationCarList.id }"/>
					<input type="submit" value="予約"/>
				</form>
				<form action="${pageContext.request.contextPath }/keep/delete">
					<input type="hidden" name="deleteId" value="${reservationCarList.id }"/>
					<input type="submit" value="削除"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>