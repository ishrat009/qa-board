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
    <a href="${pageContext.request.contextPath }/comment/show-all" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fa-sm text-white-50"></i>Show All</a>
</div>

<!-- Content Row -->
<div class="row">
    <div class="col-md-10">
        <div class="p-5 card card-primary card-outline">

            <div class="text-center"><h5>Add New Term And Conditions</h5>

            </div>
        </div>
    </div>

    <div>

<form:form>
    <table>
    <tr>
    <td>First Name:</td>
    <td><form:input path="firstName" /></td>
    </tr>
    </table>

</form:form>
    </div>
        <form:form class="form-horizontal" action="${pageContext.request.contextPath }/comment/add"
                   modelAttribute="comment">
            <div class="card-body">
                <div class="form-group row">
                    <div class="col-sm-10" >
                        <form:input class="form-control" id="userInput"  path="commentBody"/>
                            <%--                           < form:input class="form-control"  path="textMessage"  &lt;%&ndash;Style="width: 1000px;  height: 350px"&ndash;%&gt;/>--%>
                            <%--                        </form:input>--%>
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
</div>

</div>


<%--<div>--%>
<%--<section class="form-gradient mb-5">--%>

<%--    <!--Form with header-->--%>
<%--    <div class="card">--%>

<%--        <!--Header-->--%>
<%--        <div class="header peach-gradient">--%>

<%--            <div class="row d-flex justify-content-center">--%>
<%--                <h3 class="white-text mb-0 py-5 font-weight-bold">Contact Us</h3>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--        <!--Header-->--%>

<%--        <div class="card-body mx-4">--%>

<%--            <div class="md-form">--%>
<%--                <i class="fas fa-user prefix grey-text"></i>--%>
<%--                <input type="text" id="form104" class="form-control">--%>
<%--                <label for="form104">Your name</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <i class="fas fa-envelope prefix grey-text"></i>--%>
<%--                <input type="text" id="form105" class="form-control">--%>
<%--                <label for="form105">Your email</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <i class="fas fa-tag prefix grey-text"></i>--%>
<%--                <input type="text" id="form106" class="form-control">--%>
<%--                <label for="form106">Subject</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <i class="fas fa-pencil-alt prefix grey-text"></i>--%>
<%--                <textarea id="form107" class="md-textarea form-control" rows="5"></textarea>--%>
<%--                <label for="form107">Your message</label>--%>
<%--            </div>--%>


<%--            <!--Grid row-->--%>
<%--            <div class="row d-flex align-items-center mb-3 mt-4">--%>

<%--                <!--Grid column-->--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="text-center">--%>
<%--                        <button type="button" class="btn btn-grey btn-rounded z-depth-1a">Send</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <!--Grid column-->--%>

<%--            </div>--%>
<%--            <!--Grid row-->--%>
<%--        </div>--%>

<%--    </div>--%>
<%--    <!--/Form with header-->--%>

<%--</section>--%>
<%--<!-- Section: form gradient -->--%>
<%--<!-- Section: form dark -->--%>
<%--<section class="form-dark mb-5">--%>

<%--    <!--Form without header-->--%>
<%--    <div class="card card-image" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/pricing-table%20(7).jpg');">--%>
<%--        <div class="text-white rgba-stylish-strong py-5 px-5 z-depth-4">--%>

<%--            <!--Header-->--%>
<%--            <div class="text-center">--%>
<%--                <h3 class="white-text mb-5 mt-4 font-weight-bold text-uppercase"><strong>Contact</strong> <a class="green-text font-weight-bold"><strong>--%>
<%--                    Us</strong></a></h3>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <input type="text" id="form100" class="form-control">--%>
<%--                <label for="form100">Your name</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <input type="text" id="form101" class="form-control">--%>
<%--                <label for="form101">Your email</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <input type="text" id="form102" class="form-control">--%>
<%--                <label for="form102">Subject</label>--%>
<%--            </div>--%>

<%--            <div class="md-form">--%>
<%--                <textarea id="form103" class="md-textarea form-control" rows="5"></textarea>--%>
<%--                <label for="form103">Your message</label>--%>
<%--            </div>--%>

<%--            <!--Grid row-->--%>
<%--            <div class="row d-flex align-items-center">--%>

<%--                <!--Grid column-->--%>
<%--                <div class="text-center col-md-12 mt-3 mb-2">--%>
<%--                    <button type="button" class="btn btn-success btn-block btn-rounded z-depth-1">Send</button>--%>
<%--                </div>--%>
<%--                <!--Grid column-->--%>
<%--            </div>--%>
<%--            <!--Grid row-->--%>

<%--        </div>--%>
<%--    </div>--%>
<%--    <!--/Form without header-->--%>

<%--</section>--%>
<!-- Section: form dark -->


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
