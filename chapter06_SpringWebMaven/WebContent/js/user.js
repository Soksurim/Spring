// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}



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
			url: '/chapter06_SpringWebMaven/user/write', //상대, 절대경로 둘다 가능 & "" '' 둘다 가능
			//보낼 데이터 
			// JSON 표기법
			data: {'name': $('#name').val(), 
			       'id': $('#id').val(),
			       'pwd': $('#pwd').val()},
			//성공했을 때 돌아오는 거
			success: function(){
				alert("회원등록 성공");
			},
			//실패했을 때 
			error: function(){
				alert("회원등록 실패");
			}
				
		});
});

//${abc} - function(abc를 jquery 객체로 리턴)

$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수정보 입력');
		$('#idDiv').css('color', 'magenta');
	}else {
		
	}
});


//	버튼으로 중복체크
$('#checkIdBtn').click(function() {
	$('#idDiv').empty();
	
	if($('#id').val()==''){
		$('#idDiv').text('필수정보 입력');
		$('#idDiv').css('color', 'magenta');
	}else{
			$.ajax({
				type: 'get', 
				url: '/chapter06_SpringWebMaven/user/checkId',
				// 주소로 넘기는 방식
				data: 'id=' + $('#id').val(),
				 // 리턴되는 데이터 타입
				dataType: 'text',
				// 리턴되는 데이터는 success의 function 파라미터로 들어간다.
				// 파라미터 명은 아무거나 상관없다.
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
					
				},error: function(){ alert("실패"); }
			})}
	
});

