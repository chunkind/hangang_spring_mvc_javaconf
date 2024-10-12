<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${ordList }" var="obj">
	<div class="container marketing">
		<div class="low">
			<div class="col">
				<div class="card" style="max-width: 600px; margin: 0 auto; height: auto;">
					<div class="row g-0 align-items-center">
						<!-- 이미지 부분 -->
						<div class="col-md-4">
							<img class="bd-placeholder-img card-img-top" width="100%" height="auto" src="${obj.imgPath}${obj.imgNm}"
								onclick="location.href='/cltsh/mypage/mypageDetail.do?ordNo=${obj.ordNo}'"
								style="cursor: pointer; max-width: 100%; height: auto; margin-bottom: 0;">
						</div>
						
						<!-- 텍스트 부분 -->
						<div class="col-md-8" style="padding: 10px 15px;">
							<div class="card-body" style="padding: 0;">
								<h5 class="card-title" style="margin-bottom: 5px;">${obj.codeNm}</h5>
								<h5 class="card-title" style="margin-bottom: 5px;">${obj.bulTitNm}</h5>
								<small class="text-body-secondary">${String.format("%,d", obj.payMny)}원</small>

								<!-- 리뷰 쓰기 버튼 -->
								<c:if test="${obj.saleBoardRpySeq eq 0}">
									<div class="d-flex justify-content-center align-items-center mt-2">
										<input type="button" class="btn btn-primary"
											style="background-color: white; color: black; border: 1px solid black;"
											onclick="location.href='/cltsh/dress/dressRegister.do?ordNo=${obj.ordNo}'" value="리뷰 쓰기" />
									</div>
								</c:if>
								
								<!-- 주문 상세 -->
								<a class="card-text" href="/cltsh/mypage/mypageDetail.do?ordNo=${obj.ordNo}&ordClmNo=${obj.ordClmNo}" style="color: #22c55e; display: block;">
									<small class="text-body-secondary">주문 상세</small>
								</a>
								
								<c:choose>
									<c:when test="${obj.clmSctCd == '01' and obj.clmStatCd == '01'}">
										<a class="card-text" href="/cltsh/order/order_cancel.do?ordClmNo=${obj.ordClmNo}&ordClmDtlSn=${obj.ordClmDtlSn}" style="color: #22c55e; display: block;">
											<small class="text-body-secondary">주문 취소</small>
										</a>
									</c:when>
									
									<c:when test="${obj.clmSctCd == '02'}">
										<a class="card-text" href="/cltsh/order/order_cancel_ing.do?ordClmNo=${obj.ordClmNo}&ordClmDtlSn=${obj.ordClmDtlSn}" style="color: #22c55e; display: block;">
											<small class="text-body-secondary">주문 취소 확인</small>
										</a>
									</c:when>

									<c:otherwise>
										<a class="card-text" href="/cltsh/order/order_return.do?ordClmNo=${obj.ordClmNo}&ordClmDtlSn=${obj.ordClmDtlSn}" style="color: #22c55e; display: block;">
											<small class="text-body-secondary">반품 및 환불</small>
										</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr class="featurette-divider">
	</div>
</c:forEach>

<c:if test="${empty mypgList }">
	<tr>
		<td colspan="6"><div class="nodata">주문내역이 없습니다.</div></td>
	</tr>
</c:if>