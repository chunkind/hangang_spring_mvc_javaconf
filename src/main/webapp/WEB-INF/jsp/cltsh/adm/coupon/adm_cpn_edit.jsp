<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">쿠폰 목록 > 쿠폰 수정</h2>
	<form action="/cltsh/adm/cpn/admCpnEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_cpn_edit()">
		<input type="hidden" name="couInfoSeq" value="${pvo.couInfoSeq }" />
		<div class="row mb-3">
			<div class="col-md-3">
				<label for="couName" class="form-label">쿠폰 이름</label>
				<input type="text" id="couName" name="couName" class="form-control" value="${pvo.couName }" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couDiscount" class="form-label">쿠폰 할인율</label>
				<input type="number" id="couDiscount" name="couDiscount" class="form-control" value="${pvo.couDiscount }" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couEndDate" class="form-label">쿠폰 만료 날짜</label>
				<input type="Date" id="couEndDate" name="couEndDate" class="form-control" value="${pvo.couEndDate }" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couCount" class="form-label">쿠폰 개수</label>
				<input type="number" id="couCount" name="couCount" class="form-control" value="${pvo.couCount }" maxlength="20">
			</div>
		</div>
		
		<div class="text-center mt-4">
			<button type="button" class="btn btn-light me-2" onclick="location.href='/cltsh/adm/cpn/admCpnList.do'">목록</button>
			<button type="submit" class="btn btn-light me-2">수정</button>
			<button type="button" class="btn btn-danger" onclick="fn_cpn_remove('${pvo.couInfoSeq}')">삭제</button>
		</div>
	</form>
</div>

<script>
//상품수정
function fn_cpn_edit(){
	if(confirm('쿠폰을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_cpn_remove(couInfoSeq){
	if(confirm('쿠폰을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/cpn/admCpnRemoveAct.do?couInfoSeq=' + couInfoSeq;
	}
}
</script>