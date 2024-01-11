<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
	.item_list_area {
		padding: 10px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	.item_list_area table{
		width: 80%;
	}
	.item_list_area table th{
		text-align: center;
		padding-bottom: 10px;
	}
	.item_list_area table td{
		text-align: center;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	.btn_area{
		width: 80%;
	}
	.fa{
		
	}
</style>
<section class="title_area">
	<h3 class="title">1:1 문의</h3>
</section>
<section class="item_list_area">
	<table>
		<thead>
			<tr><th>번호</th><th>구분</th><th>제목</th><th>등록일</th><th>작성자</th><th>상태</th></tr>
		</thead>
		<tbody>
		
		<c:if test="${empty list }">
			<tr><td class="nodata" colspan="6">데이터가 없습니다.</td></tr>
		</c:if>

		<c:forEach items="${list}" var="obj">
			<c:choose>
				<c:when test="${obj.passYn eq 'Y'}"> <!-- 비밀글은 작성자만 조회할 수 있습니다. -->
					<tr>
						<td>${obj.qnaBoardSeq}</td>
						<td>${obj.qnaTp}</td>
						<td><c:choose>
								<c:when test="${obj.rgstId eq loginInfo.usrId}">
									<!-- 아이디가 같은 경우에는 링크 클릭 가능 -->
									<a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}">${obj.titNm}</a>
									<i class="fa-solid fa-lock"></i>
								</c:when>
								<c:otherwise>
									<!-- 아이디가 다른 경우에는 JavaScript 경고창 띄우기 -->
									<a href="javascript:void(0);" onclick="showAlert();">${obj.titNm}</a>
									<i class="fa-solid fa-lock"></i>
								</c:otherwise>
							</c:choose></td>
						<td>${obj.rgstDate}</td>
						<td>${obj.rgstId}</td>
						<td>${obj.ansrStat}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${obj.qnaBoardSeq}</td>
						<td>${obj.qnaTp}</td>
						<td><a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}">${obj.titNm}</a></td>
						<td>${obj.rgstDate}</td>
						<td>${obj.rgstId}</td>
						<!-- <td>처리일</td> -->
						<td>${obj.ansrStat}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		</tbody>
	</table>
	${paging}
	<div class="btn_area">
		<input type="button" class="w70" value="작성하기" onclick="location.href='/cltsh/qna/qnaInsert.do'" />
	</div>
</section>

<script>
	function showAlert() {
		alert('비밀글은 작성자만 조회할 수 있습니다.');
	}
</script>

<%@ include file="/WEB-INF/jsp/cltsh/cmm/auth.jsp" %>