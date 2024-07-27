<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header data-bs-theme="light">
	<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"><img src="/img/cltsh/logo_01.png"/></a>
			<div class="top_btn" style="color: white;">
				<c:choose>
					<c:when test="${not empty sessionScope.loginInfo }">
						<span>${sessionScope.loginInfo.usrId }님 환영합니다.</span>
						<input type="button" class="w70" id="btn_edit" onclick="fn_user_edit('${sessionScope.loginInfo.usrBaseSeq}')" value="수정">
						<input type="button" class="w70" id="logout_btn" onclick="location.href='/cltsh/user/userLogout.do'" value="로그아웃">
						<a href="/cltsh/order/orderCartList.do"><i class="fa-solid fa-cart-shopping"></i></a>
						<a href="/cltsh/mypage/mypage.do"><i class="fa-solid fa-user-large"></i></a>
					</c:when>
					<c:otherwise>
						<div>
							<input type="button" class="w70" onclick="location.href='/cltsh/user/userLogin.do'" value="로그인"/>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
</header>

<script>
function fn_user_edit(usrBaseSeq){
	const form = document.createElement('form');
	form.method = 'post';
	form.action = '/cltsh/user/userEdit.do';

	const hiddenField = document.createElement('input');
	hiddenField.type = 'hidden';
	hiddenField.name = 'usrBaseSeq';
	hiddenField.value = usrBaseSeq;
	
	form.appendChild(hiddenField);
	
	document.body.appendChild(form);
	
	form.submit();
}
</script>