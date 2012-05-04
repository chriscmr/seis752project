<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="java.util.List"%>
<%@page import="com.seis.dao.impl.RessourceDaoImpl"%>
<%@page import="com.seis.domain.Ressource"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
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
	
	$(function() {
		$("#keyword").focus();				
		$("#submitForm").click(function() { 					  						
			alert('YES');
			return false;		
		});				  
	});
	$(function() {
		$("#uploadbtn").click(function() { 					  						
			alert('Upload Button');
			return false;			
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
		 	<form id="search-form-main" action="" method="post" enctype="multipart/form-data">
		
			</form>
		</div>	
		
		<div  class="row-1">								
		 	<form id="upload-form" action="" method="post" enctype="multipart/form-data">
		 		<H1><a href="#" id="uploadbtn" class="uploadbtn"></a></H1>					
			</form>						
		</div>					         				
					
	</div>  		  
	
	<div style="width:100%;overflow:hidden;padding-top:170px;text-align:center">
	 	&copy;&nbsp;2012&nbsp;&#45;&nbsp;University&nbsp;of&nbsp;St.&nbsp;Thomas&nbsp;-&nbsp;SEIS&nbsp;752&nbsp;Team&nbsp;I
	</div>	
</body>
</html>