<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>업체 관리 > 업체 목록 > 업체 수정</h2>
<form action="/cltsh/adm/entr/admEntrEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_edit()">
<input type="hidden" name="entrNo" value="${evo.entrNo }" />
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="10%" />
    		<col width="" />
    		<col width="10%" />
    		<col width="" />
    		<col width="10%" />
    		<col width="" />
    	</colgroup>
    	<tr>
    		<th><div>거래처명</div></th>
            <td><input type="text" name="entrNm" maxlength="20" value="${evo.entrNm}"></td>
            <th><div>사업자번호</div></th>
            <td><input type="text" name="bmanRegNo" maxlength="20" value="${evo.bmanRegNo}"></td>
            <th><div>사용여부</div></th>
            <td>
            	<select name="useYn">
            		<option value="Y" <c:if test="${evo.useYn eq 'Y'}" >selected</c:if>>사용</option>
            		<option value="N" <c:if test="${evo.useYn eq 'N'}" >selected</c:if>>사용안함</option>
            	</select>
            </td>
        </tr>
        <tr>
    		<th><div>개점일</div></th>
            <td><input type="date" name="opnDate" value="${evo.opnDate}"></td>
            <th><div>폐점일</div></th>
            <td><input type="date" name="closeDate" value="${evo.closeDate}"></td>
            <th><div>오픈여부</div></th>
            <td>
            	<select name="opnYn">
            		<option value="Y" <c:if test="${evo.opnYn eq 'Y'}" >selected</c:if>>open</option>
            		<option value="N" <c:if test="${evo.opnYn eq 'N'}" >selected</c:if>>close</option>
            	</select>
            </td>
        </tr>
        <tr>
    		<th><div>대표자명</div></th>
            <td><input type="text" name="presNm" maxlength="20" value="${evo.presNm}"></td>
            <th><div>대표자번호</div></th>
            <td><input type="text" name="presTell" maxlength="11" value="${evo.presTell}"></td>
            <th><div>대표자메일</div></th>
            <td><input type="email" name="presEmail" maxlength="20" value="${evo.presEmail}"></td>
        </tr>
        <tr>
    		<th><div>담당자명</div></th>
            <td><input type="text" name="aempNm" maxlength="20" value="${evo.aempNm}"></td>
            <th><div>담당자번호</div></th>
            <td><input type="text" name="aempTell" maxlength="11" value="${evo.aempTell}"></td>
            <th><div>담당자메일</div></th>
            <td><input type="email" name="aempEmail" maxlength="20" value="${evo.aempEmail}"></td>
        </tr>
        <tr>
    		<th><div>지번우편번호</div></th>
            <td><input type="text" name="landPostNo" maxlength="6" value="${evo.landPostNo}"></td>
            <th><div>지번기본주소</div></th>
            <td><input type="text" name="landAddrBase" maxlength="30" value="${evo.landAddrBase}"></td>
            <th><div>지번상세주소</div></th>
            <td><input type="text" name="landAddrDtl" maxlength="30" value="${evo.landAddrDtl}"></td>
        </tr>
        <tr>
    		<th><div>도로우편번호</div></th>
            <td><input type="text" name="loadPostNo" maxlength="5" value="${evo.loadPostNo}"></td>
            <th><div>도로주소기본</div></th>
            <td><input type="text" name="loadAddrBase" maxlength="30" value="${evo.loadAddrBase}"></td>
            <th><div>회원 아이디</div></th>
            <td>
            	<select name="usrId">
            		<option value="">선택</option>
            		<c:forEach items="${userList}" var="obj">
            			<option value="${obj.usrId }" <c:if test="${evo.usrId eq obj.usrId }">selected</c:if> >${obj.usrId }</option>
            		</c:forEach>
            	</select>
            </td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href = '/adm/entr/admEntrList.do'"/>
    <input type="button" value="삭제" onclick="fn_remove('${evo.entrNo}')"/>
    <input type="submit" value="수정"/>
</div>
</form>
<script>
document.addEventListener("DOMContentLoaded", () => {
	
});

//상품수정
function fn_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_remove(entrNo){
	if(confirm('상품을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/entr/admEntrRemoveAct.do?entrNo=' + entrNo;
	}
}
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>