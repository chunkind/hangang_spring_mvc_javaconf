<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="bg-light py-4">
	<div class="container text-center">
		<h3 class="display-6">마이 페이지</h3>
	</div>
</section>

<div class="container text-center">
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
				<input type="button" class="w70" onclick="location.href='/cltsh/user/userLogin.do'" value="로그인" />
			</div>
		</c:otherwise>
	</c:choose>
</div>

<div class="container mt-4">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="list-group">
				<a href="/cltsh/mypage/mypageOrder.do" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
			 		주문/배송조회
					<span class="badge bg-primary rounded-pill">&rarr;</span>
				</a>
				<a href="/cltsh/mypage/mypagePoint.do" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					포인트
					<span class="badge bg-primary rounded-pill">&rarr;</span>
				</a>
				<a href="/cltsh/mypage/mypageCoupon.do" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					쿠폰
					<span class="badge bg-primary rounded-pill">&rarr;</span>
				</a>
				<a href="/cltsh/main/mainQnaList.do" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					Q&A
					<span class="badge bg-primary rounded-pill">&rarr;</span>
				</a>
				<a href="/cltsh/mypage/mypageQna.do" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					내 문의
					<span class="badge bg-primary rounded-pill">&rarr;</span>
				</a>
			</div>
		</div>
	</div>
</div>
