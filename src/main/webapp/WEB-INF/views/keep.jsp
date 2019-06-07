<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>キープ内容</title>
<meta charset="UTF-8">
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
<div class="h3 text-center">キープ内容確認</div>
<br>
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
	<c:forEach var="reservationCarList" items="${reservationCarList }" varStatus="status">
		<tr>
			<td>
				<c:out value="${reservationCarList.carId }"/><br>
			</td>
			<td>
				<c:out value="${reservationCarList.startDateStr }"/><br>
				〜<br>
				<c:out value="${reservationCarList.endDateStr }"/><br>
			</td>
			<!-- オプション -->
			<td>
			<c:forEach var="optionList" items="${optionManyList}" begin="${status.index}" end="${status.index}">
				<c:forEach var="option" items="${optionList}">
					・<c:out value="${option.name} "/>
				</c:forEach>
			</c:forEach>
			</td>
			<!-- 合計価格 -->
			<td>
				<fmt:formatNumber value="${reservationCarList.totalPrice }"/>円<br>
			</td>
			<td>
				<form action="${pageContext.request.contextPath }/reservation/">
					<input type="hidden" name="status" value="${reservationCarList.id }"/>
					<input type="submit" class="btn btn-primary btn-sm" value="予約"/>
				</form>
				<br>
				<form action="${pageContext.request.contextPath }/keep/delete">
					<input type="hidden" name="deleteId" value="${reservationCarList.id }"/>
					<input type="submit" class="btn btn-danger btn-sm" onClick="return check()" value="削除"/>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	</div>
	<script>
		function check() {
			return  confirm('本当に削除しますか？');
		}

	</script>
</body>
</html>