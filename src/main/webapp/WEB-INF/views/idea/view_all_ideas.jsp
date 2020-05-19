<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- GLOBAL HEADER -->
<jsp:include page="../common/header.jsp" />

<!-- Main content -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<a href="${pageContext.request.contextPath }/idea/add"
		class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
		class="fa-sm text-white-50"></i>Add New</a>
</div>
<!-- DataTales Example -->

<!-- <div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Show All Ideas</h6>
	</div> -->

<div class="row">

	<!-- Area Chart -->
	<div class="col-xl-8 col-lg-7">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<c:forEach items="${idea_list}" var="idea">
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h6 class="m-0 font-weight-bold text-primary">${ idea.userId.fullName }
						<input name="id" value="${ idea.id }" hidden="hidden" />Posted
					</h6>

				</div>
				<!-- Card Body -->
				<div class="card-body">

					<h5>${ idea.ideaTitle }</h5>
					${ idea.ideaBody } Category : ${ idea.getCat().getName()}

					<div>  <c:set var="colorAttr" value="#8d8d8d"/>
							<c:set var="colorAttr2" value="#8d8d8d"/>
                                  <c:if test="${idea.isLiked}">
                                        <c:set var="colorAttr" value="#44d0b0"/>
                                        <c:set var="colorAttr2" value="#8d8d8d"/>
                                    </c:if> 
                                     <c:if test="${idea.isDisliked}">
                                        <c:set var="colorAttr" value="#8d8d8d"/>
                                        <c:set var="colorAttr2" value="#44d0b0"/>
                                    </c:if>   
						<br> <b><a class="link-black text-sm"
							text="view Full Post" href=""><small>View Full Post |
							</small></a></b> <span text="" id=""><small><em class="${idea.isLiked}"
								id="thumps_up_count_${idea.id}">${idea.totalLikes}</em></small></span>  <small> <i id="thumps_up_${idea.id}"
								onclick="addReactions(${idea.id},${user.id},2,this)"
								class="fa fa-thumbs-up margin-r-5" style="color: ${colorAttr}">Thumb up |
						</i> </small> <span text="" id=""><small><em class=""
								id="thumps_down_count_${idea.id}">${idea.totalDislikes}</em></small></span>  <small><i onclick="addReactions(${idea.id},${user.id},3,this)"
								id="thumps_down_${idea.id}" class="fa fa-thumbs-down margin-r-5" style="color: ${colorAttr2}">Thumb down</i></small> <br> <a
							class="link-black text-sm" text="" href=""><small>Views
						</small></a> &nbsp;<span text=""><small>0</small></span> <a
							class="link-black text-sm" text="" href=""><small> |
								Seen by </small> </a> &nbsp;<span text=""><small>0 | </small></span>&nbsp; <small>Comments<i
								onclick="show_comments(${idea.id})" class="fa fa-comments margin-r-5"></i></small> <small id="comment_count_${idea.id}">${idea.totalComment}</small>

					</div>
					<div>
						<br>

						<div class="search">
							<div class="row">
								<img alt="${user.fullName}"
									style="width: 30px; height: 30px; display: block;"
									class="img-profile rounded-circle"
									src="${pageContext.request.contextPath }${user.profilePic}"><small>
									<input name="ideaId" value="${idea.id}" hidden="hidden" /> <input
									id="comment_${idea.id}" placeholder="Write a comment"
									type="text">
									<button onclick="addComment(${idea.id},${user.id})"
										class="btn btn-sm btn-success">Send</button>
								</small>
								
							</div>
							<br/><div  style="display:none" class="text-left" id="comments_${idea.id}">
                                        <c:forEach items="${idea.comments}" var="comment">
                                            <div class="media m-0">
                                                <div class="d-flex mr-3">
                                            <a href=""><img style="width: 30px; height: 30px; display: block;" class="img-profile rounded-circle"
                                                                    src="${pageContext.request.contextPath }${comment.userId.profilePic}"
                                                                    alt="User"></a>
                                                </div>
                                                <div class="media-body">
                                                <small><i>${comment.userId.fullName}</i> 
                                                    </small> 
                                                    <p>${comment.commentBody}</p>
                                                    
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div> 
							<script type="text/javascript">
           function addComment(ideaId, userId) {
               var commentBody = $('#comment_' + ideaId).val();
               var url = "${pageContext.request.contextPath}/api/v1/idea/addcomment";
			//alert("Test");
               $.ajax({
                   method: "POST",
                   async: false, 
                   url: url,
                   data: {ideaId: ideaId, userId: userId, commentBody: commentBody}
               }).done(function (response) {
				  // alert(response);
                   console.log(response);
                   if (response.id <= 0){
                       console.log("Invalid comment id")
                       return;
                   }
                   //alert(document.getElementById("comment_count_"+ideaId).innerHTML)
                   var totalCommentStr = document.getElementById("comment_count_"+ideaId).innerHTML;
                   var totalComment = parseInt(totalCommentStr);
                   totalComment++;
                  document.getElementById("comment_count_"+ideaId).innerHTML = totalComment;
                  document.getElementById("comments_"+ideaId).style.display = "block";
                   $('#comment_' + ideaId).val(commentBody);
                   
              	   $('#comments_' + ideaId).append(" </hr> <div >\n" +
                       "                <div class=\"media m-0\">\n" +
                       "                 <div class=\"d-flex mr-3\">\n" +
                       "                    <a href=\"\"><img style=\"width: 30px; height: 30px; display: block;\" class=\"img-fluid rounded-circle\"\n" +
                       "                          src=\"${pageContext.request.contextPath }${user.profilePic}\"\n" +
                       "                     alt=\"User\"></a>\n" +
                       "                </div>\n" +
                       "\n" +
                       "                <div class=\"media-body\">\n" +
                       "                  <small><i class=\"icon ion-md-pin\"></i>${user.fullName}</small>\n" +
                       "                     <p class=\"m-0\">" + commentBody + "</p>\n" +
                       "            </div>\n" +
                       "            </div>\n" +
                       "            </div>"); 

                   // end of ammend

               


               }).fail(function () {

               });


           }

           function addReactions(ideaId, userId, reactionType, element) {

               var url = "${pageContext.request.contextPath}/api/v1/idea/reactions";
            
               $.ajax({
                   method: "POST",
                   async: false, 
                   url: url,
                   data: {ideaId: ideaId, userId: userId,reactionType: reactionType}
               }).done(function (response) {
                   console.log(response);
                   console.log("like saved");
					
                   var totalLikeStr = document.getElementById("thumps_up_count_"+ideaId).innerHTML;
                   var totalDislikeStr = document.getElementById("thumps_down_count_"+ideaId).innerHTML;
                   var totalLike = parseInt(totalLikeStr);
                   var totalDislike = parseInt(totalDislikeStr);
                 //  alert(document.getElementById("thumps_up_"+ideaId).style.color)
                  // alert(document.getElementById("thumps_down_"+ideaId).style.color)
                   if (reactionType == 2 && response > 0) {
                       // liked state
                       if(document.getElementById("thumps_down_"+ideaId).style.color == "rgb(68, 208, 176)"){
                    	   $(element).css("color", "#44d0b0");
                    	   document.getElementById("thumps_down_"+ideaId).style.color = "#8d8d8d";
                    	   totalLike++;
                    	   totalDislike--;
                       }else{
                    	   $(element).css("color", "#44d0b0");
                           totalLike++;
                       }
                    
                     
                   } if (reactionType == 2 && response == 0) {
                       // liked state
                       
                     $(element).css("color", "#8d8d8d");
                       totalLike--;
                   } if (reactionType == 3 && response > 0) {
                       // liked state
                	   if(document.getElementById("thumps_up_"+ideaId).style.color == "rgb(68, 208, 176)"){
                    	   document.getElementById("thumps_up_"+ideaId).style.color = "#8d8d8d";
                    	   $(element).css("color", "#44d0b0");
                    	   totalDislike++;
                    	   totalLike--;
                       }else{
                    	   $(element).css("color", "#44d0b0");
                           totalDislike++;
                       }
                      
                   }
                   if (reactionType == 3 && response == 0) {
                       // liked state
                     $(element).css("color", "#8d8d8d");
                       totalDislike--;
                   }
                

                   document.getElementById("thumps_up_count_"+ideaId).innerHTML = totalLike;
                   document.getElementById("thumps_down_count_"+ideaId).innerHTML = totalDislike;

               }).fail(function () {

                   console.log("failed to save like");
               });

           }
           function show_comments(ideaId) {
        	   var x = document.getElementById("comments_"+ideaId);
        	   if (x.style.display === "none") {
        	     x.style.display = "block";
        	   } else {
        	     x.style.display = "none";
        	   }
//alert(ideaId)
//element.style.visibility = 'visible';  
//document.getElementById("comments_"+ideaId).style.visibility = 'visible';  

           }

 </script>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<!-- Pie Chart -->
	<div class="col-xl-4 col-lg-5">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary">Profile</h6>
				<div class="dropdown no-arrow">
					<a class="dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i
						class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
					</a>
					<div
						class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
						aria-labelledby="dropdownMenuLink">
						<div class="dropdown-header">Dropdown Header:</div>
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				</div>
			</div>
			<!-- Card Body -->
			<div class="card-body">
				<div class="chart-pie pt-4 pb-2">
					<canvas id="myPieChart"></canvas>
				</div>
				<div class="mt-4 text-center small">
					<span class="mr-2"> <i class="fas fa-circle text-primary"></i>
						 Idea
					</span> <span class="mr-2"> <i class="fas fa-circle text-success"></i>
						Issue
					</span> <span class="mr-2"> <i class="fas fa-circle text-info"></i>
						Referral
					</span>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="../common/footer.jsp" />
