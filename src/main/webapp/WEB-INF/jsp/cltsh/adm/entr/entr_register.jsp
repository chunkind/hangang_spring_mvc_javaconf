<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">업체 관리 > 업체 목록 > 업체 등록</h2>
	<form action="/cltsh/adm/entr/admEntrRegisterAct.do" method="post" enctype="multipart/form-data">
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="entrNm" class="form-label">거래처명</label>
			<input type="text" id="entrNm" name="entrNm" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="bmanRegNo" class="form-label">사업자번호</label>
			<input type="text" id="bmanRegNo" name="bmanRegNo" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="useYn" class="form-label">사용여부</label>
			<select id="useYn" name="useYn" class="form-select">
				<option value="Y">사용</option>
				<option value="N">사용안함</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="opnDate" class="form-label">개점일</label>
			<input type="date" id="opnDate" name="opnDate" class="form-control">
		</div>
		<div class="col-md-4">
			<label for="closeDate" class="form-label">폐점일</label>
			<input type="date" id="closeDate" name="closeDate" class="form-control">
		</div>
		<div class="col-md-4">
			<label for="opnYn" class="form-label">오픈여부</label>
			<select id="opnYn" name="opnYn" class="form-select">
				<option value="Y">open</option>
				<option value="N">close</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">대표자명</label>
			<input type="text" id="presNm" name="presNm" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">대표자번호</label>
			<input type="text" id="presTell" name="presTell" class="form-control" maxlength="11">
		</div>
		<div class="col-md-4">
			<label for="presEmail" class="form-label">대표자메일</label>
			<input type="email" id="presEmail" name="presEmail" class="form-control" maxlength="20">
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">지번우편번호</label>
			<input type="text" id="landPostNo" name="landPostNo" class="form-control" maxlength="6">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">지번기본주소</label>
			<input type="text" id="landAddrBase" name="landAddrBase" class="form-control" maxlength="30">
		</div>
		<div class="col-md-4">
			<label for="presEmail" class="form-label">지번상세주소</label>
			<input type="text" id="landAddrDtl" name="landAddrDtl" class="form-control" maxlength="30">
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">도로우편번호</label>
			<input type="text" id="loadPostNo" name="loadPostNo" class="form-control"  maxlength="5">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">도로주소기본</label>
			<input type="text" id="loadAddrBase" name="loadAddrBase" class="form-control" maxlength="30">
		</div>
		<div class="col-md-4">
			<label for="usrId" class="form-label">회원 아이디</label>
			<select id="usrId" name="usrId" class="form-select">
				<option value="">선택</option>
				<c:forEach items="${userList}" var="obj">
					<option value="${obj.usrId }">${obj.usrId }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<button type="button" class="btn btn-light me-2" onclick="location.href = '/cltsh/adm/entr/admEntrList.do'">목록</button>
		<button type="submit" class="btn btn-light me-2">등록</button>
	</div>
	</form>
</div>

<script>
document.addEventListener("DOMContentLoaded", () => {
	
});
</script>