<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>1:1 문의 관리</h2>
	<div class="src_area">
		<div>
			<select>
				<option>등록일순</option>
				<option>이름순</option>
			</select>
		</div>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<tr>
				<th>전체선택</th>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>답변상태</th>
			</tr>
			<c:forEach items="${rvo}" var="obj">
				<tr>
					<td><input type="checkbox" id="cb"></td>
					<td>${obj.qnaBoardSeq}</td>
					<td>${obj.titNm}</td>
					<td>${obj.rgstId }</td>
					<td>${obj.rgstDate}</td>
					<td><button class="one_btn"><a href="/cltsh/adm/qna/admQnaAnswer.do?qnaBoardSeq=${obj.qnaBoardSeq}">답변하기</a></button></td>
				</tr>
			</c:forEach>
		</table>
		${paging }
	</div>
</div>
