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
	line-height:50px;
	size:30px;
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
		<p><a href="../car/">楽々レンタカー</a></p>
	</div>

	<ul class="menu">
		<li><a href="../keep/show">Keep</a></li>
		<li><a href="../login/loginpage">ログアウト</a></li>
	</ul>
</header>

</body>
</html>