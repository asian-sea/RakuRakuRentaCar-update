<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME画面</title>
<jsp:include page="header.jsp" flush="true" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
body{
	margin-top:80px;
	margin-bottom:10px;
	font-family: 'Yu Gothic', sans-serif;
	letter-spacing:-.01em;
}
.jumbotron{
	background:url('../img/home1.jpg') center no-repeat;
    background-size: cover;
    height:500px;
    border-radius:0%;
 }

.pb-10{
	color:white;
}
#search-box{
	margin-left:0;
	margin-top:10px;
	background-color:rgb(255,165,0,0.9);
	color:white;
}
</style>
<!-- <script> -->
<!--  jQuery(function($) { -->
<!--      $('.bg-slider').bgSwitcher({ -->
<!--          images: ['/img/home1.jpg','/img/home2.jpg','/img/home3.jpg'], -->
<!--      }); -->
<!--  }); -->
<!-- </script> -->
</head>
<body>
<div class="jumbotron">
	<div class="container-fluid">
		<div class="pb-10">
			<div style="color:white;">
				<c:if test ="${user == null }">ゲストさん、ようこそ！</c:if>
				<c:if test ="${user!=null }">
					<c:out value="${user.name }"/>さん、ようこそ！
				</c:if>
			</div>
		</div>
		<div id="search-box" class="pl-5 col-sm-4">
			<div class="pt-4 pb-2"><h3>検索</h3></div>
			<form:form modelAttribute="carForm" action="${pageContext.request.contextPath}/car/toCarList2">
				営業所<br><form:select path="shopId" items="${shopList}" itemValue="id" itemLabel="name"/><br>
				<br>
				クラス<br><form:select path="gradeId" items="${gradeList}" itemValue="id" itemLabel="name"/><br>
				<br>
				<input type="submit" value="検索" class="btn btn-primary">
			</form:form>
			<div class="pb-4"></div>
		</div>
	</div>
</div>
<br>
<div class="container">
	<div class="border-bottom h3 pb-2">クラスから選ぶ</div>
	<div class="row">
	<c:forEach var="grade" items="${gradeList}" begin="1">
		<div class="col-6 col-sm-4">
			<div class="text-center">
				<img src="/img/<c:out value="${grade.imagePath }"/>" style="width:200px"/><br>
				<c:out value="${grade.name }" /><br>
				<br>
				<a href="<c:url value='${pageContext.request.contextPath}/car/toCarList1/${grade.id }' />">
				<input type="submit" class="btn btn-warning" value="この車種で予約する"/></a>
				<br>
			</div>
		</div>
	</c:forEach>
	</div>
</div>
</body>
</html>