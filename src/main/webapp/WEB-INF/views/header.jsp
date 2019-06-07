<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="stylesheet" href="sample.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c&display=swap" rel="stylesheet">
	<style>
		/* * { */
		/* 	margin:0; padding:0; */
		/* } */
		header{
			z-index: 9999;
			position: fixed;
			margin:0; padding:0;
			width:100%;
			top: 0;
			left: 0;
			background-color:orange;
			height:80px;
			color:white;
			font-family: 'M PLUS Rounded 1c', sans-serif;
		}
		.logo{
			position:absolute;
			line-height:80px;
			font-size:30px;
			padding-left:20px;
		}
		.logo a{
			text-decoration: none;
			color:white;
			display: inline-block;
		}
		ul{
			text-align:right;
			line-height:80px;
			color:white;
		}
		li{
			display: inline-block;
			margin-right: 25px;
		}
		li a{
			text-decoration: none;
			color:white;
			display: inline-block;
		}
		a, a:visited, a:focus, a:hover {
			text-decoration: none;
		}

</style>
</head>
<body>

<header>
	<div class="logo">
		<p><a href="${pageContext.request.contextPath}/car/" class="btn btn-lg">らくらくレンタカー</a></p>
	</div>

	<c:if test="${user == null}" var="check"/>
		<c:if test="${check}">
			<ul class="menu">
				<li><a href="${pageContext.request.contextPath}/login/loginpage" class="btn btn">ログイン</a></li>
			</ul>
		</c:if>
		<c:if test="${!check}">
			<ul class="menu">
				<li><a href="${pageContext.request.contextPath}/keep/show" class="btn btn">キープ</a></li>
				<li><a href="${pageContext.request.contextPath}/history/" class="btn btn">予約履歴</a></li>
				<li><a href="${pageContext.request.contextPath}/logout/logoutAccount" class="btn btn">ログアウト</a></li>
			</ul>
		</c:if>

</header>
</body>
</html>