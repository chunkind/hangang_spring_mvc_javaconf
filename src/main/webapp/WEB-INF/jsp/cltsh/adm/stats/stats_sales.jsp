<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>매출현황</h2>
	<div class="table-responsive">
		<table class="table table-striped table-hover" style="border-top: 1px solid black;">
			<tr>
				<th class="text-center align-middle" rowspan="2">입금대기</th>
				<td class="text-center">3건</td>
				<th class="text-center align-middle" rowspan="2">입금완료</th>
				<td class="text-center">1건</td>
				<th class="text-center align-middle" rowspan="4" colspan="2">주문처리 완료<br><br>${detailOrderCount}건</th>
				<td class="text-center align-middle" rowspan="4">${String.format("%,d", payMnyResult)}원</td>
				<th class="text-center">취소요청</th>
				<th class="text-center">교환요청</th>
				<th class="text-center">반품요청</th>
			</tr>
			<tr>
				<td class="text-center">51,600원</td>
				<td class="text-center">12,900원</td>
				<td class="text-center">1건</td>
				<td class="text-center">2건</td>
				<td class="text-center">1건</td>
			</tr>
			<tr>
				<th class="text-center align-middle" rowspan="2">배송중</th>
				<td class="text-center">87건</td>
				<th class="text-center align-middle" rowspan="2">배송완료</th>
				<td class="text-center">386건</td>
				<th class="text-center">취소완료</th>
				<th class="text-center">교환접수</th>
				<th class="text-center">반품접수</th>
			</tr>
			<tr>
				<td class="text-center">797,800원</td>
				<td class="text-center">2,991,500원</td>
				<td class="text-center">0건</td>
				<td class="text-center">0건</td>
				<td class="text-center">0건</td>
			</tr>
		</table>
	</div>
</div>
