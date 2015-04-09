<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<ul class="nav navbar-nav navbar-left">
			
				<li><a class="navbar-brand" href="<c:url value="/"/>">
						TEST COLLECTION </a></li>
						
			</ul>
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="<c:url value="/list"/>">List</a></li>
						
			</ul>
		</div>
	</div>
</div>