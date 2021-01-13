<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정할 아이디 입력 : <input type="text" id="searchId">
<input type="button" id="searchBtn" value="검색">
<br><br>
<div id="resultDiv"></div>

<div id="modifyFormDiv" action="">
<form id="modifyForm">
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
		<input type="button" value="회원정보수정" id="modifyBtn">
		<input type="reset" value="다시작성" id="resetBtn">
	</td>
</tr>
</table>
</form>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#modifyFormDiv').hide();
	
	$('#resetBtn').click(function(){
		$('#searchBtn').trigger('click');//강제로 이벤트를 발생
	});
	
	$('#searchBtn').click(function(event){
		$('#resultDiv').empty();
		
		if($('#searchId').val() == ''){
			$('#resultDiv').text('먼저 아이디를 입력하세요');
			$('#resultDiv').css('color', 'red');
			$('#resultDiv').css('font-size', '10pt');
			$('#resultDiv').css('font-weight', 'bold');
		
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/getUser',
				data: {'id': $('#searchId').val()},
				dataType: 'json',
				success: function(data){
					//alert(JSON.stringify(data));
					
					if($.isEmptyObject(data)){
						$('#resultDiv').text('수정할 아이디가 없습니다');
						$('#resultDiv').css('color','red')
						$('#resultDiv').css('font-size','10pt')
						$('#resultDiv').css('font-weight','bold')
					}else{
						$('#modifyFormDiv').show();
						
						$('#name').val(data.name);
						$('#id').val(data.id);
					}
				}	
			});
		}
	});
	
	//회원정보수정 버튼
	$('#modifyBtn').click(function(){
		$('#nameDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()=='')
			$('#nameDiv').text('이름을 입력하세요').css('color', 'red').css('font-size', '8pt').css('font-weight', 'bold');
		
		else if($('#pwd').val()=='')
			$('#pwdDiv').text('비밀번호를 입력하세요').css('color', 'red').css('font-size', '8pt').css('font-weight', 'bold');
		else
			//$('#modifyForm').submit();
		
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/modify',
				data: $('#modifyForm').serialize(),
				success: function(){
					alert('회원정보를 수정하였습니다');
					location.href='/chapter06_SpringWebMaven/index.jsp';
				}
			});
	});
});
</script>
</body>
</html>



















