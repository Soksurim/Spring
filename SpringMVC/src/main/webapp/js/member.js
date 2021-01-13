//로그인
$('#loginBtn').click(function(){
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	
	if($('#loginId').val()==''){
		$('#loginIdDiv').text('아이디를 입력')
						.css('color','red')
						.css('font-size','8pt')
						.css('font-weight','bold');
		
	}else if($('#loginPwd').val()==''){
		$('#loginPwdDiv').text('비밀번호를 입력')
						 .css('color','red')
						 .css('font-size','8pt')
						 .css('font-weight','bold');
	}else{
		$.ajax({
			type : 'post',
			url: '/spring/member/login',
			data: {'id': $('#loginId').val(), 'pwd': $('#loginPwd').val()},
			dataType: 'text',
			success: function(data){
				if(data == 'success'){
					location.href = '/spring/index.jsp';
					
				}else if(data == 'fail'){
					alert('로그인 실패');
				}
			},
			error: function(err){
				console.log(err);
			}
			
		});
	}
});







