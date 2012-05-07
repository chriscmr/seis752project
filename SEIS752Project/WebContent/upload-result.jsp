<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script type="text/javascript">
 function backHome() {
 		self.location.href="index.jsp";
 }
        	
</script>	
<title></title>
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

<title>Upload Resource</title>
<script>	
	

	$(function() {
		$("#uploadbtn").click(function() { 					  						
			alert('Upload Button');
			return false;			
		});				  
	});
</script>
</head>
<body>
<%
String title = (String)session.getAttribute("title");
String subject = (String)session.getAttribute("subject");
String grade = (String)session.getAttribute("grade");
String description = (String)session.getAttribute("description");
String location = (String)session.getAttribute("location");
String icon = (String)session.getAttribute("icon");
System.out.println("uppload-result description " + description);
System.out.println("uppload-result title " + title);
System.out.println("uppload-result subject " + subject);
System.out.println("uppload-result grade " + grade);
System.out.println("uppload-result location " + location);
System.out.println("uppload-result  icon " + icon);

%>
	<div class="main">	
		
		<div class="row-1" style="font-size:12px">
			<a class="logo" href="index.jsp"></a> 
			
			<c:if test="${sessionScope.email != null}">
				Logged in as: <label style="color:#000"><c:out value="${sessionScope.email}"/></label> <a href="logout.do">(Log out)</a>
			</c:if>							
		</div>
		
<INPUT id=u18  type=text value="<%=title %>" readonly="readonly" style="position:absolute; left:342px; top:265px; width:308px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none"   >

<DIV id=u19 style="position:absolute; left:202px; top:272px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u19_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> Title</span></DIV></DIV>
<DIV id=u20 style="position:absolute; left:169px; top:190px; width:311px; height:22px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u20_rtf><span style=" color:#000099; font-size:19px;"><b>Resource Successfully Uploaded</b></span></DIV></DIV>

<!--  mike start -->
<INPUT  id=u21   type=text value="<%=subject %>" readonly="readonly" style="position:absolute; left:342px; top:310px; width:180px; height:22px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >

<DIV id=u22 style="position:absolute; left:201px; top:313px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u22_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> Subject</span></DIV></DIV>
<DIV id=u23 style="position:absolute; left:201px; top:360px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u23_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> Grade Level</span></DIV></DIV>
<DIV id=u24 style="position:absolute; left:200px; top:420px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u24_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> Description</span></DIV></DIV>
<TEXTAREA id=u25 value="<%=description %>" readonly="readonly" style="position:absolute; left:345px; top:430px; width:314px; height:92px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none"  ></TEXTAREA>

<INPUT id=u26  type=text value="<%=grade %>" readonly="readonly" style="position:absolute; left:345px; top:366px; width:180px; height:22px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >


<DIV id=u27 style="position:absolute; left:200px; top:550px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u27_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> Picture/Thumbnail</span></DIV></DIV>

<DIV id=u37 style="position:absolute; left:200px; top:590px; width:130px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u37_rtf><span style=" font-family:'Arial'; color:#FF0000; font-size:13px;">*</span><span style=" font-family:'Arial'; color:#000000; font-size:13px;"> File</span></DIV></DIV>

<!-- 
<INPUT id=u28  type=text value="" style="position:absolute; left:342px; top:548px; width:428px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none"   >


<INPUT id=u29  type=file value="Browse" size=60 style="position:absolute; left:342px; top:547px; width:500px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >
 -->
<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0" frameborder="0" scrolling="yes"></iframe>              
<form id="uploadFileForm" enctype="multipart/form-data" method="post" >
<INPUT id=u29  type=text value="<%=icon %>" readonly="readonly" style="position:absolute; left:342px; top:547px; width:500px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >
<!-- 
<INPUT id=u30  type="button" value="Add Content" onClick="performAjaxFileUpload();" style="position:absolute; left:842px; top:547px; width:80px; height:25px; ; ; text-align: center ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >
 -->
<INPUT id=u39  type=text value="<%=location %>" readonly="readonly" style="position:absolute; left:342px; top:587px; width:500px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >
<!--
<INPUT id=u40  type="button" value="Add Content" onClick="performAjaxFileUpload();" style="position:absolute; left:842px; top:587px; width:80px; height:25px; ; ; text-align: center ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none" >
  -->
</form> 

<script type="text/javascript">
    var rJsonu32 = {};
</script>

<DIV id=ru31 style="position:absolute; left:340px; top:630px; width:211px; height:41px;; overflow:visible; visibility:hidden">

<span style="position:absolute; left:-3px; top:-3px; width:219px; height:49px; ;
filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='Upload_files/ru31.png',sizingMethod='scale');
"><img style="width:219px; height:49px; filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);" 
src="Upload_files/ru31.png" border="0" alt=""></span>

</DIV>
<DIV id=ou31 style="position:absolute; left:340px; top:630px; width:211px; height:41px;; overflow:visible; ">

<span style="position:absolute; left:-3px; top:-3px; width:219px; height:49px; ;
filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='Upload_files/u31.png',sizingMethod='scale');
"><img style="width:219px; height:49px; filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);" 
src="Upload_files/u31.png" border="0" alt=""></span>

</DIV>
<DIV id=u31container style="position:absolute; left:340px; top:630px; width:211px; height:41px;; overflow:visible;">

<DIV id=u32 style="position:absolute; left:2px; top:9px; width:206px; height:22px; ; ; text-align: center ; font-family:Arial; text-align:left; word-wrap:break-word;" >
<DIV id=u32_rtf><div style="text-align:center"><span style=" color:#000000; font-size:19px;"><b>Back Home</b></span></div></DIV></DIV>
</DIV>
<!-- 
<INPUT type="image" id=u31 src="Resources/transparent.gif" style="position:absolute; left:340px; top:680px; width:210px; height:40px" onmouseover="ApplyImageAndTextStyles('r', 'u31', 'u32', rJsonu32, false);" onmouseout="ApplyImageAndTextStyles('o', 'u31', 'u32', '', false);"  >
 -->
<INPUT type="image" id=u31 src="Resources/transparent.gif" style="position:absolute; left:340px; top:630px; width:210px; height:40px" onmouseover="ApplyImageAndTextStyles('r', 'u31', 'u32', rJsonu32, false);" onmouseout="ApplyImageAndTextStyles('o', 'u31', 'u32', '', false);"  onClick="backHome();">

<SCRIPT src="Resources/axurerp_pagescript.js"></SCRIPT>
</div>

	<div style="width:100%;overflow:hidden;padding-top:600px;text-align:center">
	 	&copy;&nbsp;2012&nbsp;&#45;&nbsp;University&nbsp;of&nbsp;St.&nbsp;Thomas&nbsp;-&nbsp;SEIS&nbsp;752&nbsp;Team&nbsp;I
	</div>	
<!--  mike end -->

		
<SCRIPT src="Upload_files/axurerp_pagespecificscript.js"></SCRIPT>	
</body>
</html>