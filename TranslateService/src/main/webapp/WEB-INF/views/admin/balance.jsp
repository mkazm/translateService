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
						<h3 class="panel-title">${dic.ACTIVATE}</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>${dic.USERNAME}</th>
									<th>${dic.ACCOUNT_TYPE}</th>
									<th>${dic.BALANCE}</th>
									<th>${dic.EDIT}</th>
								</tr>
							</thead>
							<c:set var="count" value="0" scope="page" />
							<c:forEach var="u" items="${userList}">
								<c:set var="count" value="${count + 1}" scope="page" />
								<tr>
									<td>${count}</td>
									<td>${u.username}</td>
									<td>${u.mainRole}</td>
									<form method="post" data-toggle="validator" id="add-order-form"
										enctype="multipart/form-data"
										action="<c:url value="/admin/balanceAction"/>">
									<td><input type="number" step="0.01" class="form-control" name="balance"
										id="balance" title="balance"
										placeholder="${dic.BALANCE}" value="${u.balance}" required></td>
									<td><button type="submit" name="id" value="${u.id}" class="btn btn-success">${dic.ADD}</button></td>
									</form>
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

