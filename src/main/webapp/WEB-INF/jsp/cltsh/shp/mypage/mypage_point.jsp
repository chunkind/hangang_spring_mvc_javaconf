<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="/css/cltsh/mypage_point.css" rel="stylesheet">

<article id="content">
    <div class="icon">
        <i class="fa-solid fa-truck"></i>
        <i class="fa-solid fa-p"></i>
        <i class="fa-solid fa-money-check-dollar"></i>
        <i class="fa-solid fa-comments"></i>
    </div>
    <div class="icon_btn">
        <a href="/cltsh/mypage/mypage.do" class="a">주문/배송조회 ></a>
        <a href="/cltsh/mypage/mypagePoint.do" class="b">포인트 ></a>
        <a href="/cltsh/mypage/mypageCoupon.do" class="c">쿠폰 ></a>
        <a href="/cltsh/mypage/mypageQna.do" class="d">Q&A</a>
    </div>
</article>
<article id="point">
    <div class="top_point">
        <strong>보유 포인트</strong>
        <strong class="color_point">392원</strong>
        <span>당월 소멸 예정 포인트 0원</span>
    </div>
    <h2>포인트 내역</h2>
    <div class="point_details">
        <span>적용일자</span>
        <span>포인트 내역</span>
        <span>포인트</span>
    </div>
    <div class="point_details2">
        <span>포인트 적립/차감 내역이 존재하지 않습니다.</span>
    </div>
</article>