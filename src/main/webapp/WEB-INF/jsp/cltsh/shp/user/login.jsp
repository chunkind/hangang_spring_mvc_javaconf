<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<script src="/assets/js/color-modes.js"></script>
<title>로그인</title>
<link href="/css/login.css" rel="stylesheet">
</head>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important;
}
</style>

<c:if test="${not empty sessionScope.message}">
  <script type="text/javascript">
    alert("${sessionScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>
<c:if test="${not empty requestScope.message}">
  <script type="text/javascript">
    alert("${requestScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>

<!-- <header id="header">
  <div class="logo">
    <a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a>
  </div>
</header> -->

<body class="d-flex align-items-center py-4 bg-body-tertiary">
	<main class="form-signin w-100 m-auto">
	<form id="frm" action="/cltsh/user/userLoginAct.do" method="post">
		<div class="logo">
			<a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a>
		</div>

		<div class="form-floating">
			<input type="text" class="form-control" name="usrId" placeholder="name@example.com"> <label for="username">아이디</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" name="passWd" placeholder="Password"> <label for="password">비밀번호</label>
		</div>

		<div class="form-check text-start my-3">
			<input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
			<label class="form-check-label" for="flexCheckDefault"> 아이디 저장 </label>
			<a href="/cltsh/user/userJoin.do"> 회원가입</a>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
	</form>
	</main>
	<script src="${pageContext.request.contextPath}/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>