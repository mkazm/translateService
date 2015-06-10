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
						<h3 class="panel-title">Zaloguj</h3>
					</div>
					<div class="panel-body">
						<form modelAttribute="user" class="form-horizontal" method="post"
							id="add-user-form" action="j_spring_security_check"
							data-toggle="validator">
							<div class="form-group">
								<label for="inputTitle" class="col-sm-2 control-label">Login</label>
								<div class="col-sm-10">
									<input type="text" pattern="^([_A-z0-9]){3,}$" data-minlength="3" data-error="Błędny format" maxlength="13" class="form-control" name="username"
										id="username" title="username" value=""
										placeholder="Login" required> <span
										class="help-inline"><form:errors path="firstName" /></span>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputTitle" class="col-sm-2 control-label">Hasło</label>
								<div class="col-sm-10">
									<input type="password" data-minlength="3" class="form-control"
										name="password" id="password" title="password" value=""
										placeholder="Hasło"
										data-error="Minimalna długość znaków: 6" required> <span
										class="help-inline"><form:errors path="password" /></span>
									<div class="help-block with-errors"></div>
								</div>
							</div>
							<div class="form-actions pull-right">
								<button type="submit" class="btn btn-success">Zaloguj</button>
								<button type="reset" class="btn">Wyczyść</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- /.container -->


	</tiles:putAttribute>
</tiles:insertDefinition>

