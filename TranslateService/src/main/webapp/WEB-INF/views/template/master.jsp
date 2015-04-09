<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html data-ng-app="MyApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TEST-COLLECTION</title>
<meta http-equiv="Content-Language" content="pl"></meta>
<meta name="description" content="Tajne zgromadzenie polskich otaku ^_^"></meta>
<meta name="keywords" content="anime, manga, nowości, japonia, gry, cosplay, komiks"></meta>
<meta name="google-site-verification" content="xzYQ2550XH29y1FFJlRG4BcqONFw_Mt_T8S9LpBPREs" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/starter-template.css"
	rel="stylesheet" />
	<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/docs.min.css"
	rel="stylesheet" />
	<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/ladda-themeless.min.css"
	rel="stylesheet" />
	<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/angular-chart.css"
	rel="stylesheet" />
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	
	<script src="<%=request.getContextPath()%>/resources/js/spin.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/ladda.min.js"></script>
		
	
	<script src="<%=request.getContextPath()%>/resources/js/angular.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/angular-route.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/controllers/home.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/controllers/test.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/controllers/tests.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/Chart.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/spin.js"></script>
	
		<script src="<%=request.getContextPath()%>/resources/js/angular-chart.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/angular-spinner.js"></script>		
</head>
<body>
	<div id="wrap">
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
</body>
</html>