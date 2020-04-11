<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="card">
              <div class="card-header">
                <h3 class="card-title">Show All Member</h3>
                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0" style="height: 300px;">
                <table class="table table-head-fixed text-nowrap">
                  <thead>
                    <tr>
                     <th style="width: 30px;">Id</th>
					<th style="width: 100px;">Team</th>
					<th style="width: 50px;">Name</th>
					<th style="width: 30px;">Age</th>
					<th style="width: 50px;">Role</th>
					<th style="width: 10px;">Edit</th>
					<th style="width: 10px;">Deactive</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${player_list}" var="player">
			<tr>
				<td style="width: 30px;">${ player.id }</td>
				<td style="width: 10px;">${ player.teamName }</td>
				<td style="width: 50px;">${ player.name }</td>
				<td style="width: 30px;">${ player.age }</td>
				<td style="width: 50px;">${ player.role }</td>
				<td style="width: 10px;"><a href="edit?id=${ player.id }">Edit</a></td><td style="width: 10px;"> <a
					href="deactive?id=${ player.id }">Deactive</a></td>
			</tr>
		</c:forEach>                          
                  </tbody>
                </table>
              </div>
     </div>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
