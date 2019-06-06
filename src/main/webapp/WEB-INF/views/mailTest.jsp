<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user" action="${pageContext.request.contextPath}/mail/send">

<br><input class="btn btn-primary" type="submit" value="予約確定">

</form:form>
</body>
</html>