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
	<c:if test="${empty reservationCarList }"><div  class="text-center border rouded">キープしている内容はありません</div></c:if>
	<c:if test="${!empty reservationCarList }">
		<c:forEach var="reservationCarList" items="${reservationCarList }" varStatus="status">
			<table class="table table-striped border-right border-left border-bottom">
				<tr>
					<td colspan="3">
						キープ日：<c:out value="${reservationCarList.reservationDateStr }"/><br>
					</td>
				</tr>
				<tr>
					<td rowspan="3" class="text-center">
						<img src="${pageContext.request.contextPath }/img/<c:out value="${reservationCarList.imagePath }"/>" style="width:200px"><br>
						<c:out value="${reservationCarList.carName }"/>
					</td>
					<td>レンタル期間</td>
					<td>
						開始日時：<c:out value="${reservationCarList.startDateStr }"/><br>
						返却日時：<c:out value="${reservationCarList.endDateStr }"/><br>
					</td>
				</tr>
				<!-- オプション -->
				<tr>
					<td>オプション</td>
					<td>
						<c:forEach var="optionList" items="${optionManyList}" begin="${status.index}" end="${status.index}">
							<c:forEach var="option" items="${optionList}">
								<span class="badge badge-light p-2"><c:out value="${option.name} "/></span>
							</c:forEach>
						</c:forEach>
					</td>
				</tr>
					<!-- 合計価格 -->
				<tr>
					<td>合計金額</td>
					<td>
						<fmt:formatNumber value="${reservationCarList.totalPrice }"/>円<br>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div class="form-inline"><form action="${pageContext.request.contextPath }/reservation/">
							<input type="hidden" name="status" value="${reservationCarList.id }"/>
							<input type="submit" class="btn btn-primary btn-sm" value="予約"/>
						</form>
						<form action="${pageContext.request.contextPath }/keep/delete">
							<input type="hidden" name="deleteId" value="${reservationCarList.id }"/>
							　<input type="submit" class="btn btn-danger btn-sm" onClick="return check()" value="削除"/>
								<script>
									function check() {
									return  confirm('本当に削除しますか？');
									}
								</script>
						</form></div>
					</td>
				</tr>
			</table>
			<br>
		</c:forEach>
		</c:if>
	</div>
</body>
</html>