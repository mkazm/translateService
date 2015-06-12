<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:useBean id="dic" class="com.kazm.translate.tools.Dictionary"
	scope="session" />


<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/"/>">Tłumaczenia</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="<c:url value="/admin/"/>">${dic.ADMIN}</a></li>
					</sec:authorize>
					<li><a href="<c:url value="/user/"/>">${dic.WELCOME}
							${pageContext.request.userPrincipal.name}</a></li>
					<li><a href="<c:url value="/j_spring_security_logout" />">${dic.LOGOUT}</a></li>
					<sec:authorize access="hasRole('ROLE_CLIENT')">
					<li><a href="<c:url value="/user/order"/>">${dic.ADD_ORDER}</a></li>
					<li><a href="<c:url value="/user/clientOrderList"/>">${dic.ORDER_LIST}</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_TRANSLATOR')">
						<li><a href="<c:url value="/user/orderList"/>">${dic.ORDER_LIST}</a></li>
						<li><a href="<c:url value="/user/translatingList"/>">${dic.TRANSLATING}</a></li>
					</sec:authorize>
					<li><a href="<c:url value="/user/balance"/>">${dic.BALANCE_LIST}</a></li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login"/>">${dic.LOGIN}</a></li>
					<li><a href="<c:url value="/register"/>">${dic.REGISTER}</a></li>
				</sec:authorize>				
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<c:if test="${not empty info}">
					<div class="alert alert-info" style="text-align: center;"
						role="alert">${info}</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert alert-danger" style="text-align: center;"
						role="alert">${error}</div>
				</c:if>
