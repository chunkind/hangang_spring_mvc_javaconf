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
	
<div class="row g-5">
	<div class="col-md-7 col-lg-8">
		<h4 class="mb-3">회원 정보 수정</h4>
		<form class="needs-validation" name="frm" action="/cltsh/user/userEditAct.do" method="post" onsubmit="return fn_user_edit()" novalidate>
			<input type="hidden" name="usrBaseSeq" value="${sessionScope.loginInfo.usrBaseSeq }">
			<div class="row g-3">
				<div class="col-sm-6">
					<label for="firstName" class="form-label">아이디</label>
					<input type="text" class="form-control" value="${sessionScope.loginInfo.usrId }" name="usrId" readonly="readonly" required>
					<div class="invalid-feedback">Valid first name is required.</div>
				</div>
				
				<div class="col-6">
					<label for="email" class="form-label">이름</label>
					<input type="text" class="form-control" name="usrNm" value="${sessionScope.loginInfo.usrNm }" placeholder="이름 입력 ">
					<div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
				</div>
				
				<div class="col-sm-6">
					<label for="lastName" class="form-label">비밀번호</label>
					<input type="password" class="form-control" name="passWd" placeholder="비밀번호 입력 " value="${pvo.passWd }" placeholder="" required>
					<div class="invalid-feedback">Valid last name is required.</div>
				</div>
				
				<div class="col-sm-6">
					<label for="lastName" class="form-label">비밀번호 확인</label>
					<input type="password" class="form-control" name="" placeholder="비밀번호 재입력 " value="${pvo.passWd }" placeholder="" required>
					<div class="invalid-feedback">Valid last name is required.</div>
				</div>
				
				<div class="col-6">
					<label for="username" class="form-label">이메일</label>
					<div class="input-group has-validation">	
						<span class="input-group-text">@</span>
						<input type="email" class="form-control" name="emailAddr" placeholder="이메일 입력 " value="${pvo.emailAddr }">
						<div class="invalid-feedback">Your username is required.</div>
					</div>
				</div>

				<div class="col-6">
					<label for="address" class="form-label">핸드폰 번호</label>
					<input type="tel" class="form-control" name="cellNo" placeholder="01012341234" value="${pvo.cellNo }">
					<button id="c_btn">인증요청</button>
					<div class="invalid-feedback">Please enter your shipping address.</div>
				</div>
				
				<div class="col-5">
					<label for="address" class="form-label">주소</label>
					<input type="text" class="form-control" name="landAddrBase" value="${pvo.landAddrBase }" required>
					<div class="invalid-feedback">Please enter your shipping address.</div>
				</div>
				
				<div class="col-5">
					<label for="address2" class="form-label">상세 주소</label>
					<input type="text" class="form-control" name="landAddrDtl" value="${pvo.landAddrDtl }" >
				</div>
				
				<div class="col-2">
					<label for="address2" class="form-label">우편 번호</label>
					<input type="text" class="form-control" name="landPostNo" value="${pvo.landPostNo }" >
				</div>
				
				<div class="col-6">
					<label for="address" class="form-label">도로명 주소</label>
					<input type="text" class="form-control" name="loadAddrBase" value="${pvo.loadAddrBase }" placeholder="도로명주소">
					<div class="invalid-feedback">Please enter your shipping address.</div>
				</div>
				
				<div class="col-6">
					<label for="address2" class="form-label">상세 주소</label>
					<input type="text" class="form-control" name="loadAddrDtl" value="${pvo.loadAddrDtl }" placeholder="도로명주소 상세">
				</div>
				
				<div class="col-2">
					<label for="address2" class="form-label">생년월일</label>
					<input type="date" class="form-control" name="usrBirth" value="${pvo.usrBirth }" placeholder="생년월일">
				</div>
			<hr class="my-4">
			<button class="w-100 btn btn-primary btn-lg" type="submit">수정하기</button>
		</form>
	</div>
</div>


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