<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- <div id="display"></div> -->

<table id="table" border="1" cellpadding="3" cellspacing="0">
<tr>
	<th width="100">이름</th>
	<th width="100">아이디</th>
	<th width="100">비밀번호</th>
</tr>
</table>
<br><br>
<div class="search">
	<select name="searchOption" id="searchOption">
		<option value="">선택
		<option value="name">이름
		<option value="id">아이디
	</select> 
	<input type="text" id="searchText" name="searchText">
	<button id="searchBtn">검색</button>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#searchBtn').click(function(){
		if($('#searchOption').val()==''){
			alert('검색 옵션을 선택하세요');
			return false;
		
		}else{
			$('#table tr:gt(0)').remove();
			
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/search',
			
				//data: 'searchOption='+$('#searchOption').val()+"&searchText="+$('#searchText').val(),
				//-----------------------------
				
				contentType: 'application/json;charset=UTF-8',
				data: JSON.stringify({'searchOption': $('#searchOption').val(), 'searchText': $('#searchText').val()}),			
				/*
				JSON의 형식 그대로 문자열로 바꾸어서
				'{"searchOption": $("#searchOption").val(),"searchText": $("#searchText").val()}' 
				*/					  
									  
				dataType: 'json',
				success: function(data){
					//alert(JSON.stringify(data));
					
					$.each(data.list, function(index, items){
						$('<tr/>').append($('<td/>',{
							align: 'center',
							text: items.name
						})).append($('<td/>',{
							align: 'center',
							text: items.id
						})).append($('<td/>',{
							align: 'center',
							text: items.pwd
						})).appendTo('#table');
					});
				}
			});
		}
	});
	
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			/* var table = '<table border=1>';
			table += '<tr>';
			table += '<th width="100">이름</th>';
			table += '<th width="100">아이디</th>';
			table += '<th width="100">비밀번호</th>';
			table += '</tr>';
			
			$.each(data.list, function(index, items){
				table += '<tr>';
				table += '<td align=center>'+items.name+'</td>';
				table += '<td align=center>'+items.id+'</td>';
				table += '<td align=center>'+items.pwd+'</td>';
				table += '</tr>';
			});
			table += '</table>';
			$('#display').append(table); */
			
			//--------------------------
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo('#table');
			});
		},
		error: function(err){
			console.log(err);
		}
		
	});
});
</script>
</body>
</html>
















