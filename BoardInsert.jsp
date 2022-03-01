<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>글 작성 페이지</h1>
  <form action = "Insert" method ="POST" name = "insertBoard">
  	제목:<input name = "sub" type = "text">작성자:<input name = "writer" type = "text"><br>
  	내용:<textarea name = "content" type = "text" cols ="50" rows ="30"></textarea><br>
  	<input name = "subm" type = "submit" value ="저장"><br>
  	<input name = "listmove" href = "Main" type ="submit" value="목록">
  	

  	
  
  </form>
</body>
</html>