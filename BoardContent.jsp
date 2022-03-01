<%@page import="java.util.Date"%>
<%@page import="com.tistory.mabb.freeboard.dao.BoardDao"%>
<%@page import="com.tistory.mabb.freeboard.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 상세보기</h1>
<hr>

<%

BoardVo vo = (BoardVo)request.getAttribute("vo");
int num = vo.getNum();
String sub = vo.getSub();
String content = vo.getContent();
String writer = vo.getWriter();
Date writetime = vo.getWritetime();

%>

<table>
<thead>
<tr>
<th>글번호</th><th><%= num %></th><th>작성자</th><th><%=writer %></th><th>작성시간</th><th><%=writetime %></th>
</tr>
<tr>
<th>제목</th><th><%=sub %></th>
</tr>


</thead>
<tbody>

<tr>
<td><%=content %></td>
</tr>
</tbody>

</table>

<form action = "Main">
<input type="submit" value ="목록">
</form>


</body>
</html>