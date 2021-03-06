<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="../css/board.css">

<input type="hidden" id="pg" value="${pg }">

<table id="boardListTable" border="1" cellpadding="3" cellspacing="0" frame="hsides" rules="rows">
<tr>
	<th width="180">글번호</th> <!-- 테이블 헤더 / 가운데, 굵게 -->
	<th width="500">제목</th>
	<th width="180">작성자</th>
	<th width="100">조회수</th>
	<th width="180">작성일</th>
</tr>
</table>

<div id="boardPagingDiv" class="paging" align="center"></div>

<br><br>
<form name="boardListSearchForm" method="post" action="boardSearch.do">
<input type="hidden" name="pg" value="1">

<div style="text-align: center;">
	<select name="searchType" style="width: 100px;">
		<option value="subject" selected>제목</option>
		<option value="id">아이디</option>
	</select>
	
	<input type="search" name="keyword" id="keyword">
	<input type="submit" value="검 색">
</div>
</form>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>
<script type="text/javascript">
function boardPaging(pg){
	location.href = 'boardList?pg='+pg;
}
</script>















