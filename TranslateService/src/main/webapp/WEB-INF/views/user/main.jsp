<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="container">
			<div class="starter-template">
			<div class="panel panel-default">
				<div class="panel-heading">
					${dic.USER_PAGE}
				</div>
				<div class="panel-body">
				<div class="media">
										<div class="media-body">
					<b>${dic.USERNAME}: </b>${user.username} <br>
					<b>${dic.EMAIL}: </b>${user.email} <br>
					<b>${dic.ACCOUNT_TYPE}: </b>${user.mainRole} <br>
					<%-- <b>Activated: </b>${user.activated} <br> --%>
					<a href="<c:url value="/user/editPassword"/>"><button class="btn btn-success">${dic.EDIT_PASSWORD}</button></a>
					<a href="<c:url value="/user/ref"/>"><button class="btn btn-success">${dic.REF}</button></a>
					<a href="<c:url value="/user/addAvatar"/>"><button class="btn btn-success">Avatar</button></a> 
					</div>
					</div>
				</div>
			</div>
			</div>
		</div>
		<!-- /.container -->


	</tiles:putAttribute>
</tiles:insertDefinition>

