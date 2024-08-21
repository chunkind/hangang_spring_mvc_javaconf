<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" data-bs-theme="auto">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.118.2">
	<title><tiles:insertAttribute name="title" /></title>
	<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/carousel/">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link rel="stylesheet" href="/assets/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/carousel.css">
	<link rel="stylesheet" href="/css/app.css">
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	<script type="text/javascript" src="https://kit.fontawesome.com/c505bb0d5d.js" crossorigin="anonymous"></script>
	<script src="/assets/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/js/cltsh/common.js"></script>
</body>
<c:if test="${not empty sessionScope.message}">
  <script type="text/javascript">
    alert("${sessionScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>
<c:if test="${not empty requestScope.message}">
  <script type="text/javascript">
    alert("${requestScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>
</html>