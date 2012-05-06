<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script>
	$(function(){				
		$('#search_param1').chosen({allow_single_deselect:true});
		$('#grade').chosen({allow_single_deselect:true});
		$('#subject').chosen({allow_single_deselect:true});		
	});	
</script>
</head>

<body>	
	<div class="main">	
		
		<div class="row-1" style="font-size:10px">
			<a class="logo" href="index.jsp"></a> 
			
			<c:if test="${sessionScope.email != null}">
				Logged in: <label style="color:#000"><c:out value="${sessionScope.email}"/></label> <a href="logout.do">(Log out)</a>
			</c:if>							
		</div>
		
		<div class="row-1">								
		 	<form id="search-form-main">
		 		<label>What are you looking for?</label>
				<fieldset>
					<div class="search-form-main">					
						<input type="text" name="keyword" id ="keyword" value="Type Keyword Here" onBlur="if(this.value=='') this.value='Type Keyword Here'" onFocus="if(this.value =='Type Keyword Here' ) this.value=''" />
						<a id="clickAdvanced" style="cursor:pointer; vertical-align:middle important">Advanced>></a>											
						<a href="#" id="search-form-main-a">Search</a>															
					</div>				
				</fieldset>
				
				<div style="position: absolute; margin-top:5px;" id="div_param">					
					<select id="search_param1" data-placeholder="Select Criteria..." class="chzn-select-deselect" style="width:150px">						
						<option value=""/>
						<option value="description">Description</option>
						<option value="grade">Grade</option>
						<option value="subject">Subject</option>			
					</select>
						
					<select id ="grade" name ="grade" data-placeholder="Select Grade..." class="chzn-select-deselect" style="width:150px">
						<option value=""></option> 																													
					 	<c:forEach items="${listGrade}" var="myGrade">								 						 		
					 		<option value="<c:out value="${myGrade.id}" />"><c:out value="${myGrade.grade}"/></option>
					 	</c:forEach>						 
					</select>
					
					<select id ="subject" name ="subject" data-placeholder="Select Subject..." class="chzn-select-deselect" style="width:300px">
						<option value=""></option> 																													
					 	<c:forEach items="${listSubject}" var="mySubject">
					 		<option value="<c:out value="${mySubject.id}" />"><c:out value="${mySubject.name}" /></option>
					 	</c:forEach>						 
					</select>
				</div>
								
			</form>
		</div>	
					
		<div  class="row-1">								
		 	<form id="upload-form" action="" method="post" enctype="multipart/form-data">
		 		<H1>
		 		<a href="<c:choose><c:when test="${sessionScope.email != null}">upload.jsp</c:when><c:otherwise>login.jsp</c:otherwise></c:choose>" id="uploadbtn" class="uploadbtn"></a></H1>					
			</form>						
		</div>					         				
					
	</div>  		  
	   	