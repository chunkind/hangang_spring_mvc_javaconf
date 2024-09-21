<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
	<div class="offcanvas-md offcanvas-end bg-body-tertiary"
		tabindex="-1" id="sidebarMenu" aria-labelledby="sidebarMenuLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="sidebarMenuLabel">Company name</h5>
			<button type="button" class="btn-close"
				data-bs-dismiss="offcanvas" data-bs-target="#sidebarMenu"
				aria-label="Close"></button>
		</div>
		<div
			class="offcanvas-body d-md-flex flex-column p-0 pt-lg-3 overflow-y-auto">
			<ul class="nav flex-column">
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2 active"
					aria-current="page" href="/cltsh/adm/entr/admEntrList.do"> <svg class="bi">
						<use xlink:href="#house-fill" /></svg> 업체 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/code/admCodeList.do"> <svg class="bi">
						<use xlink:href="#file-earmark" /></svg> 공통코드 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/cate/admCateList.do"> <svg class="bi">
						<use xlink:href="#cart" /></svg> 카테고리 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/opts/admOptsList.do"> <svg class="bi">
						<use xlink:href="#people" /></svg> 상품 옵션 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/goods/admGoodsList.do"> <svg class="bi">
						<use xlink:href="#graph-up" /></svg> 상품 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/sales/admSalesList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 상품 판매 게시글 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/order/admOrderList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 주문 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/user/admUserList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 회원 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/event/admEventList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 이벤트 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/stats/admStatsSales.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 매출 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/qna/admQnaList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 1:1 문의 관리
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2"
					href="/cltsh/adm/cpn/admCpnList.do"> <svg class="bi">
						<use xlink:href="#puzzle" /></svg> 쿠폰 관리
				</a></li>
			</ul>

			<hr class="my-3">

			<ul class="nav flex-column mb-auto">
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2" href="#"> <svg
							class="bi">
							<use xlink:href="#gear-wide-connected" /></svg> Settings
				</a></li>
				<li class="nav-item"><a
					class="nav-link d-flex align-items-center gap-2" href="#"> <svg
							class="bi">
							<use xlink:href="#door-closed" /></svg> Sign out
				</a></li>
			</ul>
		</div>
	</div>
</div>