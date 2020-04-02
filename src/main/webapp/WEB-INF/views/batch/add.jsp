<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/batch/show-all" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fa-sm text-white-50"></i>Show All</a>
</div>

<!-- Content Row -->
<div class="row">
	<div class="col-md-10">
		<div class="p-5 card card-primary card-outline">

			<!-- /.card-header -->
			<div class="text-center"><h5>Add New Batch</h5>

				<form  class="user form-horizontal"
					   action="${pageContext.request.contextPath }/batch/add"
					   method="POST">
					<div class="form-group row">
						<label align="left" class="col-sm-3" for="inputName" >
							Enter Batch Name</label>
						<div class="col-sm-9">
							<input type="text" name="" value=""
								   hidden="hidden"> <input type="text" name="batchName"
														   class="form-control form-control-user"  id="inputName"
														   placeholder="Batch Name" required>
						</div>
					</div>
					<div class="form-group row">
						<label align="left" class="col-sm-3" for="inputName" >
							Enter Academic Year</label>
						<div class="col-sm-9">
							<input type="text" name="" value=""
								   hidden="hidden"> <input type="text" name="academicYear"
														   class="form-control form-control-user"  id="inputName"
														   placeholder="Academic Year" required>
						</div>
					</div>
					<div class="card-footer"><input type="submit" class="btn btn-primary"
													name="submit" value="Add"></div>
				</form>
			</div>
			<!-- /.tab-pane -->
		</div>
		<!-- /.tab-content -->
	</div>

</div>

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
		