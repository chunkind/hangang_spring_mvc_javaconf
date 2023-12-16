<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header">
	<!-- <div class="logo"><a href="/cltsh/DispatcherServlet?command=main_home_list"><bold style="font-size: 25px; margin-left: 20px;">CLT</bold> shop</a></div> -->
	<div class="logo"><a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a></div>
	<div class="top_btn">
		<c:choose>
			<c:when test="${not empty sessionScope.loginInfo }">
				<span>${sessionScope.loginInfo.usrId }님 환영합니다.</span>
				<input type="button" class="w70" id="btn_edit" onclick="fn_user_edit('${sessionScope.loginInfo.usrBaseSeq}')" value="수정">
				<input type="button" class="w70" id="logout_btn" onclick="location.href='/cltsh/user/userLogout.do'" value="로그아웃">
<%--				<input type="text" />--%>
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
</header>
<section id="main_benner">
	<ul class="menu">
		<a href="/cltsh/main.do"><li>홈</li></a>
		<a href="/cltsh/main/mainCataList.do" class="menu_category_item_main"><li>카테고리</li></a>
		<div class="menu_category">
			<ul>
				<li class="menu_category_item"><a href="/cltsh/main/mainCataList.do?searchType=all"><div>카테고리</div></a></li>
				<c:forEach items="${oneDepthCateList}" var="obj">
					<li class="menu_category_item"><a href="/cltsh/main/mainCataList.do?searchCatgryCd=${obj.catgryCd}"><div>${obj.catgryNm}</div></a></li>
				</c:forEach>
			</ul>
		</div>
		<a href="/cltsh/main/mainDrssList.do"><li>드레스룸</li></a>
		<a href="/cltsh/main/mainQnaList.do"><li>1:1문의</li></a>
	</ul>
</section>
<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">alert("${sessionScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>
<!-- menu end -->
<script>
//메인 화면 -------------------------------------------------------
//메인 화면 카테고리 마우스 오버 시 하위 메뉴 노출
const categoryMenuMain = document.querySelector(".menu_category_item_main");
const categoryMenu = document.querySelector(".menu_category");
categoryMenuMain.addEventListener("mouseenter", (event) => {
	categoryMenu.classList.add("visible");
});
categoryMenu.addEventListener("mouseleave", (event) => {
	categoryMenu.classList.remove("visible");
});

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