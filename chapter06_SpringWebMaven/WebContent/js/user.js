$('#writeBtn').click(function(){
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
		//document.writeForm.submit();
		//$('#writeForm').submit();
		//$('form[name=writeForm]').submit();
		
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/write', 
			data: {'name': $('#name').val(), 
			       'id': $('#id').val(),
			       'pwd': $('#pwd').val()},
			success: function(){
				alert("회원 등록 완료");
			},
			error: function(){
				alert("회원 등록 실패");
			}
		});
});

$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수정보 입력');
		$('#idDiv').css('color', 'magenta');
	}else{
		
	}
});

$('#checkIdBtn').click(function(){
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수정보 입력');
		$('#idDiv').css('color', 'magenta');
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(result){
				if(result == '사용 가능'){
					$('#idDiv').text(result);
					$('#idDiv').css('color', 'blue'); 
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold');
					
				}else if(result == '사용 불가능'){
					$('#idDiv').text(result);
					$('#idDiv').css('color', 'red');
					$('#idDiv').css('font-size','8pt')
					$('#idDiv').css('font-weight','bold');
				}
				
			},error: function(){
				alert("실패");
			}
		});
	}
});







