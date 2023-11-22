<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/cltsh/admin.css" rel="stylesheet">
<!-- adm header start -->
<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">alert("${sessionScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>
<header id="header">
    <div class="logo"><img src="/img/cltsh/logo_01.png" / width="80" height="40"></div>
</header>
<section class="admin_body">
	<%@ include file="/WEB-INF/jsp/cltsh/cmm/admLeftMenu.jsp" %>
	<div class="adm_content">
<!-- adm header end -->