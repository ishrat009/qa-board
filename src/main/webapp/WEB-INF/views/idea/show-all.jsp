<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/idea/add"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
		class="fa-sm text-white-50"></i>Add New</a>
</div>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Show All Ideas</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Id</th>
						<th>Idea Title</th>
						<th>Category</th>
						<th>Edit</th>
						<th>View</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Idea Title</th>
						<th>Category</th>
						<th>Edit</th>
						<th>View</th>
						<th>Delete</th>
					</tr>
				</tfoot>
				
				<tbody>
					<c:forEach items="${idea_list}" var="idea">
						<tr>
							<td>${ idea.id }</td>
							<td>${ idea.ideaTitle }</td>
							<td>${ idea.getCat().getName()}</td>
							<td><a href="edit?id=${ idea.id }">Edit</a></td>
							<td><a href="view?id=${ idea.id }">View</a></td>
							<td><a href="delete?id=${ idea.id }">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
