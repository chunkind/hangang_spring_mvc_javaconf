<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar fixed-bottom navbar-expand-sm navbar-light bg-light">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse" style="justify-content: center;">
			<ul class="navbar-nav" style="justify-content: center; align-items: center;">
				<li class="nav-item"><a class="nav-link" href="/cltsh/main/mainDrssList.do">리뷰</a></li>
				<li class="nav-item">
					<c:choose>
						<c:when test="${not empty sessionScope.loginInfo }">
							<li class="nav-item"><a class="nav-link" href="/cltsh/mypage/mypage.do">마이페이지</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/cltsh/user/userLogin.do">마이페이지</a></li>
						</c:otherwise>
					</c:choose></li>
				<li class="nav-item">
					<a class="nav-link" href="/"><i class="fa-solid fa-house" style="font-size: 35px; margin: 5px;"></i></a>
				</li>

				<li class="nav-item">
					<a href="/cltsh/order/orderCartList.do"><i class="fa-solid fa-cart-shopping"></i></a>
				</li>
				<li class="nav-item dropup"><a class="nav-link dropdown-toggle" href="/cltsh/main/mainCataList.do" data-bs-toggle="dropdown" aria-expanded="false">카테고리</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="/cltsh/main/mainCataList.do?searchType=all">전체</a> </li>
						<c:forEach items="${oneDepthCateList}" var="obj">
							<li><a class="dropdown-item" href="/cltsh/main/mainCataList.do?searchCatgryCd=${obj.catgryCd}">${obj.catgryNm}</a></li>
						</c:forEach>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<!-- FOOTER -->
<footer class="container mt-10" style="margin-top: 20px; padding-bottom: 14px;">
	<p class="float-end"><a href="#">Back to top</a></p>
	<p>&copy; 2017–2023 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>