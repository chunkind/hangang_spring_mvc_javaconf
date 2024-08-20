<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="mb-4">업체 관리 > 업체 목록</h2>
	<div class="row mb-4">
		<div class="col-md-8">
			<div class="d-flex align-items-center">
				<label for="sortSelect" class="col-4">정렬 기준:</label>
				<select id="sortSelect" class="form-select ms-auto">
					<option>등록일순</option>
					<option>이름순</option>
				</select>
			</div>
		</div>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th class="text-center"><input type="checkbox" id="selectAll"></th>
					<th class="text-center">순번</th>
					<th class="text-center">거래처명</th>
					<th class="text-center">대표자명</th>
					<th class="text-center">대표자번호</th>
					<th class="text-center">담당자명</th>
					<th class="text-center">담당자번호</th>
					<th class="text-center">평점</th>
					<th class="text-center">개점일</th>
					<th class="text-center">폐점일</th>
					<th class="text-center">오픈여부</th>
					<th class="text-center">사용여부</th>
					<th class="text-center">등록 아이디</th>
					<th class="text-center">수정 아이디</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty entrList}">
					<tr>
						<td colspan="14" class="text-center">데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${entrList}" var="obj" varStatus="cnt">
					<tr>
						<td class="text-center"><input type="checkbox" class="form-check-input" id="cb_${cnt.count}"></td>
						<td class="text-center">${cnt.count}</td>
						<td class="text-center"><a href="/cltsh/adm/entr/admEntrEdit.do?entrNo=${obj.entrNo}" class="text-decoration-none">${obj.entrNm}</a></td>
						<td class="text-center">${obj.presNm}</td>
						<td class="text-center">${obj.presTell}</td>
						<td class="text-center">${obj.aempNm}</td>
						<td class="text-center">${obj.aempTell}</td>
						<td class="text-center">${obj.score}</td>
						<td class="text-center">${obj.opnDate}</td>
						<td class="text-center">${obj.closeDate}</td>
						<td class="text-center">${obj.opnYn}</td>
						<td class="text-center">${obj.useYn}</td>
						<td class="text-center">${obj.rgstId}</td>
						<td class="text-center">${obj.updtId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="d-flex justify-content-between align-items-center mt-4">
		<div>${paging}</div>
		<div>
			<a href="/cltsh/adm/entr/admEntrRegister.do" class="btn btn-primary">등록</a>
		</div>
	</div>
</div>