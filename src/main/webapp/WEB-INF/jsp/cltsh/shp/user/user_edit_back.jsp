<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#frm{
	display: flex;
    flex-direction: column;
}
</style>

<header id="header">
	<div class="logo"><a href="/cltsh/main/mainCataList.do"><img src="/img/cltsh/logo_01.png" /></a></div>
</header>

<section id="section" class="section">
	<div class="input_area">
		<h1>회원 정보 수정</h1>
		<div class="top">
		<form name="frm" action="/cltsh/user/userEditAct.do" method="post" onsubmit="return fn_user_edit()">		
		<input type="hidden" name="usrBaseSeq" value="${sessionScope.loginInfo.usrBaseSeq }">
		<input type="text" class="id" value="${sessionScope.loginInfo.usrId }" name="usrId" readonly="readonly">
		<input type="text" name="usrNm" value="${sessionScope.loginInfo.usrNm }" placeholder="이름 입력 ">
		<input type="email" name="emailAddr" placeholder="이메일 입력 " value="${pvo.emailAddr }">
		<input type="password" name="passWd" placeholder="비밀번호 입력 " value="${pvo.passWd }">
		<input type="password" placeholder="비밀번호 재입력 " value="${pvo.passWd }">
		<input type="tel" name="cellNo" placeholder="01012341234" value="${pvo.cellNo }">
		<button id="c_btn">인증요청</button>
		<input class="landAddrBase" type="landAddrBase" value="${pvo.landAddrBase }" name="landAddrBase">
		<input class="landAddrDtl" type="landAddrDtl" value="${pvo.landAddrDtl }" name="landAddrDtl">
		<input class="landPostNo" type="landPostNo" value="${pvo.landPostNo }" name="landPostNo">
		<input class="loadAddrBase" type="loadAddrBase" value="${pvo.loadAddrBase }" name="loadAddrBase" placeholder="도로명주소">
		<input class="loadAddrDtl" type="loadAddrDtl" value="${pvo.loadAddrDtl }" name="loadAddrDtl" placeholder="도로명주소 상세">
		<label>생년월일</label>
		<input type="date" name="usrBirth" placeholder="생년월일" value="${pvo.usrBirth }">
		<input type="submit" value="수정하기" />
		</form>
		</div>
	</div>
</section>
<script>
//상품수정
function fn_user_edit(){
	if(confirm('정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}
</script>