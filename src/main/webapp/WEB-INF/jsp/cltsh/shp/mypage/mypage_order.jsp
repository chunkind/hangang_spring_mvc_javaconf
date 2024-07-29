<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${mypgList }" var="obj">
	<div class="container marketing">
		<div class="low">
			<div class="col">
				<div class="card">
					<div class="row g-0">
						<div class="col-md-4">
							<img class="bd-placeholder-img card-img-top" width="100%" height="100%" src="${obj.imgPath}${obj.imgNm}" onclick="location.href='/cltsh/mypage/mypageDetail.do?ordNo=${obj.ordNo}'" style="cursor: pointer;">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">${obj.codeNm}</h5>
								<h5 class="card-title">${obj.bulTitNm}</h5>
								<small class="text-body-secondary text-end w-100">${String.format("%,d", obj.payMny)}원</small>
								<c:if test="${obj.saleBoardRpySeq eq 0}">
									<div class="d-flex justify-content-center align-items-center mt-2">
										<input type="button" class="btn btn-primary" style="background-color: white; color: black; border: 1px solid black;"
										onclick="location.href='/cltsh/dress/dressRegister.do?ordNo=${obj.ordNo}'" value="리뷰 쓰기" />
									</div>
								</c:if>
								<p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
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