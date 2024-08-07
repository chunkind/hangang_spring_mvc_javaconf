<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container item_list_area mb-4">
	<div class="text-center my-4">
		<h1 class="display-4">문의</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead class="thead-light">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">구분</th>
					<th scope="col">제목</th>
					<th scope="col">상태</th>
					<th scope="col">등록일</th>
					<th scope="col">작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty qnaList}">
					<tr>
						<td class="nodata" colspan="6">데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${qnaList}" var="obj">
					<c:choose>
						<c:when test="${obj.passYn eq 'Y'}">
							<tr>
								<td>${obj.qnaBoardSeq}</td>
								<td>${obj.qnaTp}</td>
								<td>
									<c:choose>
										<c:when test="${obj.rgstId eq loginInfo.usrId}">
											<i class="fas fa-lock"></i>
											<a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}" class="text-decoration-none">${obj.titNm}</a>
										</c:when>
										<c:otherwise>
											<i class="fas fa-lock"></i>
											<a href="javascript:void(0);" onclick="showAlert();" class="text-decoration-none">${obj.titNm}</a>
										</c:otherwise>
									</c:choose>
								</td>
								<td>${obj.ansrStat}</td>
								<td>${obj.rgstDate}</td>
								<td>${obj.rgstId}</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td>${obj.qnaBoardSeq}</td>
								<td>${obj.qnaTp}</td>
								<td><a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}" class="text-decoration-none">${obj.titNm}</a></td>
								<td>${obj.ansrStat}</td>
								<td>${obj.rgstDate}</td>
								<td>${obj.rgstId}</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>
	</div>
	${paging}
</div>
