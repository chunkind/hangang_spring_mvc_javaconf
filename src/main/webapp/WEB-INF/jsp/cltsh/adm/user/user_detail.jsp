<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">회원 관리</h2>
	<div class="row mb-3">
		<div class="col-md-4">
			<label class="form-label">회원 번호</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.usrBaseSeq}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">아이디</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.usrId}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">이름</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.usrNm}" readonly>
		</div>
	</div>

	<div class="row mb-3">
		<div class="col-md-4">
			<label class="form-label">생년월일</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.usrBirth}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">이메일</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.emailAddr}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">핸드폰 번호</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.cellNo}" readonly>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label class="form-label">도로명 주소</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.loadAddrBase}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">상세주소</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.loadAddrDtl}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">우편번호</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.loadPostNo}" readonly>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-md-4">
			<label class="form-label">회원가입일</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.rgstDate}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">정지 여부</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.lockYn}" readonly>
		</div>
		<div class="col-md-4">
			<label class="form-label">사용 여부</label>
			<input type="text" class="form-control" maxlength="20" value="${pvo.useYn}" readonly>
		</div>
	</div>
	
	<div class="text-center mt-4">
		<button type="button" class="btn btn-secondary" onclick="location.href='/cltsh/adm/user/admUserList.do'">목록</button>
	</div>
</div>