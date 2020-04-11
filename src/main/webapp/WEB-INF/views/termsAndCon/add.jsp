<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />

<style>
    #userInput {
        margin: 1px;
        padding: 1px;
        width: 1000px;
        height: 300px;
        resize: none;
    }
</style>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <a href="${pageContext.request.contextPath }/termsAndCon/show-all" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fa-sm text-white-50"></i>Show All</a>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-md-10">
        <div class="p-5 card card-primary card-outline">

            <!-- /.card-header -->
            <div class="text-center"><h5>Add New Term And Conditions</h5>

            </div>
        </div>
    </div>

    <div>
        <form:form class="form-horizontal" action="${pageContext.request.contextPath }/termsAndCon/add"
                   modelAttribute="term">

            <div class="card-body">

                <div class="form-group row">
                    <div class="col-sm-10" >
                        <form:input class="form-control"   path="name"/>

                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10" >
                        <form:input class="form-control" id="userInput"  path="textMessage"/>

                    </div>
                </div>
                <div class="card-footer">
                    <input type="submit" class="btn btn-primary" name="submit" value="Add">
                </div>
            </div>


        </form:form>
    </div>
    <!-- /.tab-pane -->
</div>
<!-- /.tab-content -->

<jsp:include page="../common/footer.jsp" />
