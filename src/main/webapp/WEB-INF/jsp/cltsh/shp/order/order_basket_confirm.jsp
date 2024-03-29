<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp"%>
<style>
table {
	width: 50%;
}

th {
	text-align: left;
}

td {
	text-align: left;
}

.item_list_area {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}
</style>
<section class="title_area">
	<h3 class="title">주문이 완료 되었습니다.</h3>
</section>
<section class="item_list_area">
	<table>
		<colgroup>
			<col width="50%" />
			<col width="50%" />
		</colgroup>
		<tr>
			<th>상품 명 :</th>
			<td><c:choose>
					<c:when test="${not empty orderDtlList}">
						<c:forEach items="${orderDtlList}" var="obj">
							${obj.goodsNm}<br />
						</c:forEach>
					</c:when>
					<c:when test="${not empty orderDtlOne}">
						${orderDtlOne.goodsNm}
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>결제 금액 :</th>
			<td>${String.format("%,d", orderOne.payMny)} 원</td>
		</tr>
		<tr>
			<th>배송지 :</th>
			<td>${orderOne.acqrAddr}(${orderOne.acqrAddrDtl})</td>
		</tr>
		<tr>
			<th>결제 수단 :</th>
			<td>${orderOne.payWay}</td>
		</tr>
		<%--        <tr>--%>
		<%--            <th>옵션정보 :</th>--%>
		<%--            <td></td>--%>
		<%--            <th></th>--%>
		<%--            <td></td>--%>
		<%--        </tr>--%>
	</table>
	<div class="btn_area">
		<button onclick="location.href='/cltsh/main.do'">확인</button>
	</div>
</section>

