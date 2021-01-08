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

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 50%;
  height: 10%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

</style>
</head>
<body>
<form id="writeForm" name="writeForm" >
	<!-- ajax를 이용하므로
	method="post" action="/chapter06_SpringWebMaven/user/write" 
	는 빠진다-->
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
		<input type="text" name="id" id="id"><input type="button" id="checkIdBtn" value="중복체크">
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
<input type="button" id="myBtn" value="모달버튼">

<!-- The Modal -->
<div id="myModal" class="modal" >

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>아이디를 입력하세요.</p>
  </div>

</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>
</body>
</html>












