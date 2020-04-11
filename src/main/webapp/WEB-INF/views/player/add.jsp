<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />
<div class="col-md-9">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Add New Player</h3>
		</div>

<form:form class="form-horizontal" action="${pageContext.request.contextPath }/player/add"
		modelAttribute="player">
<div class="card-body">
				<div class="form-group row">
			<label  class="col-sm-2 col-form-label">Team</label>
			<div class="col-sm-10"><form:select class="form-control" path="teamId">
				<form:options items="${team_list}" itemLabel="name"
					itemValue="id"></form:options>
			</form:select></div></div>
		<div class="form-group row">
					<label class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-10"><form:input class="form-control" path="name" /></div></div>
				
				<div class="form-group row">
			<label  class="col-sm-2 col-form-label">Role</label>
			<div class="col-sm-10"><form:select class="form-control" path="role">
				<form:options items="${role_list}"></form:options>
			</form:select></div></div>

		<div class="form-group row">
					<label class="col-sm-2 col-form-label">Age</label>
				<div class="col-sm-10">
			<form:input class="form-control" path="age"></form:input></div></div>
		
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Date Of Birth</label>
			
			<div class="col-sm-10">
			
			<form:input path="dob" type="text"  class="form-control datepicker" placeholder="DD/MM/YYYY" ></form:input>
		</div></div>
		<input type="submit" class="btn btn-primary" name="submit" value="Add"></div>
		
</form:form>
	</div>
</div>
</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />