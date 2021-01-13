<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.memId == null }">
	<a href="../member/writeForm">회원가입</a><br>
	<a href="/spring/member/loginForm">로그인</a><br>
</c:if>

<c:if test="${memId != null }">
	<h3>${memName }님 로그인</h3>
	
	<a href="/spring/member/logout">로그아웃</a><br>
	<a href="../member/modifyForm">회원정보수정</a><br>
	<a href="../board/boardWriteForm">글쓰기</a><br>
	<a href="../imageboard/imageboardWriteForm">상품등록</a><br>
</c:if>

<a href="../board/boardList?pg=1">목록</a><br>
<a href="../imageboard/imageboardList?pg=1">상품목록</a><br>






























