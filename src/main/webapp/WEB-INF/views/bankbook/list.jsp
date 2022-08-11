<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- 인덱스페이지에 /bankbook/list -->
		
	<!--  /bankbook/detail  jsp: detail.jsp -->
	<!--  link 주소는 상대경로로 작성 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
			 <tr>
			 	<td><a href="./detail?booknum=${pageScope.dto.booknum}">${pageScope.dto.bookname}</a></td>
			 	<td>${pageScope.dto.bookrate}</td>
			 </tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	
	<a href="./add">상품등록</a>
	
</body>
</html>