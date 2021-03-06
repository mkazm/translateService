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
						<h3 class="panel-title">${dic.ORDER_LIST}</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>${dic.USERNAME}</th>
									<th>${dic.STATUS}</th>
									<th>${dic.DOCUMENT_LANGUAGE}</th>
									<th>${dic.TRANSLATION_LANGUAGE}</th>
									<th>${dic.DOCUMENT}</th>
									<th>${dic.TRANSLATION}</th>
									<th>${dic.EDIT}</th>
								</tr>
							</thead>
							<c:set var="count" value="0" scope="page" />
							<c:forEach var="o" items="${orderList}">
								<c:set var="count" value="${count + 1}" scope="page" />
								<tr>
									<td>${count}</td>
									<td>${o.client.username}</td>
									<td>${o.status}</td>
									<td>${o.documentLanguage}</td>
									<td>${o.translationLanguage}</td>
									<td><a href="<c:url value="${o.document.path}"/>"
										class="btn btn-default">${dic.FILE}</a></td>
									<c:if test="${empty o.translation.path}">
										<form class="form-horizontal" method="post"
											data-toggle="validator" id="add-order-form"
											enctype="multipart/form-data"
											action="<c:url value="/user/orderTranslateAction"/>">
											<td><input type="file" title="plik" name="file" required>
												<button type="submit" name="id" value="${o.id}"
													class="btn btn-success">${dic.ADD}</button></td>
										<td><a
											href="<c:url value="/user/cancelTranslateAction/${o.id}"/>"
											class="btn btn-default">${dic.CANCEL}</a></td>
										</form>
									</c:if>
									<c:if test="${not empty o.translation.path}">
										<td><a href="<c:url value="${o.translation.path}"/>"
											class="btn btn-default">${dic.FILE}</a></td>
									</c:if>
									<c:if test="${o.status == 'FINISHED'}">	
									<td><a
										href="<c:url value="/user/orderTranslateRemoveAction/${o.id}"/>"
										class="btn btn-default">${dic.DELETE}</a></td>
									</c:if>		
									<c:if test="${o.status == 'CLOSED'}">
										<td></td>
									</c:if>						
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->


	</tiles:putAttribute>
</tiles:insertDefinition>

