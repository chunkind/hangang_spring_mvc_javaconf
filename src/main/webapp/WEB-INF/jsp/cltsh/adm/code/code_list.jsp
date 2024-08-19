<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="mb-4">공통코드 관리</h2>
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
				<th class="text-center col-1" style="width: 5%;">선택</th>
				<th class="text-center col-1">번호</th>
				<th class="text-center col-6">제목</th>
				<th class="text-center col-2">작성자</th>
				<th class="text-center col-2">등록일</th>
			</tr>
			<c:if test="${empty list }">
				<tr><td colspan="5">데이터가 없습니다.</td></tr>
			</c:if>
			<c:forEach items="${list }" var="obj">
				<tr>
					<td class="text-center"><input type="checkbox" id="cb"></td>
					<td class="text-center">${obj.stdCdBaseSeq}</td>
					<td class="text-center"><a href="/cltsh/adm/code/admCodeEdit.do?stdCdBaseSeq=${obj.stdCdBaseSeq}">${obj.codeNm}</a></td>
					<td class="text-center">${obj.rgstId}</td>
					<td class="text-center">${obj.rgstDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-between align-items-center mt-4">
			<div>${paging}</div>
			<div>
				<!-- <input type="button" value="작성하기" onclick="location.href='/adm/code/admCodeRegister.do'" /> -->
				<a href="/adm/code/admCodeRegister.do" class="btn btn-primary">작성하기</a>
			</div>
		</div>
	</div>
</div>
