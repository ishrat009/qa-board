<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />
<div class="col-md-9">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Edit Player</h3>
		</div>

		<form:form class="form-horizontal"
			action="${pageContext.request.contextPath }/player/edit"
			modelAttribute="player">
			<form:input path="id" value="${player.id}" hidden="hidden" />

			<div class="card-body">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Team</label>
					<div class="col-sm-10">
						<form:select class="form-control" path="teamId">
							<form:options items="${team_list}" itemLabel="name"
								itemValue="id"></form:options>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Name</label>
					<div class="col-sm-10">
						<form:input class="form-control" path="name"
							value="${player.name}"></form:input>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Age</label>
					<div class="col-sm-10">
						<form:input class="form-control" path="name" value="${player.age}"></form:input>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Date Of Birth</label>
					<div class="col-sm-10">
						<form:input class="form-control" path="name" value="${player.dob}"></form:input>
					</div>
				</div>
				<br> <input type="submit" class="btn btn-primary" name="submit"
					value="Edit"></div>
		</form:form>
</div>
</div>
</div>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
		</body>
		</html>