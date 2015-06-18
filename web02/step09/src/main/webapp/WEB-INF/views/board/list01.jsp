<%@page import="net.bitacademy.spring.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<Board> boards = (ArrayList<Board>) request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>게시물 목록</h1>
<a href='form.html'>새 글</a><br>
<table border='1'>
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>등록일</th>
  <th>조회수</th>
</tr>

<%for (Board board : boards) {%>
<tr>
  <td><%=board.getNo()%></td>
  <td><a href='detail.do?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
  <td><%=board.getCreateDate()%></td>
  <td><%=board.getViews()%></td>
</tr>
<%}%>

</table>
</body>
</html>
    
    
    
    