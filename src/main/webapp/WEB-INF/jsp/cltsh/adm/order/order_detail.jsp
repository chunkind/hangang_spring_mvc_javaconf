<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>주문 관리</h2>
<div class="data_list">
	<form action="/cltsh/adm/order/admOrdStateChange.do" method="post" enctype="multipart/form-data" onsubmit="return fn_order_edit()">
		<input type="hidden" name="ordNo" value="${ordVo.ordNo }" />
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
				<th><div>운송장 번호</div></th>
				<td><c:choose>
						<c:when test="${ordVo.billNum == 0}">
							<input type="text" name="billNum" maxlength="14" placeholder="운송장 번호를 입력해주세요." value="">
	            		</c:when>
						<c:otherwise>
							<input type="text" name="billNum" maxlength="14" value="${ordVo.billNum}">
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th><div>주문일</div></th>
				<td>${ordVo.ordDate}</td>
				<th><div>주문 상태</div></th>
				<td><select name="ordStat" id="">
						<c:forEach items="${ordStatList}" var="obj">
							<c:choose>
								<c:when test="${obj.codeVal eq ordVo.ordStat}">
									<option value="${obj.codeVal}" selected>${obj.codeNm}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.codeVal}">${obj.codeNm}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
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
		<div class="btn_area">
		    <input type="button" value="목록" onclick="location.href='/cltsh/adm/order/admOrderList.do'"/>
		    <input type="submit" value="저장"/>
	    </div>
	</form>
</div>

<script>
//저장
function fn_order_edit(){
	if(confirm('주문을 저장 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}
</script>

<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>