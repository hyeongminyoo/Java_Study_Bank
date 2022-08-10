<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	메인  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./member/login">로그인</a>
<a href="./member/join">가입</a>
<a href="./bankbook/list">상품리스트</a>
<a href="./member/search">회원검색</a>

</body>
</html>
