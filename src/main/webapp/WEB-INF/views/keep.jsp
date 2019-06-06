<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>キープ内容</title>
<meta charset="UTF-8">
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h3>キープ内容確認</h3>
<div class="container">
	<table class="table table-striped">
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
				<form action="${pageContext.request.contextPath }/reservation/">
					<input type="hidden" name="status" value="${reservationCarList.id }"/>
					<input type="submit" class="btn btn-primary btn-sm" value="予約"/>
				</form>
				<br>
				<form action="${pageContext.request.contextPath }/keep/delete">
					<input type="hidden" name="deleteId" value="${reservationCarList.id }"/>
					<input type="submit" class="btn btn-danger btn-sm" value="削除"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>