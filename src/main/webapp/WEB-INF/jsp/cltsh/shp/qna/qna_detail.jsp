<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
.item_list_area{
	text-align: left;
}
</style>
<section class="title_area">
	<h3 class="title">1:1문의 > 상세</h3>
</section>
<section class="item_list_area">
<form name="frm" action="/cltsh/qna/qnaEdit.do" method="post">
	<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq }" />
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>제목</th>
			<td>${pvo.titNm}</td>
			<th>문의유형</th>
			<td>${pvo.qnaTp}</td>
		</tr>
		<tr>
			<th>답변 상태</th>
			<td colspan="3">${pvo.ansrStat}</td>
		</tr>
		<tr>
			<th colspan="4">내용</th>
		</tr>
		<tr>
			<td colspan="4">${pvo.cont}</td>
		</tr>
		<c:if test="${pvo.ansrStat eq '답변 완료' }">
		<tr>
			<th colspan="4">답변</th>
		</tr>
		<tr>
			<td colspan="4">${pvo.answer}</td>
		</tr>
		</c:if>
	</table>
	<div class="btn_area">
		<input type="button" value="목록" onclick="location.href='/cltsh/main/mainQnaList.do'"/>
		<input type="submit" value="수정"/>
	</div>
</form>
</section>