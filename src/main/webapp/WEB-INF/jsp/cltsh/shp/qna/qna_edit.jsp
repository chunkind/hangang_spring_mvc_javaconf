<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
	.item_list_area{
		text-align: left;
	}
</style>
<section class="title_area">
	<h3 class="title">1:1문의 > 수정하기</h3>
</section>
<section class="item_list_area">
	<form name="frm" action="/cltsh/qna/qnaEditAct.do" method="post" onsubmit="return fn_qna_edit()">
		<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq }" />
		<input type="hidden" name="qnaTp" value="${pvo.qnaTp}" />
		<input type="hidden" name="ansrStat" value="${pvo.ansrStat }" />
		<input type="hidden" name="useYn" value="${pvo.useYn }"/>
		<input type="hidden" name="passYn" value="${pvo.passYn }" />
		<input type="hidden" name="passWd" value="${pvo.passWd }"/>
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>제목</th>
			<td><input type="text" name="titNm" value="${pvo.titNm}"></td>
			<th>문의유형</th>
			<td>${pvo.qnaTp}</td>
		</tr>
		<tr>
			<th>답변 상태</th>
			<td colspan="3">${pvo.ansrStat}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="20" cols="100" name="cont">${pvo.cont}</textarea>
			</td>
		</tr>
	</table>
	<div class="btn_area">
		<input type="button" value="목록" onclick="location.href='/main/mainQnaList.do'"/>
		<input type="button" value="삭제" onclick="fn_qna_remove('${pvo.qnaBoardSeq}')"/>
		<input type="submit" value="수정"/>
	</div>
	</form>
</section>
<script>
//상품수정
function fn_qna_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_qna_remove(qnaBoardSeq){
	if(confirm('상품을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/qna/qnaRemoveAct.do?qnaBoardSeq=' + qnaBoardSeq;
	}
}

document.addEventListener("DOMContentLoaded", () => {
	let sel_passYn = document.querySelector('#passYn');
	var target = document.getElementById("passYn");
   	
	console.log(target.options[target.selectedIndex].value);
	if(target.options[target.selectedIndex].value == 'N'){
		document.getElementById("passWd").style.display = "none";
	}else if(target.options[target.selectedIndex].value == 'Y'){
		document.getElementById("passWd").style.display = "block";
	}
	
	
	sel_passYn.addEventListener('change', (e)=>{
		let selectedVal = e.target.value;
		
		if(selectedVal == 'N'){
			document.getElementById("passWd").style.display = "none";
		}else{
			document.getElementById("passWd").style.display = "block";
		}
		
	});
});
</script>