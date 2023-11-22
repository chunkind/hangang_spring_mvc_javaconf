<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>생성된 쿠폰</h2>
<div class="data_list">
	<table>
        <tr>
            <th>쿠폰이름</th>
            <th>할인율</th>
            <th>사용시간</th>
            <th>개수</th>
        </tr>
        <tr>
            <td>쿠폰1</td>
            <td>1000원</td>
            <td>2022.11.09까지</td>
            <td>2</td>
        </tr>
        <tr>
            <td>쿠폰2</td>
            <td>10%</td>
            <td>2023.01.01까지</td>
            <td>1</td>
        </tr>
    </table>
</div>

<section id="coupon_making">
    <h2>쿠폰 제작</h2>
    <div>이름 <input class="cou_name" type="text"></div>
    <div class="op">할인율 <input class="cou_discount" type="text">
        <select>
            <option>원</option>
            <option>%</option>
        </select>
    </div>
    <div>사용기간 <input class="cou_time" type="text"></div>
    <div>개수 <input class="cou_count" type="text"></div>
    <button class="coupon_btn">등록하기</button>
</section>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>