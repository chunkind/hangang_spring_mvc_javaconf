<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="/css/cltsh/mypage.css" rel="stylesheet">

<section class="title_area">
	<h3 class="title">마이 페이지</h3>
</section>

<div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 align-items-center justify-content-center">
	<div class="list-group list-group-checkable d-grid gap-2 border-0">
		<label class="list-group-item rounded-3 py-3" for="listGroupCheckableRadios2">
			<span class="d-block small opacity-50"><a href="/cltsh/mypage/mypageOrder.do">주문/배송조회</a></span>
		</label>
		<label class="list-group-item rounded-3 py-3" for="listGroupCheckableRadios1">
			<span class="d-block small opacity-50"><a href="/cltsh/mypage/mypagePoint.do">포인트</a></span>
		</label>
		<label class="list-group-item rounded-3 py-3" for="listGroupCheckableRadios3">
			<span class="d-block small opacity-50"><a href="/cltsh/mypage/mypageCoupon.do">쿠폰</a></span>
		</label>
		<label class="list-group-item rounded-3 py-3"vfor="listGroupCheckableRadios4">
			<span class="d-block small opacity-50"><a href="/cltsh/mypage/mypageQna.do">Q&A</a></span>
		</label>
	</div>
</div>