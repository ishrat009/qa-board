<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />
<div class="col-md-9">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Edit Country</h3>
		</div>

		<form:form class="form-horizontal" action="${pageContext.request.contextPath }/country/edit"
			modelAttribute="country"><form:input path="id" value="${id}" hidden="hidden"/>
			<div class="card-body">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Country Code: </label>
					<div class="col-sm-10"><form:input class="form-control" path="countryCode" value="${countryCode}"/></div></div>
					<div class="form-group row">
					<label class="col-sm-2 col-form-label">Country Name: </label>
					<div class="col-sm-10"><form:input class="form-control" path="countryName" value="${countryName}"/></div></div>
					<div class="card-footer"><input type="submit" class="btn btn-primary"
						name="submit" value="update"></div>
				</div>
			

		</form:form>
	</div>

</div>
</div>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />