<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/department/list"
		class="d-none d-sm-inline-block btn btn-sm btn-info shadow-sm"><i
		class="fa-sm text-white-50"></i>Show All Departments</a>
</div>

<!-- Content Row -->
<div class="row">
	<div class="col-md-10">
		<div class="p-5 card card-primary card-outline">

			<!-- /.card-header -->
			<div class="text-center">
				<h5>Edit Department</h5>

				<form:form class="user form-horizontal" modelAttribute="dept" action="${pageContext.request.contextPath }/department/edit" method="POST">
					<div class="form-group row">
						<label align="left" class="col-sm-3">Enter Department Name</label>
						<div class="col-sm-9">
							<form:input path="id" value="${dept.id}" hidden="hidden"/>
							
							<form:input type="text" path="deptName" class="form-control form-control-user"
								 placeholder="Category Name" value="${dept.deptName}"></form:input>
						</div>
					</div>

					<div class="card-footer">
						<input type="submit" class="btn btn-primary" name="submit" value="Update">
					</div>
				</form:form>
			</div>
			<!-- /.tab-pane -->
		</div>
		<!-- /.tab-content -->
	</div>

</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />