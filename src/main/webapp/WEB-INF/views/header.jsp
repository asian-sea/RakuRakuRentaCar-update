<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="stylesheet" href="sample.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c&display=swap" rel="stylesheet">
	<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<style>
/* * { */
/* 	margin:0; padding:0; */
/* } */
header{
	margin:0; padding:0;
	width:100%;
	top: 0;
	left: 0;
	background-color:orange;
	height:50px;
	color:white;
	font-family: 'M PLUS Rounded 1c', sans-serif;
}
.logo{
	position:absolute;
	line-height:50px;
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
	line-height:50px;
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

</style>

<header>
	<div class="logo">
		<p><a href="../car/">らくらくレンタカー</a></p>
	</div>

	<ul class="menu">
		<li><a href="../keep/show">キープ</a></li>
		<li><a href="../history/">注文履歴</a></li>
		<li><a href="../login/loginpage">ログアウト</a></li>
	</ul>
</header>

</body>
</html>