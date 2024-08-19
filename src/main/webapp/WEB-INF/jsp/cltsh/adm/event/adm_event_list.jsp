<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>이벤트 배너 목록</h2>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th class="text-center">선택</th>
					<th class="text-center">이벤트 코드</th>
					<th class="text-center">이벤트 이름</th>
					<th class="text-center">이벤트 등록 날짜</th>
					<th class="text-center">이벤트 만료 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr><td colspan="4">데이터가 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${list }" var="obj" varStatus="cnt">
					<tr>
						<td class="text-center"><input type="checkbox" id="cb"></td>
						<td class="text-center">${obj.eventNum}</td>
						<td class="text-center"><a href="/cltsh/adm/event/admEventEdit.do?eventInfoSeq=${obj.eventInfoSeq}">${obj.eventName}</a></td>
						<td class="text-center">${obj.eventRegistDate}</td>
						<td class="text-center">${obj.eventEndDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="d-flex justify-content-between align-items-center mt-4">
		<div>${paging}</div>
		<div class="btn_area">
			<a href="/cltsh/adm/event/admEventRegister.do" class="btn btn-primary">추가</a>
		</div>
	</div>
</div>