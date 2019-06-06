<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
</style>
</head>
<body>
<div class="container" id="wapper">
	<div class="m-5"></div>
	<div class="text-center">
	<div class="h3"><i class="fas fa-check-circle"></i>会員登録が完了しました！</div>
	<br>
	<p>
		会員登録ありがとうございます。<br>
		下記リンクよりログインの程、よろしくお願いいたします。<br>
		<br>
		<br><a href="/login/loginpage" class="btn btn">ログイン画面へ</a>
	</p>
</div>
</div>
</body>
</html>