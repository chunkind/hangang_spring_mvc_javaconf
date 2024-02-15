<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>

<h2>상품 옵션 관리</h2>
<form method="post" action="/cltsh/adm/cate/admCateRegisterAct.do" onsubmit="return fn_submitCheck()">
<div class="items_header">
	<span>분류 코드</span>
	<span>분류 명</span>
	<span>비고 내용</span>
	<span>사용 여부</span>
	<span>삭제</span>
</div>
<div class="items">
			<c:forEach items="${list }" var="obj" varStatus="countObj">
				<c:if test="${obj.classLvlCd eq '1'}">
					<div onclick="fn_a('${obj.catgryCd}')">
						<ul>
							<li><input type="text" name="upCatgryCd${countObj.index }" value="${obj.catgryCd}" /></li>
							<li><input type="text" name="upCatgryNm${countObj.index }" value="${obj.catgryNm}" /></li>
							<li><input type="text" name="upNoteCont${countObj.index }" value="${obj.noteCont}" /></li>
							<input type="hidden" name="upCateType${countObj.index }" value="'cateUpdate'"/>
							<input type="hidden" name="upGoodsCataSeq${countObj.index }" value="${obj.goodsCataSeq}"/>
							<%-- <li><select name="upUseYn${countObj.index }">
									<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
									<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option></select></li> --%>
							<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this , '${obj.goodsCataSeq}' , '${obj.classLvlCd}');" /></li>
						</ul>
					</div>
			    </c:if>
			</c:forEach>
		</div>
		<div class="items">
			<span class="plus" id="upper_btn_add">+</span>
		</div>

<div>
	<input type="submit" value="저장"/>
</div>

</form>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>