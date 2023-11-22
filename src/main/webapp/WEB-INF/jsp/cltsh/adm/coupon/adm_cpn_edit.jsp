<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>쿠폰 목록 > 쿠폰 수정</h2>
<form action="/cltsh/adm/cpn/admCpnEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_cpn_edit()">
<input type="hidden" name="couInfoSeq" value="${pvo.couInfoSeq }" />
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="20%" />
    		<col width="30%" />
    		<col width="20%" />
    		<col width="30%" />
    	</colgroup>
    	<tr>
    		<th><div>쿠폰 이름</div></th>
            <td><input type="text" name="couName" value="${pvo.couName }"></td>
            <th><div>쿠폰 할인율</div></th>
            <td><input type="number" name="couDiscount" value="${pvo.couDiscount }"></td>
        </tr>
        <tr>
    		<th><div>쿠폰 만료 날짜</div></th>
            <td><input type="Date" name="couEndDate" value="${pvo.couEndDate }"></td>
            <th><div>쿠폰 개수</div></th>
            <td><input type="number" name="couCount" value="${pvo.couCount }"></td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/adm/cpn/admCpnList.do'"/>
    <input type="button" value="삭제" onclick="fn_cpn_remove('${pvo.couInfoSeq}')"/>
    <input type="submit" value="수정"/>
</div>
</form>
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
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>