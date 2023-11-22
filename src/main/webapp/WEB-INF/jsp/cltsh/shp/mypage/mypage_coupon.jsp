<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="/cltsh/css/mypage_coupon.css" rel="stylesheet">

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
<article id="coupon">
    <h2>쿠폰 내역</h2>
    <div class="coupon_header">
        <span>쿠폰명</span>
        <span>사용혜택</span>
        <span>사용조건</span>
        <span>유효기간</span>
    </div>
    <div class="coupon_body">
        <span>사용 가능한 쿠폰이 없습니다.</span>
    </div>
    </table>
</article>