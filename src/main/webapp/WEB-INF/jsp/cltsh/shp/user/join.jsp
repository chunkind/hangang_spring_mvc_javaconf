<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#frm{
	display: flex;
    flex-direction: column;
}
</style>

<%-- <c:if test="${sessionScope.message ne ''}"> 아래와 같다--%>
<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">alert("${sessionScope.message}");</script>
	<%-- <c:out scope="session" var="message" value="메세지가 들어갑니다."/> jsp에서 메세지 추가하고 싶을 떄 사용 --%>
	<c:remove var="message" scope="session"/>
</c:if>
<c:if test="${not empty requestScope.message}">
	<script type="text/javascript">alert("${requestScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>

<header id="header">
	<div class="logo"><a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a></div>
</header>
<section id="section" class="section">
	<div class="input_area">
	   <h1>회원가입</h1>
	   <div class="top">
		<form name="frm" id="frm" action="/cltsh/user/userJoinInsert.do" method="post" onsubmit="return checkForm()">
			<input type="text" name="usrId" placeholder="아이디 입력 ">
			<input type="button" id="ajaxBtn" value="중복 확인" />
			<input type="text" name="usrNm" placeholder="이름 입력 ">
			<input type="email" name="emailAddr" placeholder="이메일 입력 ">
			<input type="password" name="passWd" placeholder="비밀번호 입력 ">
			<input type="password" placeholder="비밀번호 재입력 ">
			<input type="tel" name="cellNo" placeholder="01012341234">
			<button id="c_btn">인증요청</button>
			<input type="text" name="landAddrBase" placeholder="지번 주소">
			<input type="text" name="landAddrDtl" placeholder="도로명 상세 주소">
			<input type="text" name="landPostNo" placeholder="우편주소">
			<input type="text" name="loadAddrBase" placeholder="도로명 주소">
			<input type="text" name="loadAddrDtl" placeholder="도로명 상세 주소">
			<label>생년월일</label>
			<input type="date" name="usrBirth" placeholder="생년월일">
			<input type="submit" value="가입하기"/>
		</form>
		</div>
	</div>
</section>
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