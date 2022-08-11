<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>BankBookUpdate Page</h3>
	<form action="update" method = "POST">
	<div>
		<input type="hidden" name = "booknum" readonly value="${update.booknum}">
	</div>
	<div>
		Name : <input type="text" name="bookname" value="${update.bookname}" >
	</div>
	<div>
		Rate : <input type="text" name="bookrate" value="${update.bookrate}">
	</div>
	<div>
		<input type="hidden" name="booksale" readonly value="${update.booksale}" >
	</div>
		<button type="submit">수정</button>
		<input type="submit" value="수정">
	</form>
	
</body>
</html>