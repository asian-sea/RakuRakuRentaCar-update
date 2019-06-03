<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キープ内容</title>
</head>
<body>

<h3 class="text-center">キープ内容確認</h3>
	<table>
		<tr>
			<th>
				車種
			</th>
			<th>
				グレード｜価格
			</th>
			<th>
				レンタル期間｜価格
			</th>
			<th>
				オプション｜価格
			</th>
			<th>
				合計
			</th>
			<th>
				予約/削除
			</th>
		</tr>
		<tr>
			<td>
				<img src="src/main/webapp/img/1.jpg"><br>
				<c:out value="車種名"/><br>
			</td>
			<td>
				<c:out value="グレード名"/><br>
				<c:out value="グレード価格"/><br>
			</td>
			<td>
				<c:out value="レンタル開始日時"/><br>
				〜<br>
				<c:out value="レンタル終了日時"/><br>
			</td>
			<td>
				<c:out value="オプション"/><br>
				<c:out value="オプション価格"/>
			</td>
			<td>
				<form action="${pageContext.request.contextPath }/reservation">
					<input type="hidden" name="reservationId" value="${reservationCar.id }"/>
					<input type="submit" value="予約"/>
				</form>
				<form action="${pageContext.request.contextPath }/deleteKeep">
					<input type="hidden" name="reservationId" value="${reservationCar.id }"/>
					<input type="submit" value="削除"/>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>