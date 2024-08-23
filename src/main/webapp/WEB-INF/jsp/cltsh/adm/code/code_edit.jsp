<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">공통코드 관리 > 상세</h2>
	<form name="frm" action="/cltsh/adm/code/admCodeEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_code_edit()">
	<input type="hidden" name="stdCdBaseSeq" value="${pvo.stdCdBaseSeq }" />
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="codeNm" class="form-label">코드 이름</label>
			<input type="text" id="codeNm" name="codeNm" class="form-control" maxlength="20" value="${pvo.codeNm}">
		</div>
		<div class="col-md-4">
			<label for="codeVal" class="form-label">코드 값</label>
			<input type="text" id="codeVal" name="codeVal" class="form-control" maxlength="20" value="${pvo.codeVal}">
		</div>
		<div class="col-md-4">
			<label for="useYn" class="form-label">사용여부</label>
			<select id="useYn" name="useYn" class="form-select">
				<option value="Y" <c:if test="${pvo.useYn eq 'Y'}" >selected</c:if>>사용</option>
				<option value="N" <c:if test="${pvo.useYn eq 'N'}" >selected</c:if>>미사용</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="grpOrdr" class="form-label">코드 순번</label>
			<input type="text" id="grpOrdr" name="grpOrdr" class="form-control" maxlength="20" value="${pvo.grpOrdr}">
		</div>
		<div class="col-md-4">
			<label for="grpCd" class="form-label">코드 그룹</label>
			<input type="text" id="grpCd" name="grpCd" class="form-control" maxlength="20" value="${pvo.grpCd}">
		</div>
		<div class="col-md-4">
			<label for="codeDesc" class="form-label">설명</label>
			<textarea rows="20" cols="50" name="codeDesc">${pvo.codeDesc}</textarea>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<button type="button" class="btn btn-light me-2" onclick="location.href = '/cltsh/adm/code/admCodeList.do'">목록</button>
		<button type="submit" class="btn btn-light me-2">수정</button>
		<button type="button" class="btn btn-danger" onclick="fn_code_remove('${pvo.stdCdBaseSeq}')">삭제</button>
	</div>
	</form>
</div>

<script>
//상품수정
function fn_code_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_code_remove(stdCdBaseSeq){
	if(confirm('상품을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/code/admCodeRemoveAct.do?stdCdBaseSeq=' + stdCdBaseSeq;
	}
}
</script>