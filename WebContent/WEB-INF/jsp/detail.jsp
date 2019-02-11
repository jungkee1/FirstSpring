<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form name="frm" action="member_update.do">
<h1>상세보기</h1>
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>주소</td>
		<td>메모</td>
		<td>가입날짜</td>
	</tr>
	<tr>
		<input type="hidden" value="${user.id}" name="id">
		<td><input type="text" value="${user.id}" disabled="disabled"></td>
		<td><input type="text" value="${user.pass }" name="pass"></td>
		<td><input type="text" value="${user.name}" name="name"></td>
		<td><input type="text" value="${user.addr }" name="addr"></td>
		<td><textarea name="memo">${user.memo }</textarea></td>
		<td>${user.reg_date }</td>
	</tr>
</table>
<input type="submit" value="수정하기">
</form>
</div>
</body>
</html>