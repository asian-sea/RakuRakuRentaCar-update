<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>車種一覧</title>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>
<div class="container">
<h3>車種一覧</h3>
	<div class="row">
		<div class="col-sm-6">
			<table class="table table-striped">
				<c:forEach var="car" items="${carList}">
					<tr>
						<th>
							<a href="<c:url value='${pageContext.request.contextPath}/car/detail/${car.id }' />">
							<img src="/img/<c:out value='${car.imagePath }' />" style="width:200px">
							<br>
							<a href="<c:url value='${pageContext.request.contextPath}/car/detail/${car.id }' />">
							<c:out value="${car.name }" /></a>
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>