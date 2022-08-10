<%@page import="com.iu.start.bankMembers.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Member Search Result</h3>
	<%if(!ar.isEmpty()) {%>
	<table border="1">
		<thead>
			<tr>
				<th>UserName</th><th>Name</th><th>Email</th><th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<%for(BankMembersDTO bankMembersDTO : ar) {%>
			<tr>
				<td><%=bankMembersDTO.getUsername() %></td>
				<td><%=bankMembersDTO.getName() %></td>
				<td><%=bankMembersDTO.getEmail() %></td>
				<td><%=bankMembersDTO.getPhone() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<%}else {%>
		<h3>데이터 없음</h3>
	<%} %>

</body>
</html>