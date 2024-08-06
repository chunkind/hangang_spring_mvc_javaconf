<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<form name="frm" action="/cltsh/qna/qnaEditAct.do" method="post" onsubmit="return fn_qna_edit()">
		<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq }" />
		<input type="hidden" name="qnaTp" value="${pvo.qnaTp}" />
		<input type="hidden" name="ansrStat" value="${pvo.ansrStat }" />
		<input type="hidden" name="useYn" value="${pvo.useYn }" />
		<input type="hidden" name="passYn" value="${pvo.passYn }" />
		<input type="hidden" name="passWd" value="${pvo.passWd }" />
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h5 class="mb-0">문의 수정</h5>
			</div>
			<div class="card-body">
				<table class="table table-bordered">
					<colgroup>
						<col style="width: 10%;">
						<col style="width: 40%;">
						<col style="width: 10%;">
						<col style="width: 40%;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">제목</th>
							<td><input type="text" class="form-control" name="titNm" value="${pvo.titNm}"></td>
							<th scope="row">문의유형</th>
							<td>${pvo.qnaTp}</td>
						</tr>
						<tr>
							<th scope="row">답변 상태</th>
							<td colspan="3">${pvo.ansrStat}</td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td colspan="3"><textarea class="form-control" rows="10" name="cont">${pvo.cont}</textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="text-right">
					<button type="button" class="btn btn-secondary" onclick="location.href='/main/mainQnaList.do'">목록</button>
					<button type="button" class="btn btn-danger" onclick="fn_qna_remove('${pvo.qnaBoardSeq}')">삭제</button>
					<button type="submit" class="btn btn-primary">수정</button>
				</div>
			</div>
		</div>
	</form>
</div>

<script>
// 상품 수정
function fn_qna_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	} else {
		return false;
	}
}

// 상품 삭제
function fn_qna_remove(qnaBoardSeq){
		if(confirm('상품을 정말 삭제 하시겠습니까?')){
			location.href='/cltsh/qna/qnaRemoveAct.do?qnaBoardSeq=' + qnaBoardSeq;
		}
}

document.addEventListener("DOMContentLoaded", () => {
	let sel_passYn = document.querySelector('input[name="passYn"]');
	var passWd = document.querySelector('input[name="passWd"]');

	if (sel_passYn.value == 'N') {
		passWd.style.display = "none";
	} else if (sel_passYn.value == 'Y') {
		passWd.style.display = "block";
	}

	sel_passYn.addEventListener('change', (e) => {
		let selectedVal = e.target.value;

		if (selectedVal == 'N') {
			passWd.style.display = "none";
		} else {
			passWd.style.display = "block";
		}
	});
});
</script>
