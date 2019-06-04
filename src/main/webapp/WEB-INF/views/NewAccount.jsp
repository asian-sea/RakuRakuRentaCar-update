<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>

</head>
<body>
<form:errors path="accoutnForm.*"/><br><!-- メールアドレス2重登録、パスワードの不一致のエラー文でない -->
<form:form modelAttribute="accountForm" action="${pageContext.request.contextPath}/account/accountCreate">
 		<label for="inputName">名前:</label>
		<form:input path="name" placeholder="名前"/>
		<br><form:errors path="name" cssStyle="color:red"/>
		
		<br>
		<label for="inputAddress">住所:</label>
		<form:input path="address" placeholder="住所"/>
		<br><form:errors path="address" cssStyle="color:red"/>								
		
		<br>
		<label for="inputTelephone">電話番号:</label>
		<form:input path="telephone" placeholder="電話番号"/>
		<br><form:errors path="telephone" cssStyle="color:red"/>
		
		<br>					
		<label for="inputEmail">メールアドレス:</label>
		<form:input path="email" placeholder="メールアドレス"/>
		<br><form:errors path="email" cssStyle="color:red"/>								
		
		<br>
		<label for="inputPassword">パスワード:</label>
		<form:password path="password" placeholder="パスワード"/>
		<br><form:errors path="password" cssStyle="color:red"/>	
		
		<br>
		<label for="inputCheckPassword">確認用パスワード:</label>
		<form:password path="checkpassword" placeholder="確認用パスワード"/>
		<br><form:errors path="checkpassword" cssStyle="color:red"/>								
	
		<br>
		<input class="btn btn-primary" type="submit" value="新規登録">
		<a href="/login/loginpage">ログイン画面に戻る</a>

</form:form>
</body>
</html>