<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.wrap {
	width: 490px;
	padding: 40px 20px 20px 20px;
	background-color: #f5f6f7;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 30px;
	box-sizing: border-box;
}

.title {
	margin: 0 auto;
	width: 240px;
	height: 44px;
	text-align: center;
	font-size: 25px;
	background-repeat: no-repeat;
	background-position: 0 0;
	background-size: 240px auto;
	margin-bottom: 20px;
}

.kakao {
	margin-top: 15px;
	height: 40px;
	border: solid 1px #FEE500;
	background: #FEE500;
	color: #3c1d1e;
	font-size: 18px;
	box-sizing: border-box;
	border-radius: 5px;
	cursor: pointer;
	width: 330px;
	display: flex;
}

.kakao_i {
	background: url(resources/icons/kakao.png) no-repeat;
	width: 40px;
	height: 100%;
	background-size: 90%;
	background-position: 50%;
	margin: 0 20px;
}

.kakao_txt {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 16px;
	padding-right: 60px;
}

a {
	text-decoration: none;
}
</style>

<%-- <c:if test="${sessionScope.message ne ''}"> 아래와 같다--%>
<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">
		alert("${sessionScope.message}");
	</script>
	<%-- <c:out scope="session" var="message" value="메세지가 들어갑니다."/> jsp에서 메세지 추가하고 싶을 떄 사용 --%>
	<c:remove var="message" scope="session" />
</c:if>
<c:if test="${not empty requestScope.message}">
	<script type="text/javascript">
		alert("${requestScope.message}");
	</script>
	<c:remove var="message" scope="session" />
</c:if>

<header id="header">
	<div class="logo">
		<a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a>
	</div>
</header>
<section id="section" class="section">
	<div class="input_area">
		<h1>로그인</h1>
		<div class="top">
			<form id="frm" action="/cltsh/user/userLoginAct.do" method="post">
				<input type="text" name="usrId" placeholder="아이디 입력 "><br />
				<input type="password" name="passWd" placeholder="비밀번호 입력 "><br />
				<input type="submit" value="로그인" />
			</form>
		</div>
		<div class="top_log">
			<pre> 아이디 찾기 |</pre>
			<pre> 비밀번호 찾기 |</pre>
			<pre>
				<a href="/cltsh/user/userJoin.do"> 회원가입</a>
			</pre>
		</div>
		<div class="wrap">
			<div class="title">로그인</div>
			<a class="kakao"
				href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=dcf3a1fafb07e171bfe0d06c72d2a2d3&redirect_uri=http://localhost:9999/cltsh/user/kakaoLogin.do">
				<!-- REST_API키 및 REDIRECT_URI는 본인걸로 수정하세요 -->
				<div class="kakao_i"></div>
				<div class="kakao_txt">카카오톡으로 간편로그인</div>
			</a>
		</div>
	</div>
</section>
