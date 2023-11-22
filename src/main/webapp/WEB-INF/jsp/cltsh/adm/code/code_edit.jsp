<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<style>
	.title_area, .item_list_area{
		text-align: left;
	}
</style>
<section class="title_area">
	<h3 class="title">공통코드 관리 > 상세</h3>
</section>
<section class="item_list_area">
<form name="frm" action="/cltsh/adm/code/admCodeEditAct.do" method="post" onsubmit="return fn_code_edit()">
	<input type="hidden" name="stdCdBaseSeq" value="${pvo.stdCdBaseSeq }" />

	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>코드 이름</th>
			<td>
				<input type="text" name="codeNm"  value="${pvo.codeNm}">
			</td>
			<th>코드 값</th>
			<td>
				<input type="text" name="codeVal"  value="${pvo.codeVal}">
			</td>
		</tr>
		<tr>
			<th>코드 순번</th>
			<td><input type="number" name="grpOrdr" value="${pvo.grpOrdr}"></td>
			<th>코드 그룹</th>
			<td><input type="text" name="grpCd" value="${pvo.grpCd}"></td>
		</tr>
		<tr>
			<th>사용 여부</th>
			<td colspan="3">
				<select name="useYn">
					<option value="Y" <c:if test="${pvo.useYn eq 'Y'}" >selected</c:if>>사용</option>
					<option value="N" <c:if test="${pvo.useYn eq 'N'}" >selected</c:if>>미사용</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="4">설명</th>
		</tr>
		<tr>
			<td colspan="4">
				<textarea rows="20" cols="50" name="codeDesc">${pvo.codeDesc}</textarea>
			</td>
		</tr>
	</table>
	<div class="btn_area">
		<input type="button" value="목록" onclick="location.href='/adm/code/admCodeList.do'"/>
		<input type="button" value="삭제" onclick="fn_code_remove('${pvo.stdCdBaseSeq}')"/>
		<input type="submit" value="수정" />
	</div>
</form>
</section>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>
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