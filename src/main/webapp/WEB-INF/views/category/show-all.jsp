<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/category/add"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
		class="fa-sm text-white-50"></i>Add New</a>
</div>
<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Show All categories</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Opening Date</th>
						<th>Closure Date</th>
						<th>Final Closure Date</th>
						<th>Department</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Opening Date</th>
						<th>Closure Date</th>
						<th>Final Closure Date</th>
						<th>Department</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${cat_list}" var="cat">
						<tr>
							<td>${ cat.id }</td>
							<td>${ cat.name }</td>
							<td>${ cat.openingDate }</td>
							<td>${ cat.closingDate }</td>
							<td>${ cat.finalClosingDate }</td>
							<td>${ cat.dept }</td>
							<td><a href="edit?id=${ cat.id }">Edit</a></td>
							<td><a href="delete?id=${ cat.id }">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>
<%-- <section class="content">
	<div class="card">
              <div class="card-header">
                <h3 class="card-title">Show All Team</h3>
                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" class="team-query form-control float-right" placeholder="Search">
                    <div class="input-group-append">
                      <button type="submit" class="team-query-submit btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0" style="height: 300px;">
                <table class="table table-head-fixed text-nowrap" id="show-all-table">
                  <thead >
                    <tr>
                     <th style="width: 30px;">Id</th>
					<th style="width: 50px;">Country</th>
					<th style="width: 100px;">Name</th>
					<th style="width: 10px;">Edit</th>
					<th style="width: 10px;">Deactive</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${team_list}" var="team">
			<tr>
				<td style="width: 30px;">${ team.id }</td>
				<td style="width: 50px;">${ team.country.getCountryName() }</td>
				<td style="width: 100px;">${ team.name }</td>
				<td style="width: 10px;"><a href="edit?id=${ team.id }">Edit</a></td><td style="width: 10px;"> <a
					href="deactive?id=${ team.id }">Lock</a></td>
			</tr>
		</c:forEach>                          
                  </tbody>
               
                </table><table id="search-table">
                   <tbody class="search-result">

    </tbody>
                </table>
              </div>
     </div>
</section> --%>
<!-- /.content -->
<!-- </div> -->
<!-- /.content-wrapper -->



<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
