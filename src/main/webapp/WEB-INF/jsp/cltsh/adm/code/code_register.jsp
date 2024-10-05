<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">공통코드 관리 > 등록</h2>
	<form name="frm" action="/cltsh/adm/code/admCodeRegisterAct.do" method="post" enctype="multipart/form-data">
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="codeNm" class="form-label">코드 이름</label>
			<input type="text" id="codeNm" name="codeNm" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="codeVal" class="form-label">코드 값</label>
			<input type="text" id="codeVal" name="codeVal" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="useYn" class="form-label">사용여부</label>
			<select id="useYn" name="useYn" class="form-select">
				<option value="Y">사용</option>
				<option value="N">미사용</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label for="grpOrdr" class="form-label">코드 순번</label>
			<input type="text" id="grpOrdr" name="grpOrdr" class="form-control" maxlength="20" >
		</div>
		<div class="col-md-4">
			<label for="grpCd" class="form-label">코드 그룹</label>
			<input type="text" id="grpCd" name="grpCd" class="form-control" maxlength="20">
		</div>
		<div class="col-md-4">
			<label for="codeDesc" class="form-label">설명</label>
			<textarea rows="20" cols="50" name="codeDesc"></textarea>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<button type="button" class="btn btn-light me-2" onclick="location.href = '/cltsh/adm/code/admCodeList.do'">목록</button>
		<button type="submit" class="btn btn-light">등록하기</button>
	</div>
	</form>
</div>
