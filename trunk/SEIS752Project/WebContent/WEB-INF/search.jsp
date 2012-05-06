<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="java.util.List"%>
<%@page import="com.seis.dao.impl.RessourceDaoImpl"%>
<%@page import="com.seis.domain.Ressource"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Teacher Resources</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/chosen.css" type="text/css" media="screen">

<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/cufon-replace.js" type="text/javascript"></script>
<script src="js/Open_Sans_400.font.js" type="text/javascript"></script>
<script src="js/Open_Sans_Light_300.font.js" type="text/javascript"></script> 
<script src="js/Open_Sans_Semibold_600.font.js" type="text/javascript"></script>  
<script type="text/javascript" src="js/tms-0.3.js"></script>
<script type="text/javascript" src="js/tms_presets.js"></script> 
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
<script src="js/FF-cash.js" type="text/javascript"></script>
<script src="js/searchValidation.js" type="text/javascript"></script>
<script type="text/javascript" src="js/chosen.jquery.js"></script>
<!--[if lt IE 7]>
	<div style=' clear: both; text-align:center; position: relative;'>
		<a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/images/upgrade.jpg" border="0"  alt="" /></a>
	</div>
<![endif]-->
<!--[if lt IE 9]>
	<script type="text/javascript" src="js/html5.js"></script>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
<![endif]-->
<script>
	$(function(){
				
		$('#search_param1').chosen({allow_single_deselect:true});
		$('#grade').chosen({allow_single_deselect:true});
		$('#subject').chosen({allow_single_deselect:true});		
	});
	
	$(function() {
		$("#uploadbtn").click(function() { 					  						
			alert('Upload Button');
			window.location.href = "upload.jsp"; 
				
		});				  
	});
</script>

</head>

<body>	
	<div class="main">	
		
		<div class="row-1">
			<H1><a class="logo" href="index.jsp">Teacher Resources</a></H1>			
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
		 		<H1><a href="#" id="uploadbtn" class="uploadbtn"></a></H1>					
			</form>						
		</div>					         				
					
	</div>  		  
	
	<c:forEach items = "${resourceList}" var="myResource">               			       			
		<c:out value="${myResource.id}"/>
		<c:out value="${myResource.description}"/><br>				       		       
   </c:forEach>
   	   
	
	<div style="width:100%;overflow:hidden;padding-top:170px;text-align:center">
	 	&copy;&nbsp;2012&nbsp;&#45;&nbsp;University&nbsp;of&nbsp;St.&nbsp;Thomas&nbsp;-&nbsp;SEIS&nbsp;752&nbsp;Team&nbsp;I
	</div>	
</body>
</html>

