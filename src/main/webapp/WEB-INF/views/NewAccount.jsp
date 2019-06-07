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
<div class="row">
	<div class="col-md-8 offset-md-2">
		<div class="card">
  			<div class="card-header">新規ユーザー登録</div>
  			<div class="card-body">
				<div class="form-group">
 					<label for="Input1">名前</label>
 					<form:input path="name" class="form-control" id="Input1" placeholder="名前"/>
 					<small class="text-muted">例）山田太郎</small>
					<br><form:errors path="name" cssStyle="color:red"/>

					<br>
					<label for="Inpu2t">郵便番号</label>
					<input type="text" name="zip" class="form-control" id="Input2" onKeyUp="AjaxZip3.zip2addr(this,'','address','address');" placeholder="郵便番号">
					<small class="text-muted">※半角数字</small>
					<br>

					<br>
					<label for="Input3">住所</label>
					<form:input path="address" class="form-control" id="Input3" placeholder="住所"/>
					<br><form:errors path="address" cssStyle="color:red"/>

					<br>
					<label for="Input4">電話番号</label>
					<form:input path="telephone" class="form-control" id="Input4" placeholder="電話番号"/>
					<small class="text-muted">※半角数字（ハイフン不要）</small>
					<br><form:errors path="telephone" cssStyle="color:red"/>

					<br>
					<label for="Input5">メールアドレス</label>
					<form:input path="email" class="form-control" id="Input5" placeholder="メールアドレス"/>
					<small class="text-muted">※半角英数字</small>
					<br><form:errors path="email" cssStyle="color:red"/>

					<br>
					<label for="Input6">パスワード</label>
					<form:password path="password" class="form-control" id="Input6" placeholder="パスワード"/>
					<small class="text-muted">※半角英数字</small>
					<br><form:errors path="password" cssStyle="color:red"/>

					<br>
					<label for="Input7">確認用パスワード</label>
					<form:password path="checkpassword" class="form-control" id="Input7" placeholder="確認用パスワード"/>
					<br><form:errors path="checkpassword" cssStyle="color:red"/>

	    			<!-- オブジェクトエラー処理  -->
					<form:errors cssStyle="color:red"/><br>

					<div class="text-center">
					<input class="btn btn-primary" type="submit" value="新規登録"><br>
					<br>
					<a href="/login/loginpage">ログイン画面に戻る</a>
					</div>
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