<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

	<div class="container">

		<div class="starter-template">
		<c:if test="${not empty error}">
			<div class="alert alert-danger" style="text-align: center;" role="alert">${error}</div>
				</c:if>				
				<div class="panel panel-default">
					<div class="panel-heading">
					<h3 class="panel-title">
							${dic.REGISTER}</h3>
							</div>
							<div class="panel-body">
							<form modelAttribute="user" class="form-horizontal" method="post" data-toggle="validator"
								id="add-user-form" action="<c:url value="/register/addUser"/>" >
								<div class="form-group">
									<label class="col-sm-2 control-label">${dic.USERNAME}</label>
									<div class="col-sm-10">
										<input type="login" pattern="^([_A-z0-9]){3,}$" data-minlength="3" data-error="Błędny format" maxlength="13" class="form-control" name="username" id="username"
											title="username" placeholder="${dic.USERNAME}" value="" required> <span
											class="help-inline"><form:errors path="login" /></span>
											<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">${dic.EMAIL}</label>
									<div class="col-sm-10">
										<input type="email" class="form-control" name="email" id="email" data-error="Email nieprawidłowy."
											title="email" placeholder="${dic.EMAIL}" value="" required> <span class="help-inline"><form:errors
												path="email" /></span>
												<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">${dic.PASSWORD}</label>
									<div class="col-sm-10">
										<input type="password" data-minlength="3" data-error="Minimalna długość znaków: 3" class="form-control" name="password" id="password"
											title="password" placeholder="${dic.PASSWORD}" value="" required> <span class="help-inline"><form:errors
												path="password" /></span>
												<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">${dic.PASSWORD_REPEAT}</label>
									<div class="col-sm-10">
										<input type="password" data-minlength="3" data-error="Minimalna długość znaków: 3" data-match-error="Podne hasła nie są identyczne." data-match="#password" class="form-control" name="passwordConf" id="passwordConf"
											title="password" placeholder="${dic.PASSWORD_REPEAT}" value="" required> <span class="help-inline"><form:errors
												path="password" /></span>
												<div class="help-block with-errors"></div>
									</div>
								</div>								
								<div class="form-actions pull-right">
									<button type="submit" class="btn btn-success">${dic.REGISTER}</button>
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

