<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<%--	<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Open+Sans:wght@400;600;700&family=Roboto:wght@100&family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
	<link href="/css/cltsh/common.css" rel="stylesheet">
	<link href="/css/cltsh/main.css" rel="stylesheet">
	<link href="/css/cltsh/login.css" rel="stylesheet">
	<link href="/css/cltsh/category.css" rel="stylesheet">
	<!-- <link href="/css/cltsh/one_qna.css" rel="stylesheet">
	<link href="/css/cltsh/list.css" rel="stylesheet">
	<link href="/css/cltsh/cart.css" rel="stylesheet">
	<link href="/css/cltsh/dressRoom.css" rel="stylesheet"> -->
	<title>쇼핑몰</title>
</head>
<body>
	<%-- <tiles:insertAttribute name="header" /> --%>
	<tiles:insertAttribute name="body" />
	<%-- <tiles:insertAttribute name="footer" /> --%>
	<!-- include libraries(jQuery, bootstrap) -->
	<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<!-- include summernote css/js-->
<%--	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">--%>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	<script src="https://kit.fontawesome.com/db1622cae4.js" crossorigin="anonymous"></script>
	<script src="/js/cltsh/common.js" defer></script>
</body>
</html>