<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/department/add"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
		class="fa-sm text-white-50"></i>Add New Department</a>
</div>
<!-- DataTales Example -->

<c:if test="${!empty(message)}">
	<div class="card mb-4 py-3 border-bottom-success">
	      <div class="card-body">
	        ${message}
	      </div>
	</div>
</c:if>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">List of Departments</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${departments}" var="dept">
						<tr>
							<td>${ dept.id }</td>
							<td>${ dept.deptName }</td>
							<td><a href="edit?id=${ dept.id }" class="btn btn-sm btn-success">Edit</a></td>
							<td><a href="delete?id=${ dept.id }" class="btn btn-sm btn-danger">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
