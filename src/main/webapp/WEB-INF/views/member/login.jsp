<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="login" method="POST">
        <div>
            ID <input type="text" name="id" placeholder="아이디">
            PW <input type="password" name="pw" placeholder="비밀번호"> 
            <input type="submit" value="로그인">
            <div>
                아이디 저장 <input type="checkbox" name="c1" value="아이디 저장">
                로그인 상태 유지<input type="checkbox" name='c1' value="로그인 상태 유지">
            </div>
        </div>
    </form>
    <a href="/">홈 화면</a>
</body>
</html>