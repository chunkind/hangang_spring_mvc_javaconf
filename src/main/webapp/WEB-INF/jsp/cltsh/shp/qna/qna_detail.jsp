<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<form name="frm" action="/cltsh/qna/qnaEdit.do" method="post">
		<input type="hidden" name="qnaBoardSeq" value="${pvo.qnaBoardSeq}" />
		<div class="card mb-4">
			<div class="card-header bg-info text-white">
				<h5 class="mb-0">문의 상세 정보</h5>
			</div>
			<div class="card-body">
				<table class="table table-bordered">
					<colgroup>
						<col style="width: 10%;">
						<col style="width: 40%;">
						<col style="width: 10%;">
						<col style="width: 40%;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row" class="bg-light">제목</th>
							<td>${pvo.titNm}</td>
							<th scope="row" class="bg-light">문의유형</th>
							<td>${pvo.qnaTp}</td>
						</tr>
						<tr>
							<th scope="row" class="bg-light">답변 상태</th>
							<td colspan="3">${pvo.ansrStat}</td>
						</tr>
						<tr>
							<th scope="row" colspan="4" class="bg-light">내용</th>
						</tr>
						<tr>
							<td colspan="4">${pvo.cont}</td>
						</tr>
						<c:if test="${pvo.ansrStat eq '답변 완료'}">
							<tr>
								<th scope="row" colspan="4" class="bg-light">답변</th>
							</tr>
							<tr>
								<td colspan="4">${pvo.answer}</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<div class="text-right">
					<a href="/cltsh/main/mainQnaList.do" class="btn btn-secondary">목록</a>
					<input type="submit" class="btn btn-primary" value="수정" />
				</div>
			</div>
		</div>
	</form>
</div>
