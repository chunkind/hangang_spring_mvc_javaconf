<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height">
	<title><tiles:insertAttribute name="title" /></title>
	<link type="text/css" rel="stylesheet" href="/css/reset.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/default.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/common.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/buttons.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/scale.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/container.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/color.css?${version}">
	<link type="text/css" rel="stylesheet" href="/css/app.css?${version}">
</head>
<body>
	<div class="app bc_white">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
	<script type="text/javascript" src="https://kit.fontawesome.com/c505bb0d5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/js/app.js?${version}" ></script>
</body>
</html>