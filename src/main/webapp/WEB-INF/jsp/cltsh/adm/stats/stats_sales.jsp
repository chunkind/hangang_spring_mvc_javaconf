<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<%--<link href="/cltsh/css/sales.css" rel="stylesheet">--%>
<h2>매출현황</h2>
<div class="data_list">
    <table style="border-top: 1px solid black;">
        <tr>
            <th rowspan="2">입금대기</th>
            <td>3건</td>
            <th rowspan="2">입금완료</th>
            <td>1건</td>
            <th rowspan="4" colspan="2">주문처리 완료<br><br>${detailOrderCount}건</th>
            <td rowspan="4"><fmt:formatNumber value="${payMnyResult}" pattern="#,###" />원</td>
            <th>취소요청</th>
            <th>교환요청</th>
            <th>반품요청</th>
        </tr>
        <tr>
            <td>51,600원</td>
            <td>12,900원</td>
            <td>1건</td>
            <td>2건</td>
            <td>1건</td>
        </tr>
        <tr>
            <th rowspan="2">배송중</th>
            <td>87건</td>
            <th rowspan="2">배송완료</th>
            <td>386건</td>
            <th>취소완료</th>
            <th>교환접수</th>
            <th>반품접수</th>
        </tr>
        <tr>
            <td>797,800원</td>
            <td>2,991,500원</td>
            <td>0건</td>
            <td>0건</td>
            <td>0건</td>
        </tr>
    </table>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>