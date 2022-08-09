<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="join" method="POST">
	    <div>
		    ID <input type = "text" name ="username" placeholder = "ID입력"><br>
		    PW <input type ="password" name ="password" placeholder = "PW입력"><br>
		    NAME <input type="text" name="name"  placeholder ="이름입력"><br>
		    EMAIL <input type="text" name="email"   placeholder ="E-mail 입력">
		    <select name="email2">
			    <option value="@naver.com">@naver.com</option>
			    <option value="@google.com">@google.com</option>
		    </select>
		    <br>
		    TEL <input type="tel" name="phone" placeholder ="전화번호 입력"><br>
	    </div>
	    <div>
	        <input type = "submit" value = "회원가입">
	        <input type="reset">
	    </div>
    </form>
    <a href="/">홈 화면</a>
</body>
</html>