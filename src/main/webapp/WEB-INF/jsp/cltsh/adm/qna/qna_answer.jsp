<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>1:1문의관리 > 답변하기</h2>
<form name="frm" action="/cltsh/adm/qna/admQnaAnswerAct.do" method="post" onsubmit="return fn_qna_edit()">
<div class="data_list">
	<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq }" />
	<table>
		<colgroup>
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="30%" />
		</colgroup>
		<tr>
			<th>제목</th>
			<td>${pvo.titNm}</td>
			<th>문의 유형</th>
			<td>${pvo.qnaTp}</td>
		</tr>
		<tr>
			<th>답변 상태</th>
			<td>${pvo.ansrStat}</td>
			<th>사용 여부</th>
			<td>${pvo.useYn}</td>
		</tr>
		<tr>
			<td colspan="4"><textarea rows="20" cols="100">${pvo.cont}</textarea></td>
		</tr>
		<tr>
			<td colspan="4"><textarea rows="20" cols="100" name="answer"></textarea></td>
		</tr>
	</table>
</div>
<div class="btn_area">
	<input type="button" value="목록" onclick="location.href='/cltsh/adm/qna/admQnaList.do'"/>
	<input type="submit" value="답변"/>
</div>
</form>

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
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>