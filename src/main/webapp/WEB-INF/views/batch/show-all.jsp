<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <a href="${pageContext.request.contextPath }/batch/add"
       class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fa-sm text-white-50"></i>Add New</a>
</div>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Show All Batcher</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Batch Name</th>
                    <th>Academic  Year</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <%--<tfoot>
                <tr>
                    <th>Id</th>
                    <th>Batch Name</th>
                    <th>Academic year</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </tfoot>--%>
                <tbody>
                <c:forEach items="${batch_list}" var="batch">
                    <tr>
                        <td>${ batch.id }</td>
                        <td>${ batch.batchName }</td>
                        <td>${ batch.academicYear }</td>
                       <%-- <td><a href="edit?id=${ batch.id }">Edit</a></td>
                        <td><a href="delete?id=${ batch.id }">Delete</a></td>--%>


                        < <sec:authorize access="hasAnyRole('ADMIN')">
                        <td><a class="btn btn-warning" href="${pageContext.request.contextPath}/batch/edit?id=${batch.id}">Edit</a></td>
                    </sec:authorize>

                        < <sec:authorize access="hasAnyRole('ADMIN')">
                        <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/batch/delete?id=${batch.id}">Delete</a></td>
                    </sec:authorize>

                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
