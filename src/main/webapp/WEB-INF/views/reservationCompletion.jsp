<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div class="text-center">
	<div class="h3"><i class="fas fa-check-circle"></i>決済が完了しました！</div>
	<br>
<%-- 	<div class="h4">予約番号：<c:out value="${reservationCar.reservationId }"/></div> --%>
<!-- 	<br> -->
	<p>
		この度はご注文ありがとうございます。<br>
		ご登録されたEメールアドレスに確認メールを送信しました。<br>
		メールが届かない場合は「注文履歴」からご確認ください。<br>
	</p>
	<br>
	<a href="${pageContext.request.contextPath }/car/" class="btn btn">トップ画面へ戻る</a>
	</div>
</div>
</body>
</html>