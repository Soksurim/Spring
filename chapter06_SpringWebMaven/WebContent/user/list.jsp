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
	<table id="table" border="1" cellpadding="3" cellspacing="0">
		<tr>
			<th width="100">이름</th>
			<th width="100">아이디</th>
			<th width="100">비밀번호</th>
		</tr>
		<div id="display"></div>

		<%-- 
<c:if test="${list != null }">
	<c:forEach var="userDTO" items="${list }">
		<tr>
			<td align="center">${userDTO.name }</td>
			<td align="center">${userDTO.id }</td>
			<td align="center">${userDTO.pwd }</td>
		</tr>
	</c:forEach>
</c:if>
 --%>

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

	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script type="text/javascript">
  
  	// window.onload=function(){} 아래와 같은 코드
  	$(document).ready(function(){
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUserList',
			dataType: 'json',
			success: function(data){
				/* alert(JSON.stringify(data)); */
				
				/* 	######### 방법 1 #############
				var table = '<table border="1" cellpadding="3" cellspacing="0">';
					table += '<tr>';
					table += '<th width="100">이름</th>';
					table += '<th width="100">아이디</th>';
					table += '<th width="100">비밀번호</th>';
					table += '</tr>';
				$.each(data.list, function(index, items){
					table += '<tr>';
					table += '<td align="center">' + items.name + '</td>';
					table += '<td align="center">' + items.id+ '</td>';
					table += '<td align="center">' + items.pwd+ '</td>';
					
				});
				
				$('#display').append(table);
				*/
				
				$.each(data.list, function(index, items){
					
					$('<tr/>').append($('<td/>', { align : 'center', text: items.name }))
							.append($('<td/>', { align : 'center', text: items.id }))
							.append($('<td/>', { align : 'center', text: items.pwd }))
							.appendTo('#table');
					
				});
				 
			},
			error: function(err){
				console.log(err);
			}
			
		})  		
  	})
  
  </script>

</body>
</html>
















