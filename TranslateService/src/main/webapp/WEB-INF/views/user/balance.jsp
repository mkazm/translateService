<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
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
									<th>${dic.DATE}</th>
									<th>${dic.OPERATION}</th>
									<th>${dic.BALANCE_LIST}</th>
								</tr>
							</thead>
							<c:set var="count" value="0" scope="page" />
							<c:forEach var="b" items="${balanceList}">
								<c:set var="count" value="${count + 1}" scope="page" />
								<tr>
									<td>${count}</td>
									<td><joda:format value="${b.dateStamp}" style="SM" /></td>
									<td>${b.operation}</td>
									<td>${b.balance}</td>
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

