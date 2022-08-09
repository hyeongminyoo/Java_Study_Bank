<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% GregorianCalendar ca = new GregorianCalendar(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Add page</h3>
	<form action="add" method="POST">
		
		BookNum <input type="text" name="booknum" value=<%=ca.getTimeInMillis() %>><br>
		BookName <input type="text" name="bookname"><br>
		BookRate <input type="text" name="bookrate"><br>
		BookSale <input type="number" name="booksale" value=1><br>
		<input type="submit" value="입력">
		<input type="reset" value="초기화">	
	</form>
	

</body>
</html>