<!-- GLOBAL HEADER -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../common/header.jsp" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>

<style>
    #userInput {
        margin: 1px;
        padding: 1px;
        width: 1000px;
        height: 300px;
        resize: none;
    }
</style>
<script>
    $( function() {
        $( ".datepicker" ).datepicker({
            dateFormat : "dd/mm/yy"
        });
    } );

</script>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <a href="${pageContext.request.contextPath }/termsAndCon/show-all"
       class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fa-sm text-white-50"></i>Show All</a>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-md-10">
        <div class="p-5 card card-primary card-outline">

            <!-- /.card-header -->
            <div class="text-center">
                <h5>Edit Terms</h5>

                <form:form class="user form-horizontal" modelAttribute="termRm" action="${pageContext.request.contextPath }/termsAndCon/edit" method="POST">
                    <div class="form-group row">

                        <div class="col-sm-9"><form:input path="id" value="${termRm.id}" hidden="hidden"/>

                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-9">
                            <form:input type="text"  path="name"
                                        class="form-control "></form:input>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10" >
                            <div id="userInput">

                                <form:textarea name="editor1" id="editor1" rows="10" cols="180" path="textMessage"/>
                            </div>


                        </div>
                    </div>



                    <div class="card-footer">
                        <input type="submit" class="btn btn-primary" name="submit" value="Update">

                    </div>
                    <div>

                        <script>
                            CKEDITOR.replace( 'editor1' );
                        </script>
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        $( ".datepicker" ).datepicker({
            dateFormat : "dd/mm/yy"
        });
    } );
</script>