<%@page import="net.bitacademy.spring.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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

<c:forEach items="${list}" var="board">
<tr>
  <td>${board.no}</td>
  <td><a href='detail.do?no=${board.no}'>${board.title}</a></td>
  <td>${board.createDate}</td>
  <td>${board.views}</td>
</tr>
</c:forEach>

</table>
</body>
</html>
    
    
    
    