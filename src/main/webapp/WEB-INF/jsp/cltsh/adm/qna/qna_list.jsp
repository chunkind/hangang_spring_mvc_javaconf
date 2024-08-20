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
				<th class="text-center col-1">선택</th>
				<th class="text-center col-1">번호</th>
				<th class="text-center col-4">제목</th>
				<th class="text-center col-2">작성자</th>
				<th class="text-center col-2">등록일</th>
				<th class="text-center col-2">답변상태</th>
			</tr>
			<c:forEach items="${rvo}" var="obj">
				<tr>
					<td class="text-center col-1"><input type="checkbox" id="cb"></td>
					<td class="text-center col-1">${obj.qnaBoardSeq}</td>
					<td class="text-center col-4">${obj.titNm}</td>
					<td class="text-center col-2">${obj.rgstId }</td>
					<td class="text-center col-2">${obj.rgstDate}</td>
					<td class="text-center col-2"><button class="one_btn"><a href="/cltsh/adm/qna/admQnaAnswer.do?qnaBoardSeq=${obj.qnaBoardSeq}">답변하기</a></button></td>
				</tr>
			</c:forEach>
		</table>
		${paging }
	</div>
</div>
