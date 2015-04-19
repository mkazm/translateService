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
				<c:if test="${not empty error}">
					<div class="alert alert-danger" style="text-align: center;"
						role="alert">${error}</div>
				</c:if>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${dic.ADD_ORDER}</h3>
					</div>
					<div class="panel-body">
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
									<label class="col-sm-2 control-label">${dic.SELECT_FILE}</label>
									<div class="col-sm-10">
										 <input type="file" title="cos" name="file">
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

