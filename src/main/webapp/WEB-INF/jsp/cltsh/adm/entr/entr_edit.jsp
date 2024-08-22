<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">업체 관리 > 업체 목록 > 업체 수정</h2>
	<form action="/cltsh/adm/entr/admEntrEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_edit()">
	<input type="hidden" name="entrNo" value="${evo.entrNo}" />

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="entrNm" class="form-label">거래처명</label>
			<input type="text" id="entrNm" name="entrNm" class="form-control" maxlength="20" value="${evo.entrNm}">
		</div>
		<div class="col-md-4">
			<label for="bmanRegNo" class="form-label">사업자번호</label>
			<input type="text" id="bmanRegNo" name="bmanRegNo" class="form-control" maxlength="20" value="${evo.bmanRegNo}">
		</div>
		<div class="col-md-4">
			<label for="useYn" class="form-label">사용여부</label>
			<select id="useYn" name="useYn" class="form-select">
				<option value="Y"
						<c:if test="${evo.useYn eq 'Y'}">selected</c:if>>사용</option>
				<option value="N" <c:if test="${evo.useYn eq 'N'}">selected</c:if>>사용안함</option>
			</select>
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="opnDate" class="form-label">개점일</label>
			<input type="date" id="opnDate" name="opnDate" class="form-control" value="${evo.opnDate}">
		</div>
		<div class="col-md-4">
			<label for="closeDate" class="form-label">폐점일</label>
			<input type="date" id="closeDate" name="closeDate" class="form-control" value="${evo.closeDate}">
		</div>
		<div class="col-md-4">
			<label for="opnYn" class="form-label">오픈여부</label>
			<select id="opnYn" name="opnYn" class="form-select">
				<option value="Y" <c:if test="${evo.opnYn eq 'Y'}">selected</c:if>>open</option>
				<option value="N" <c:if test="${evo.opnYn eq 'N'}">selected</c:if>>close</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">대표자명</label>
			<input type="text" id="presNm" name="presNm" class="form-control" maxlength="20" value="${evo.presNm}">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">대표자번호</label>
			<input type="text" id="presTell" name="presTell" class="form-control" maxlength="11" value="${evo.presTell}">
		</div>
		<div class="col-md-4">
			<label for="presEmail" class="form-label">대표자메일</label>
			<input type="email" id="presEmail" name="presEmail" class="form-control" maxlength="20" value="${evo.presEmail}">
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">지번우편번호</label>
			<input type="text" id="landPostNo" name="landPostNo" class="form-control" maxlength="6" value="${evo.landPostNo}">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">지번기본주소</label>
			<input type="text" id="landAddrBase" name="landAddrBase" class="form-control" maxlength="30" value="${evo.landAddrBase}">
		</div>
		<div class="col-md-4">
			<label for="presEmail" class="form-label">지번상세주소</label>
			<input type="text" id="landAddrDtl" name="landAddrDtl" class="form-control" maxlength="30" value="${evo.landAddrDtl}">
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label for="presNm" class="form-label">도로우편번호</label>
			<input type="text" id="loadPostNo" name="loadPostNo" class="form-control"  maxlength="5" value="${evo.loadPostNo}">
		</div>
		<div class="col-md-4">
			<label for="presTell" class="form-label">도로주소기본</label>
			<input type="text" id="loadAddrBase" name="loadAddrBase" class="form-control" maxlength="30" value="${evo.loadAddrBase}">
		</div>
		<div class="col-md-4">
			<label for="usrId" class="form-label">회원 아이디</label>
			<select id="usrId" name="usrId" class="form-select">
				<option value="">선택</option>
				<c:forEach items="${userList}" var="obj">
					<option value="${obj.usrId }" <c:if test="${evo.usrId eq obj.usrId }">selected</c:if> >${obj.usrId }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<button type="button" class="btn btn-light me-2" onclick="location.href = '/cltsh/adm/entr/admEntrList.do'">목록</button>
		<button type="submit" class="btn btn-light me-2">수정</button>
		<button type="button" class="btn btn-danger" onclick="fn_remove('${evo.entrNo}')">삭제</button>
	</div>
	</form>
</div>

<script>
document.addEventListener("DOMContentLoaded", () => {
	
});

//상품수정
function fn_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_remove(entrNo){
	if(confirm('상품을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/entr/admEntrRemoveAct.do?entrNo=' + entrNo;
	}
}
</script>