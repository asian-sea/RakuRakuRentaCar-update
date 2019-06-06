<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://ajaxzip3.github.io/ajaxzip3.js" charset="utf-8"></script>
<title>新規登録</title>
<jsp:include page="header-logout.jsp" flush="true" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form:form modelAttribute="accountForm" action="${pageContext.request.contextPath}/account/accountCreate">
	<div class="border col-12">
	<div class="text-center">

 		名前:<form:input path="name" placeholder="名前" class="mt-4"/>
		<br><form:errors path="name" cssStyle="color:red"/>

		<br>
		郵便番号(ハイフンはあってもなくても大丈夫です):<br>
		<input type="text" name="zip" onKeyUp="AjaxZip3.zip2addr(this,'','address','address');">
		<br>

		<br>
		住所(途中まで自動入力されます):<br>
		<form:input path="address" placeholder="住所"/>
		<br><form:errors path="address" cssStyle="color:red"/>

		<br>
		電話番号:<form:input path="telephone" placeholder="電話番号"/>
		<br><form:errors path="telephone" cssStyle="color:red"/>

		<br>
		メールアドレス:<form:input path="email" placeholder="メールアドレス"/>
		<br><form:errors path="email" cssStyle="color:red"/>

		<br>
		パスワード:<form:password path="password" placeholder="パスワード"/>
		<br><form:errors path="password" cssStyle="color:red"/>

		<br>
		確認用パスワード:<form:password path="checkpassword" placeholder="確認用パスワード"/>
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
</form:form>
</div>
</body>
</html>