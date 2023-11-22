<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>쿠폰 목록 > 쿠폰 수정</h2>
<form action="/cltsh/adm/prom/admPromEditAct.do" method="post" onsubmit="return fn_cpn_edit()">
<input type="hidden" name="promSeq" value="${pvo.promSeq }" />
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="20%" />
    		<col width="30%" />
    		<col width="20%" />
    		<col width="30%" />
    	</colgroup>
    	<tr>
    		<th><div>프로모션명</div></th>
            <td colspan="3"><input type="text" name="promName" value="${pvo.promName }"></td>
        </tr>
        <tr>
    		<th><div>프로모션 유형</div></th>
            <td><input type="text" name="promTp" value="${pvo.promTp }"></td>
            <th><div>프로모션 할인율</div></th>
            <td><input type="number" name="promDiscount" value="${pvo.promDiscount }"></td>
        </tr>
        <tr>
    		<th><div>프로모션 시작일</div></th>
            <td><input type="Date" name="promRegistDate" value="${pvo.promRegistDate }"></td>
            <th><div>프로모션 종료일</div></th>
            <td><input type="Date" name="promEndDate" value="${pvo.promEndDate }"></td>
        </tr>
        <tr>
    		<th><div>프로모션내용</div></th>
            <td colspan="3">
            	<textarea name="promCont">${pvo.promCont}</textarea>
            </td>
        </tr>
        <tr>
    		<th rowspan="2"><div>프로모션 이미지</div></th>
            <td colspan="3">
            	<img src="${pvo.imgPath}/${pvo.imgNm}" />
            </td>
        </tr>
        <tr>
            <td colspan="3">
            	<input type="file" />
            </td>
        </tr>
        <tr>
    		<th><div>최초 작성자</div></th>
            <td>${pvo.rgstId}</td>
            <th><div>최초 작성일</div></th>
            <td>${pvo.rgstDate}</td>
        </tr>
        <tr>
    		<th><div>최종 작성자</div></th>
            <td>${pvo.updtId}</td>
            <th><div>최종 작성일</div></th>
            <td>${pvo.updtDate}</td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/prom/admPromList.do'"/>
    <input type="button" value="삭제" onclick="fn_prom_remove('${pvo.promSeq}')"/>
    <input type="submit" value="수정"/>
</div>
</form>
<script>
//상품수정
function fn_prom_edit(){
	if(confirm('쿠폰을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_prom_remove(couInfoSeq){
	if(confirm('쿠폰을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/prom/admPromRemoveAct.do?promSeq=' + promSeq;
	}
}
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>