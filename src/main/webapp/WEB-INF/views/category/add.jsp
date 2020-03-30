<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />
 <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="${pageContext.request.contextPath }/category/show-all" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fa-sm text-white-50"></i>Show All</a>
          </div>

          <!-- Content Row -->
          <div class="row">
				<div class="col-md-10">
				<div class="p-5 card card-primary card-outline">
						
					<!-- /.card-header -->
					<div class="text-center"><h5>Add New Category</h5>
						
								<form  class="user form-horizontal"
									action="${pageContext.request.contextPath }/category/add"
									 method="POST">
									<div class="form-group row">
										<label align="left" class="col-sm-3" for="inputName" >
											Enter Tag Name</label>
										<div class="col-sm-9">
											<input type="text" name="" value=""
												hidden="hidden"> <input type="text" name="name"
												class="form-control form-control-user"  id="inputName"
												placeholder="Category Name" required>
										</div>
									</div>
									<div class="form-group row">
										<label align="left"  class="col-sm-3" for="inputEmail" >Opening Date</label>
										<div class="col-sm-9">
											<input type="text" id="opening-date" name="openingDate" class="form-control form-control-user"
												 placeholder="DD/MM/YYYY" required>
										</div>
									</div>
									<div class="form-group row">
										<label align="left"  class="col-sm-3" for="inputName" >
											Closing Date</label>
										<div class="col-sm-9">
											 <input type="text" name="closingDate" id="closure-date"
												class="form-control form-control-user" 
												placeholder="DD/MM/YYYY" required>
										</div>
									</div>
									<div class="form-group row">
										<label align="left"  class="col-sm-3" for="inputName2" >Final Closing Date
											</label>
										<div class="col-sm-9"><input type="text" id="final-closure-date" name="finalClosingDate"
												class="form-control form-control-user datepicker" 
												placeholder="DD/MM/YYYY" required></div>
									</div>
								
									<div class="card-footer">
										<input type="submit" class="btn btn-primary" name="submit"
											value="Create">
									</div>
								</form>
							</div>
							<!-- /.tab-pane -->
						</div>
						<!-- /.tab-content -->
					</div>
          
          </div>

<%-- <div class="col-md-9">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Add New Team</h3>
		</div>


		<form:form class="form-horizontal" action="${pageContext.request.contextPath }/category/add"
		modelAttribute="team">
			<div class="card-body">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Country :  </label>
					<div class="col-sm-10"><form:select class="form-control" path="country.countryCode">
				<form:options items="" itemLabel="countryName"
					itemValue="countryCode"></form:options>
			</form:select></div></div>
					<div class="form-group row">
					<label class="col-sm-2 col-form-label">Team Name: </label>
					<div class="col-sm-10"><form:input class="form-control" path="name" /></div></div>
					<div class="card-footer"><input type="submit" class="btn btn-primary"
						name="submit" value="Add"></div>
				</div>
			
</form:form>
	</div>

</div>
</div> --%>

							<script type="text/javascript" th:inline="javascript">
								$('#inputVisibleToDepartments').select2();
								var dateToday = new Date();
								$(
										"#opening-date, #closure-date, #final-closure-date")
										.datepicker({
											minDate : dateToday,
											dateFormat : "d/m/yy"
										});
							</script>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
		