<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main class="container">
	<div class="row justify-content-center" style="margin-top: 100px;">
		<div class="col-12 col-md-8 col-lg-6 col-xl-4">
			<div class="p-4 p-md-5 mb-4 product_menu">
				<form id="frm" action="/cltsh/user/userLoginAct.do" method="post">
					<div class="form-floating my-2">
						<input type="text" class="form-control" name="usrId" placeholder="name@example.com">
						<label for="username">아이디</label>
					</div>
					<div class="form-floating my-2">
						<input type="password" class="form-control" name="passWd" placeholder="Password">
						<label for="password">비밀번호</label>
					</div>
					<div class="form-check text-start my-3 d-flex align-items-center">
						<input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
						<label class="form-check-label" for="flexCheckDefault"> 아이디 저장 </label>
						<a href="/cltsh/user/userJoin.do" class="ms-auto me-4"> 회원가입</a>
					</div>
					<button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
				</form>
			</div>
		</div>
	</div>
</main>