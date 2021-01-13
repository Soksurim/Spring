<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="writeForm" name="writeForm">
<table border="1" cellpadding="3" cellspacing="0">
<tr>
	<td width="100">이름</td>
	<td>
		<input type="text" name="name" id="name">
		<div id="nameDiv"></div>
	</td>
</tr>

<tr>
	<td width="100">아이디</td>
	<td>
		<input type="text" name="id" id="id"> <input type="button" id="checkIdBtn" value="중복체크">
		<div id="idDiv"></div>
	</td>
</tr>

<tr>
	<td width="100">비밀번호</td>
	<td>
		<input type="password" name="pwd" id="pwd">
		<div id="pwdDiv"></div>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="button" value="회원가입" id="writeBtn">
		<input type="reset" value="다시작성">
	</td>
</tr>
</table>
</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>
</body>
</html>












