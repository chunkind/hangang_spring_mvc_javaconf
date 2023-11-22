<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>주문 관리</h2>
<div class="data_list">
	<table>
		<colgroup>
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="30%" />
		</colgroup>
		<tr>
			<th><div>주문 번호</div></th>
			<td>${ordVo.ordNo}</td>
			<th><div>업체 번호</div></th>
			<td>${ordVo.entrNo}</td>
		</tr>
		<tr>
			<th><div>주문일</div></th>
			<td>${ordVo.ordDate}</td>
			<th><div>주문 상태</div></th>
			<td>${ordVo.codeNm}</td>
		</tr>
		<tr>
			<th><div>결제 수단</div></th>
			<td>${ordVo.payWay}</td>
			<th><div>결제 금액</div></th>
			<td>${ordVo.payMny}원</td>
		</tr>
		<tr>
			<th><div>주문 상품</div></th>
			<td>${ordVo.goodsNm}</td>
			<th><div>수량</div></th>
			<td>${ordVo.goodsQty}개</td>
		</tr>
		<tr>
			<th><div>주문자</div></th>
			<td>${ordVo.ordrNm} 님</td>
			<th><div>주문자 아이디</div></th>
			<td>${ordVo.usrId}</td>
		</tr>
		<tr>
			<th><div>주문자 연락처</div></th>
			<td>${ordVo.ordrPhon}</td>
			<th><div>주문자 이메일</div></th>
			<td>${ordVo.ordrEmail}</td>
		</tr>
		<tr>
			<th><div>수취자</div></th>
			<td>${ordVo.acqrNm} 님</td>
			<th><div>수취자 연락처</div></th>
			<td>${ordVo.acqrPhon}</td>
		</tr>
		<tr>
			<th><div>주소</div></th>
			<td>${ordVo.acqrAddr}</td>
			<th><div>상세 주소</div></th>
			<td>${ordVo.acqrAddrDtl}</td>
		</tr>
		<tr>
			<th><div>요청 사항</div></th>
			<td>${ordVo.reqMemo}</td>
		</tr>
	</table>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>