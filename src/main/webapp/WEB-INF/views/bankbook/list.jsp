<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	//스크립틀릿<% java 코드 작성% >
 	//표현식   <% = 자바 변수 또는 값 % >
 	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
 %>
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
	<%if(ar != null){ %>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<% for(BankBookDTO bankBookDTO:ar){ %>
			 <tr>
			 	<td><a href="./detail?booknum=<%= bankBookDTO.getBooknum()%>"><%= bankBookDTO.getBookname() %></a></td>
			 	<td><%= bankBookDTO.getBookrate() %></td>
			 </tr>
			<% }%>
		</tbody>
	</table>
	
	<%}else { %>
		<h3>data가 없음</h3>
	<%} %>
	
	<a href="./add">상품등록</a>
	
</body>
</html>