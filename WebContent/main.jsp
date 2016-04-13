
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css"> 
<script src="http://summerofgoto.com/js/parseScripts.js"></script>
<script src="http://summerofgoto.com/js/goto.min.js"></script>
<script type="text/javascript" src="libs/jquery-1.10.2.min.js"></script>

<script>

$(document).ready(function() {
	
	$.ajax({
	    type : "GET",
	    url : "WhatToThink",
	    contentType :"text/html;charset=UTF-8",
	    success : function(data) {
	  	
	  	  $('#myList').html(data); 
	  	 $("#tweet_img").hide().fadeIn(1000);
	  	 $("#myList").hide().fadeIn(1000);
	  	  }
	   
	 });
	 
   var x=setInterval(function(){
    	 $.ajax({
   	      type : "GET",
   	      url : "WhatToThink",
   	      contentType :"text/html;charset=UTF-8",
   	      success : function(data) {
   	    	 
   	    	 $("#myList").html(data);
   	    	 $("#tweet_img").hide().fadeIn(1000);
   	    	 $("#myList").hide().fadeIn(1000);
   	    }
    	 });
     
    }, 60000);
  
});
</script>

</head>
<body bgcolor="#f6f6f6">
<script src="facebook.js"></script>
<script src="album1.js"></script>
<script src="logout.js"></script>
<table ><tr><td>
<div id="status"></div></td></tr>
<tr><td>
<div id="button1"><button id="login" onclick="login()">Login</button></div></td>
<td><div id="button2"><button id="logout" onclick="logout()">Logout</button></div></td><td>
</td>
<td >
<div id="carousal">
<%@ include file="testdrive.jsp" %></div></td>
</tr></table>
<div id="circle"><img src="images/fb.png"  style="background-color:#66FFFF"></div>
<div id="circle1" style="font-family: 'Lato', sans-serif;color: #5a5a5a;"></div>
<div id="container" align="center">


<table  id="table"style="border-color:green;">
<tr>
<td id="facebook">
<table style="border-color:red;">
<tr>
<td id="cf" align="left" width="100px"><img class="top"src="images/fbicon.png" height="60px" width="60px" /></td>
<td id="circle2"align="left"><div></div></td>
<td id="name" width="150px"align="center" style="font-family: 'Lato', sans-serif;color: #5a5a5a;" >
</td>
<td id="comment" width="80%" align="center" style="font-family: 'Lato', sans-serif;color: #5a5a5a;"></td>
<td id="imgs" align="right" style="width:200px"></td>
</tr>
<tr><td></td><td id="libtn"align="right"><img src="images/fb.png"height="10" width="10"align="right"/></td><td id="likes" style="font-family: 'Lato', sans-serif;color: #5a5a5a;" align="left"></td></tr>
</table>
</td>
</tr>
<tr>
<td id="tweet_img" >
 <img class="bottom" src="images/tweet.png" height="60" width="60" />
</td>
<td id="tweet"width="50%">
<div id ="display2" align="right" >
<div id=d4  style="font-family: lato;">
<div id="myList" style="font-family: 'Lato', sans-serif;color: #5a5a5a;width:300px;">
</div>
<script>
var x = document.getElementById("myList").innerHTML;
</script>
</div>
</div>
</td>
</tr>
</table>
</div>
</body>
</html>