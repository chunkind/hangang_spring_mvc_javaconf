<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">1:1문의관리 > 답변하기</h2>
	<form name="frm" action="/cltsh/adm/qna/admQnaAnswerAct.do" method="post" onsubmit="return fn_qna_edit()">
		<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq }" />
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="titNm" class="form-label">제목</label>
				<input type="text" id="titNm" name="titNm" class="form-control" maxlength="20" value="${pvo.titNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="qnaTp" class="form-label">문의 유형</label>
				<input type="text" id="qnaTp" name="qnaTp" class="form-control" maxlength="20" value="${pvo.qnaTp}" readonly>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ansrStat" class="form-label">답변 상태</label>
				<input type="text" id="ansrStat" name="ansrStat" class="form-control" maxlength="20" value="${pvo.ansrStat}" readonly>
			</div>
			<div class="col-md-4">
				<label for="useYn" class="form-label">사용 여부</label>
				<input type="text" id="useYn" name="useYn" class="form-control" maxlength="20" value="${pvo.useYn}" readonly>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ansrStat" class="form-label">질문</label>
				<textarea rows="20" cols="100">${pvo.cont}</textarea>
			</div>
			<div class="col-md-4">
				<label for="useYn" class="form-label">답변 작성</label>
				<textarea rows="20" cols="100" name="answer"></textarea>
			</div>
		</div>
		
		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/qna/admQnaList.do'">목록</button>
			<button type="submit" class="btn btn-secondary">답변하기</button>
		</div>
	</form>
</div>

<script>
//상품수정
function fn_qna_edit(){
	if(confirm('답변 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}
</script>