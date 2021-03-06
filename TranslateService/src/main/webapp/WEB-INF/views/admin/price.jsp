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
			<c:if test="${empty SPRING_SECURITY_LAST_EXCEPTION.message}">
				<c:if test="${not empty error}">
					<div class="alert alert-danger" style="text-align: center;"
						role="alert">${error}</div>
				</c:if>
				</c:if>
						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
			<div class="alert alert-warning" style="text-align: center;" role="alert">${dic.MSG_EMAIN_NOT_CONFIRMED}</div>
				</c:if>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${dic.PRICE}</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>									
									<th>${dic.DOCUMENT_LANGUAGE}</th>
									<th>${dic.TRANSLATION_LANGUAGE}</th>
									<th>${dic.DOCUMENT_TYPE}</th>
									<th>${dic.PRICE}</th>
									<th>${dic.DELETE}</th>
								</tr>
							</thead>
							<c:set var="count" value="0" scope="page" />
							<c:forEach var="p" items="${priceList}">
								<c:set var="count" value="${count + 1}" scope="page" />
								<tr>
									<td>${count}</td>
									<td>${p.documentLanguage}</td>
									<td>${p.translationLanguage}</td>
									<td>${p.documentType}</td>
									<td>${p.price}</td>
									<td><a
										href="<c:url value="/admin/priceRemove/${p.id}"/>"
										class="btn btn-default">${dic.DELETE}</a></td>
								</tr>
							</c:forEach>

							</tbody>
						</table>
						<form modelAttribute="price" class="form-horizontal" method="post"
							data-toggle="validator" id="add-order-form" enctype="multipart/form-data"
							action="<c:url value="/admin/priceAction"/>">
							<div class="form-group">
								<label class="col-sm-2 control-label">${dic.DOCUMENT_LANGUAGE}</label>
								<div class="col-sm-10">
									<select id="mainRole" name="documentLanguage">
										<option value="POLISH">POLISH</option>
										<option value="ENGLISH">ENGLISH</option>
										<option value="FRENCH">FRENCH</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">${dic.TRANSLATION_LANGUAGE}</label>
								<div class="col-sm-10">
									<select id="mainRole" name="translationLanguage">
										<option value="POLISH">POLISH</option>
										<option value="ENGLISH">ENGLISH</option>
										<option value="FRENCH">FRENCH</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">${dic.DOCUMENT_TYPE}</label>
								<div class="col-sm-10">
									<select id="mainRole" name="documentType">
										<option value="NORNAL">NORNAL</option>
										<option value="TECHNICAL">TECHNICAL</option>
									</select>
								</div>
							</div>	
							<div class="form-group">
								<label class="col-sm-2 control-label">${dic.PRICE}</label>
								<div class="col-sm-10">
								<input type="number" step="0.01" class="form-control" name="price"
										id="price" title="price"
										placeholder="${dic.PRICE}" value="" required>
								</div>
							</div>	
							<div class="form-actions pull-right">
								<button type="submit" class="btn btn-success">${dic.ADD}</button>
								<button type="reset" class="btn">${dic.CLEAN}</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->


	</tiles:putAttribute>
</tiles:insertDefinition>

