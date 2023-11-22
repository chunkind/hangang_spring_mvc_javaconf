<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="product_order_delivery">
    <div>
        <h2>배송</h2>
        <div class="product_order_delivery_title">
            <h3>구매정보</h3>
        </div>
        <div class="product_order_number">
            <div>주문번호</div>
            <div>20200501-12345678</div>
        </div>
        <div class="product_order_detail">
            <div>주문상품</div>
            <div>상품1</div>
        </div>
        <div class="product_order_delivery_title">
            <h3>배송정보</h3>
        </div>
        <div class="product_delivery_detail">
            <div>택배사</div>
            <div>
                <select name="" id="">
                    <option value="">배송업체 선택</option>
                </select>
            </div>
        </div>
        <div class="product_delivery_number">
            <div>운송장번호</div>
            <div><input type="text"></div>
        </div>
        <div class="product_delivery_time">
            <div>배송시간</div>
            <div>
                <input type="text">
                <select name="" id="">
                    <option value="">17</option>
                    <option value="">40</option>
                </select>
            </div>
        </div>
        <div class="product_delivery_button_div">
            <button class="product_delivery_button">저장</button>
        </div>
    </div>
</section>