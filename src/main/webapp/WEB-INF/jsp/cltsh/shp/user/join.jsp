<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#frm{
	display: flex;
	flex-direction: column;
}
</style>

<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">alert("${sessionScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>

<c:if test="${not empty requestScope.message}">
	<script type="text/javascript">alert("${requestScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>

<header id="header">
	<div class="logo"><a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a></div>
</header>
	
<div class="row g-5">
	<div class="col-md-7 col-lg-8">
		<h4 class="mb-3">회원가입</h4>
		<form class="needs-validation" name="frm" action="/cltsh/user/userJoinInsert.do" method="post" onsubmit="return checkForm()" novalidate>
			<input type="hidden" name="usrBaseSeq" value="${sessionScope.loginInfo.usrBaseSeq }">
			<div class="row g-3">
				<div class="col-sm-6">
					<label for="firstName" class="form-label">아이디</label>
					<input type="text" class="form-control" name="usrId" placeholder="아이디 입력 ">
					<input type="button" id="ajaxBtn" value="중복 확인" />
				</div>
				
				<div class="col-6">
					<label for="email" class="form-label">이름</label>
					<input type="text" class="form-control" name="usrNm" placeholder="이름 입력 ">
				</div>
				
				<div class="col-sm-6">
					<label for="lastName" class="form-label">비밀번호</label>
					<input type="password" class="form-control" name="passWd" placeholder="비밀번호 입력 ">
				</div>
				
				<div class="col-sm-6">
					<label for="lastName" class="form-label">비밀번호 확인</label>
					<input type="password" class="form-control" placeholder="비밀번호 재입력 ">
				</div>
				
				<div class="col-6">
					<label for="username" class="form-label">이메일</label>
					<div class="input-group has-validation">	
						<span class="input-group-text">@</span>
						<input type="email" class="form-control" name="emailAddr" placeholder="이메일 입력 ">
					</div>
				</div>

				<div class="col-6">
					<label for="address" class="form-label">핸드폰 번호</label>
					<input type="tel" class="form-control" name="cellNo" placeholder="ex) 01012341234">
					<button id="c_btn">인증요청</button>
					<div class="invalid-feedback">Please enter your shipping address.</div>
				</div>
				
				<div class="col-5">
					<label for="address" class="form-label">주소</label>
					<input type="text" class="form-control" name="landAddrBase" placeholder="지번 주소">
				</div>
				
				<div class="col-5">
					<label for="address2" class="form-label">상세 주소</label>
					<input type="text" class="form-control" name="landAddrDtl" placeholder="도로명 상세 주소">
				</div>
				
				<div class="col-2">
					<label for="address2" class="form-label">우편 번호</label>
					<input type="text" class="form-control" name="landPostNo" placeholder="우편주소">
				</div>
				
				<div class="col-6">
					<label for="address" class="form-label">도로명 주소</label>
					<input type="text" class="form-control" name="loadAddrBase" placeholder="도로명 주소">
				</div>
				
				<div class="col-6">
					<label for="address2" class="form-label">상세 주소</label>
					<input type="text" class="form-control" name="loadAddrDtl" placeholder="도로명 상세 주소">
				</div>
				
				<div class="col-2">
					<label for="address2" class="form-label">생년월일</label>
					<input type="date" class="form-control" name="usrBirth" placeholder="생년월일">
				</div>
			<hr class="my-4">
			<button class="w-100 btn btn-primary btn-lg" type="submit">회원가입</button>
		</form>
	</div>
</div>

<script>
(function(){document.getElementById("ajaxBtn").addEventListener('click', makeRequest);
	function makeRequest() {
		httpRequest = new XMLHttpRequest();
		
		if(!httpRequest) {
			alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			return false;
		}
		id = frm.id.value;
		httpRequest.onreadystatechange = alertContents;
		httpRequest.open('POST', "DispatcherServlet?command=user_id_check");
		/* httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); */
		httpRequest.setRequestHeader('Content-Type', 'application/json');
		httpRequest.send('usrId='+encodeURIComponent(id));
	}

	function alertContents() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var res = httpRequest.responseText;
				console.log('res:' + res);
				var rtnJson = JSON.parse(res);
				if(rtnJson.result == 'success'){
					alert("사용할수 있는 아이디 입니다.");
					isIdCheck = true;
				}else{
					alert("이미 사용중인 아이디 입니다.");
				}
			} else {
				alert('request에 뭔가 문제가 있어요.');
			}
		}
	}
})();
var isIdCheck = false;
var httpRequest;
var frm = document.frm;
var id = '';

function checkForm(){
	if(!isIdCheck){
		alert("아이디를 체크해 주세요.");
		return ture;
		/* return false; */
	}
}
</script>