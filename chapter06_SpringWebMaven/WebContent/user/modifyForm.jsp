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
  width: 15%;
  height: 10%;
}

</style>
</head>
<body>
<form id="modifyForm" name="modifyForm" >
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
		<input type="text" name="id" id="id" readonly>
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
		<input type="button" value="회원정보 수정" id="modifyBtn">
		<input type="button" value="돌아가기" id="resetBtn">
	</td>
</tr>
</table>
</form>

<!-- The Modal -->
<div id="myModal" class="modal" >

  <!-- Modal content -->
  <div class="modal-content">
    <input type="input" id="inputId" placeholder="input ID">
    <input type="button" id="okBtn" value="입력">
    <div id="resultDiv">수정하려는 아이디를 입력하세요.</div>
  </div>

</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" >

	$('#resetBtn').click(function(){
		$('#okBtn').trigger('click');
	})

	$(document).ready(function(){
		$('#modifyForm').hide();
		$('#myModal').css('display', 'block');
		$('#okBtn').click(function() {
			
			if($('#inputId').val()==''){
				$('#resultDiv').text('아이디 입력하시오');
				$('#resultDiv').css('color', 'red');
			}else{
				
		 			$.ajax({
						type: 'post', 
						url: '/chapter06_SpringWebMaven/user/getUser',
						data: {'id' : $('#inputId').val()},
						dataType: 'json',
						success: function(mymind){
							//alert(JSON.stringify(mymind));
							if($.isEmptyObject(mymind)){
								$('#resultDiv')
								.text($('#inputId').val() + "는 등록된 아이디가 아닙니다.")
								.css('color', 'blue')
								.css('font-size','8pt')
								.css('font-weight','bold');
								
							}else{
								$('#modifyForm').show();
								
								$('#id').val(mymind.id)
								.css('background-color','lightgrey')
								.css('border-color','lightgrey');
								
								$('#name').val(mymind.name);
								$('#pwd').val(mymind.pwd);
								$('#myModal').css('display', 'none');
							}
							
						},error: function(){ alert("실패"); }
					}) 
					
			}
			
		});
	});
	
	
	$('#modifyBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()=='')
			$('#nameDiv').text('이름을 입력하세요');
		else if($('#id').val()=='')
			$('#idDiv').text('아이디를 입력하세요');
		else if($('#pwd').val()=='')
			$('#pwdDiv').text('비밀번호를 입력하세요');
		else
			
			$.ajax({
				type: 'post', 
				url: '/chapter06_SpringWebMaven/user/modify', 
				
				// serialize
				data: $('#modifyForm').serialize(),
				//성공했을 때 돌아오는 거
				success: function(){
					alert("회원수정 성공");
				},
				//실패했을 때 
				error: function(){
					alert("회원수정 실패");
				}
					
			});
	});
		

</script>
</body>
</html>












