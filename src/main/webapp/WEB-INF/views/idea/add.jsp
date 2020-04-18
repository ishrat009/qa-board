<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />

<!-- Page Heading -->
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/idea/show-all"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
		class="fa-sm text-white-50"></i>Show All</a>
</div>

<!-- Content Row -->
<div class="row">
	<div class="col-md-10">
		<div class="p-5 card card-primary card-outline">

			<!-- /.card-header -->
			<div class="text-center">
				<h5>Add New Idea</h5>

				<form:form class="user form-horizontal" modelAttribute="ideaRm" enctype="multipart/form-data"
					action="${pageContext.request.contextPath }/idea/add" method="POST">
					<%--  <div if="${isOk=='true'}" class="alert alert-success"
					text="${msg}"></div>
				<div if="${isOk==''}" class="alert alert-success"
					text="${msg}"></div>  --%>
					<div class="form-group row">
						<label align="left" class="col-sm-3" class="control-label">Category</label>
						<div class="col-sm-9">
							<form:select class="form-control" path="catId"
								style="width: 100%; color: black;">
								<form:options items="${cat_list}" itemLabel="name"
									itemValue="id"></form:options>

							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<label align="left" class="col-sm-3">Idea Title</label>
						<div class="col-sm-9">
							<form:input type="text" path="ideaTitle"
								class="form-control"
								enctype="multipart/form-data" placeholder="Title"></form:input>
						</div>
					</div>
					<div class="form-group row">
						<label align="left" class="col-sm-3">Idea Body</label>
						<div class="col-sm-9">
							<form:textarea type="text" id="inputIdeaBody" path="ideaBody"
								class="form-control form-control-user" placeholder="Title"></form:textarea>
						</div>
					</div>
					<div class="form-group row">
						<label align="left" class="col-sm-3">Upload Documents
							(Optional):</label>
						<div class="col-sm-9">
							<input type="file" id="images" name="images[]"
								multiple="multiple"
								accept=" .wma, .mp3, .mp4, .avi, .wmv, .doc, .docx, image/*" />
						</div>
					</div>

					<input type="submit" class="btn btn-primary" name="submit"
						value="Create">


				</form:form>
			</div>
			<!-- /.tab-pane -->
		</div>
		<!-- /.tab-content -->
	</div>

</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
<script type="text/javascript">
		CKEDITOR.replace('inputIdeaBody',
				{
					toolbar : [
							{
								name : 'styles',
								items : [ 'Styles', 'Format', 'Font',
										'FontSize' ]
							},
							{
								name : 'basicstyles',
								groups : [ 'basicstyles', 'cleanup' ],
								items : [ 'Bold', 'Italic', 'Underline',
										'Strike', 'Subscript', 'Superscript',
										'-', 'CopyFormatting', 'RemoveFormat' ]
							},
							{
								name : 'links',
								items : [ 'Link', 'Unlink', 'Anchor' ]
							},
							{
								name : 'colors',
								items : [ 'TextColor' ]
							},
							{
								name : 'paragraph',
								groups : [ 'list', 'indent', 'blocks', 'align',
										'bidi' ]
							}, {
								name : 'links'
							}, {
								name : 'insert'
							} ]
				});

		function showTermsAndConditions() {
			$('#myModal').modal({
				backdrop : 'static',
				keyboard : false
			});
			$(".modal-body").load("/terms-and-conditions");
		}
	</script>


