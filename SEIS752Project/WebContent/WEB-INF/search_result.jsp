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

<style type="text/css" title="currentStyle">
			@import "css/demo_page.css";
			@import "css/demo_table.css";
		</style>

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
<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
		
<!--[if lt IE 7]>
	<div style=' clear: both; text-align:center; position: relative;'>
		<a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/images/upgrade.jpg" border="0"  alt="" /></a>
	</div>
<![endif]-->
<!--[if lt IE 9]>
	<script type="text/javascript" src="js/html5.js"></script>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
<![endif]-->

<!-- Set Date Format -->
<c:set var="dateFormat" value="MMM dd, yyyy"/>
<script type="text/javascript">
	
	/* Initializing search parameters */
	$(function() {
		
		$('#search_param1').chosen({allow_single_deselect:true});
		$('#grade').chosen({allow_single_deselect:true});
		$('#subject').chosen({allow_single_deselect:true});
		
		//Set data from sessions	
		if ($('#search_param1').val() != ''){
			$('#clickAdvanced').hide();
			$('#div_param').show();
			$('#grade_chzn').hide();
			$('#subject_chzn').hide();
		}			
		
		if ($('#search_param1').val() == 'grade'){
			$('#grade_chzn').show();
			$('#subject_chzn').hide();	
		}
		if ($('#search_param1').val() == 'subject'){
			$('#grade_chzn').hide();
			$('#subject_chzn').show();	
		}
		
		//Initialize datatables
		$('#tbl_results').dataTable( {
			"aaSorting": [[ 4, "desc" ]],
			"oLanguage": {
			    "sSearch": "Filter: "
			  }
		} );				 
	});
</script>
	
</head>

<body>	
	<div class="main">	
		
		<div >
			<H1><a class="logo" href="index.jsp">Teacher Resources</a></H1>			
		</div>
		
		<div style="with:100%; margin: 0 auto;">
			<div style="float:left; width:65%; vertical-align:top;">						
			 	<form id="search-form">		 		
					<fieldset>
						<div class="search-form">					
							<input type="text" name="keyword" id ="keyword" value="<c:out value="${keyword}"/>" />
							<a id="clickAdvanced" style="cursor:pointer; vertical-align:middle important">Advanced>></a>																					
							<a href="#" id="search-form-main-a">Search</a>															
						</div>				
					</fieldset>
					
					<div style="position: absolute; margin-top:5px;" id="div_param">
					
						<select id="search_param1" data-placeholder="Select Criteria..." class="chzn-select-deselect" style="width:150px">						
							<option value=""/>
							<option value="description" <c:if test="${param.param == 'description'}">selected</c:if>>Description</option>
							<option value="grade" <c:if test="${param.param == 'grade'}">selected</c:if>>Grade</option>
							<option value="subject" <c:if test="${param.param == 'subject'}">selected</c:if>>Subject</option>			
						</select>
							
						<select id ="grade" name ="grade" data-placeholder="Select Grade..." class="chzn-select-deselect" style="width:150px">
							<option value=""></option> 																													
						 	<c:forEach items="${listGrade}" var="myGrade">						 					 		
						 		<option value="<c:out value="${myGrade.id}" />" <c:if test="${myGrade.id == grade}">selected</c:if>><c:out value="${myGrade.grade}" /></option>
						 	</c:forEach>						 
						</select>
						
						<select id ="subject" name ="subject"  data-placeholder="Select Subject..." class="chzn-select-deselect" style="width:300px">
							<option value=""></option> 																													
						 	<c:forEach items="${listSubject}" var="mySubject">
						 		<option value="<c:out value="${mySubject.id}" />" <c:if test="${mySubject.id == subject}">selected</c:if>><c:out value="${mySubject.name}" /></option>
						 	</c:forEach>						 
						</select>
					</div>				
				</form>
				
			</div>
					
			<div style="float:right; width:35%; vertical-align:top;">	
				<form id="upload-form" action="" method="post" enctype="multipart/form-data">
			 		<H1><a href="#" id="uploadbtn-small" class="uploadbtn-small"></a></H1>					
				</form>	
			</div>
		</div>
		
		<div  class="row-4">										 	    
		   <table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_results" style="color:#1d4288">
				<thead>
					<tr>
						<th></th>
						<th>Title</th>
						<th>Description</th>
						<th>Created Date</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${resourceList}" var="myResource"> 
						<tr>
							<td style="vertical-align:middle">
								<c:if test="${myResource.icon != null}">
									<c:set var="imglink" value="images/${myResource.icon}" scope="request" />
									<img src="${imglink}">
								</c:if>
							</td>
							
							<td style="vertical-align:middle">
								<c:out value="${myResource.title}"/>
							</td>
							
							<td style="vertical-align:middle">
								<c:out value="${myResource.description}"/>
							</td>
							
							<td style="vertical-align:middle">
								<fmt:formatDate value="${myResource.dateCreated}" pattern="${dateFormat}"/>
							</td>
							
							<td style="vertical-align:middle">
								<c:out value="${myResource.location}"/>	
							</td>
							
						</tr>
					</c:forEach>
				</tbody>	
			</table>
		</div>					         								
		
	</div>  		  	  
	
	<div style="width:100%;overflow:hidden;padding-top:170px;text-align:center">
	 	&copy;&nbsp;2012&nbsp;&#45;&nbsp;University&nbsp;of&nbsp;St.&nbsp;Thomas&nbsp;-&nbsp;SEIS&nbsp;752&nbsp;Team&nbsp;I
	</div>	
		
</body>
</html>

