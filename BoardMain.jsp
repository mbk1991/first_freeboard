<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.tistory.mabb.freeboard.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영차영차게시판jsp</h1>
<hr>

<table>
<thead>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th></tr>
</thead>

<%
 	List<BoardVo> list = (List) request.getAttribute("list");
	for(BoardVo vo:list){
		int num = vo.getNum();
		String sub = vo.getSub();
		String writer = vo.getWriter();
		Date writetime = vo.getWritetime();
%>
<tbody>	
 <tr><td><%=num%></td><td><a href = "Content?num_c=<%=num%>"><%=sub%></a></td><td><%=writer%></td><td><%=writetime%></td></tr>
</tbody>
<%
	}
%>
 </table>
 
<form action = "Insert" >
	<input name="insertbutt" type = "submit" value = "작성">
</form>

</body>
</html>