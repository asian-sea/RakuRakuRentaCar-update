<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="stylesheet" href="sample.css" type="text/css">
</head>
<body>

<style>
* {
	margin:0; padding:0;
}
header{
	background-color:orange;
	height:50px;
	color:white;
}
.logo{
	position:absolute;
}
ul{
	text-align:right;
}
li{
	display: inline-block;
    margin-right: 25px;
}

</style>

<header>
	<div class="logo">
		<h1>楽々レンタカー</h1>
	</div>

	<ul class="menu">
		<li><a href="keep.jsp">Keep</a></li>
		<li><a href="home.jsp">ログアウト</a></li>
	</ul>
</header>

</body>
</html>