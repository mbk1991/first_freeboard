<h1># first_freeboard_ver_2022_03_02</h1>
<hr>
<h4>
퇴근 후에 주먹구구로 만들어보았던 서블릿과 JSP를 이용한 게시판입니다.<br>
</h4>

eclipse, maven_project<br>
java1.7<br>
Dynamic Web Module 2.3<br>
mysql 8.0.28<br>
tomcat8.5<br>
<hr>
BoardVo.java- 게시글번호, 제목, 내용, 작성자, 작성시간<br>
BoardDao.java- 게시판메인, 게시글등록, 내용조회 메서드<br>

MainServlet.java- /Main, 테이블로 각 row의 제목 column에 /Content 링크 , 작성버튼에 /Insert 링크<br><br>
InsertServlet.java-/Insert, 제목, 작성자, 내용 입력 form, 저장 및 목록 버튼<br>
ContentServlet.java-/Content, 내용 조회, 목록 버튼<br>

BoardMain.jsp- 메인view<br>
BoardInsert.jsp- 게시글등록 view<br>
BoardContent.jsp- 내용조회 view<br>
<hr>
