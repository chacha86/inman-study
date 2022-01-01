<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list 페이지</h1>
<form action="http://localhost:9000/articles" method="POST">
	<input type="submit" value="POST 전송" />
</form>
<form action="http://localhost:9000/articles" method="GET">
	<input type="submit" value="GET 전송" />
</form>
<form action="http://localhost:9000/articles/1" method="GET">
	<input type="submit" value="1번 게시물 가져오기" />
</form>


</body>
</html>