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
						<h3 class="panel-title">${dic.ADD_ORDER}</h3>
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
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<form modelAttribute="order" class="form-horizontal" method="post"
							data-toggle="validator" id="add-order-form" enctype="multipart/form-data"
							action="<c:url value="/user/orderAction"/>">
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
									<label class="col-sm-2 control-label">${dic.SELECT_FILE}</label>
									<div class="col-sm-10">
										 <input type="file" title="plik" name="file" required>
									</div>									
								</div>		
							<div class="form-actions pull-right">
								<button type="submit" class="btn btn-success">${dic.ADD_ORDER}</button>
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

