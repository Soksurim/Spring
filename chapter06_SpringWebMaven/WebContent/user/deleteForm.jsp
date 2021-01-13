<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
삭제할 아이디 입력 : <input type="text" id="searchId">
<input type="button" id="searchBtn" value="검색">
<br><br>
<div id="resultDiv"></div>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#searchBtn').click(function(){
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
					
					if(JSON.stringify(data) == "{}"){
						$('#resultDiv').text('삭제할 아이디가 없습니다');
						$('#resultDiv').css('color','red')
						$('#resultDiv').css('font-size','10pt')
						$('#resultDiv').css('font-weight','bold')
					}else{
						if(confirm("정말로 삭제하시겠습니까?")){
							$.ajax({
								type: 'post',
								url: '/chapter06_SpringWebMaven/user/delete',
								data: {'id': $('#searchId').val()},
								success: function(){
									alert("회원정보 삭제 완료");
									location.href='/chapter06_SpringWebMaven/index.jsp';
								}
							});
						}
					}
				},
				error: function(err){
					colsole.log(err);
				}
			});
		}
		
	});
});
</script>
</body>
</html>













