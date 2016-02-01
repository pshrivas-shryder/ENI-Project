<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="60" />
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css"> 
<link rel="stylesheet" href="eni.css" type="text/css"> 
<script type="text/javascript">

/*var visible = true;
setInterval(function(){
    document.getElementById('container').style.visibility = visible ? 'hidden' : 'visible'; // use short if/else to decide which value to user
   document.getElementById('display').style.visibility    = visible ? 'visible' : 'hidden'; // short if/else is called ternairy
    visible = !visible; // reverse the value of itself
}, 7000);*/


</script>
</head>
<body>
<script src="facebook.js"></script>
<script src="album1.js"></script>
<script src="logout.js"></script>



<div id="status"></div>
<div id="buttons"><button id="login" onclick="login()">Login</button>
<button id="logout" onclick="logout()">Logout</button></div>
<div id="circle"><img src="images/fb.png"  style="background-color:#66FFFF"></div>
<div id="circle1"></div>

<div id="container" align="center">

<table style="border-collapse:collapse;border-color:#FFFFFF">
<tr>
<td>
<table style="border-collapse:collapse;border-color:#FFFFFF">
<tr>
<td id="circle2"></td>
<td id="name" align="left">
</td>
<td id="comment" align="left"></td>
</tr>
</table>
</td>
</tr>
<tr><td id="imgs"></td></tr>
<tr><td id="des"></td></tr>
<tr>
<td width="300%">
<div id ="display2" align="right" >
<div id = d3 >
<input type = "image" src="images/tweet.png" onClick="location.href='WhatToThink'">
</div> 
<div id=d4  style="font-family: lato;">
<div id="myList" style ="width:300px;">
<p>${lis}</p> 
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