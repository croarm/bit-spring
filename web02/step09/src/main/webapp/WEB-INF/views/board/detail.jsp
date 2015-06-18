<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세정보</h1>
<form action='change.do' method='post'>
<table border='1'>
<tr>
  <th>번호</th><td><input name='no' type='text' readonly value='${board.no}'></td>
</tr>
<tr>
  <th>제목</th><td><input name='title' type='text' value='${board.title}'></td>
</tr>
<tr>
  <th>내용</th><td><textarea name='content' rows='5' cols='50'>${board.content}</textarea></td>
</tr>
<tr>
  <th>등록일</th><td><input type='text' readonly value='${board.createDate}'></td>
</tr>
<tr>
  <th>조회수</th><td><input type='text' readonly value='${board.views}'></td>
</tr>
</table>
<button type='submit'>변경</button>
<button type='button'  onclick='location.href="remove.do?no=${board.no}";'>삭제</button>
</form>
</body>
</html>







    