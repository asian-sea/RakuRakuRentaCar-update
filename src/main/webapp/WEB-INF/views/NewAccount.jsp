<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://ajaxzip3.github.io/ajaxzip3.js" charset="utf-8"></script>
<title>新規登録</title>
<jsp:include page="header.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
body{
	margin-top:120px;
	margin-bottom:10px;
}
</style>
</head>
<body>
<div class="container">
<form:form modelAttribute="accountForm" action="${pageContext.request.contextPath}/account/accountCreate">
	<div class="form-group row">
		<div class="col-md-6 offset-md-3">
			<div class="text-center">
				<div class="card">
  					<div class="card-header">新規ユーザー登録</div>
  					<div class="card-body">
 					名前<br>
 					<form:input path="name" placeholder="名前"/><br>
 					<small class="text-muted">例）山田太郎</small>
					<br><form:errors path="name" cssStyle="color:red"/>

					<br>
					郵便番号<br>
					<input type="text" name="zip" onKeyUp="AjaxZip3.zip2addr(this,'','address','address');" placeholder="郵便番号"><br>
					<small class="text-muted">※半角数字</small>
					<br>

					<br>
					住所<br>
					<form:input path="address" placeholder=""/>
					<br><form:errors path="address" cssStyle="color:red"/>

					<br>
					電話番号<br>
					<form:input path="telephone" placeholder=""/><br>
					<small class="text-muted">※半角数字（ハイフン不要）</small>
					<br><form:errors path="telephone" cssStyle="color:red"/>

					<br>
					メールアドレス<br>
					<form:input path="email" placeholder="メールアドレス"/><br>
					<small class="text-muted">※半角英数字</small>
					<br><form:errors path="email" cssStyle="color:red"/>

					<br>
					パスワード<br>
					<form:password path="password" placeholder="パスワード"/><br>
					<small class="text-muted">※半角英数字</small>
					<br><form:errors path="password" cssStyle="color:red"/>

					<br>
					確認用パスワード<br>
					<form:password path="checkpassword" placeholder="確認用パスワード"/>
					<br><form:errors path="checkpassword" cssStyle="color:red"/>

	    			<!-- オブジェクトエラー処理  -->
					<form:errors cssStyle="color:red"/><br>

					<br>
					<input class="btn btn-primary" type="submit" value="新規登録"><br>
					<br>
					<a href="/login/loginpage">ログイン画面に戻る</a>
					<div class="mb-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
</div>
</body>
</html>