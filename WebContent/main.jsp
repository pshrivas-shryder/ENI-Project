
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
 var i = 0;
 var id=0;
 function buttonClick() {
 i++;
 document.getElementById('circle1').style.textAlign="center";
 document.getElementById('circle1').innerHTML ='<br>'+'<br>'+ i;
 var date=01-04-2016;
 var date1=new Date();
 if(date==date1.toLocaleDateString)
 {
	 id=0;
	 
 }
 else
	 {
	 id++;
	 
	 }
 $.ajax({
     type : "GET",
     url : "likesservlet",
     data:{id:id,wow:i},
     success : function(data) {
    	 
     }
     });
 }
 
 </script>
<script>

$(document).ready(function() {
	
	$.ajax({
	    type : "GET",
	    url : "WhatToThink",
	    contentType :"text/html;charset=UTF-8",
	    success : function(data) {
	  	$('#marketting').slideToggle('slow');
	  	  $('#myList').html(data); 
	  	$("#tweet_img").hide();
	  	 $("#myList").hide();
	  	  }
	   
	 });
	 
   var x=setInterval(function(){
    	 $.ajax({
   	      type : "GET",
   	      url : "WhatToThink",
   	      contentType :"text/html;charset=UTF-8",
   	      success : function(data) {
   	   	$('#marketting').slideToggle('slow');
   	    	 $("#myList").html(data);
   	    	$("#tweet_img").hide()	;
			 $("#myList").hide();
				}
			});

		}, 10000);

	});
</script>
<style>
#lightBoxbg{
display: none;
    position: absolute;
    top: 50%;
    left: 50%;
    width: 300px;
    height: 200px;
    margin-left: -150px;
    margin-top: -100px;                 
    padding: 10px;
    border: 2px solid #FFF;
    background: #CCC;
    z-index:1002;
    overflow:hidden;
}
#lightBoxbg img{
height:200px;
width:300px;
}
#lightBox{

display: none;
    position: fixed;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: #000;
    z-index:1001;
    -moz-opacity: 0.7;
    opacity:.70;
    filter: alpha(opacity=70);}
</style>
<script>
function display(){
var lbBg=document.getElementById('lightBoxbg');
var lb=document.getElementById('lightBox');
lbBg.style.display="block";
lb.style.display="block";}
function dismiss(){
	var lbBg=document.getElementById('lightBoxbg');
	var lb=document.getElementById('lightBox');
	lbBg.style.display="none";
	lb.style.display="none";}
</script>

</head>
<body bgcolor="#f6f6f6">
<script src="facebook.js"></script>
<script src="album1.js"></script>
<script src="logout.js"></script>
<div id="lightBoxbg" ><img src="images/campaign.jpg"></div>
<div id="lightBox" onClick="dismiss()"></div>
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
<div id="circle"><img src="images/fb.png"  onClick="buttonClick()" alt="Like" style="background-color:#66FFFF"></div>
<div id="circle1" style="font-family: 'Lato', sans-serif;color: #5a5a5a;font-weight:bold"></div>
<div id="container" align="center">
<div id="facebook">
<table style="border-color:red;">
<tr>
<td id="cf" class="fb"align="left" width="100px"><img class="top"src="images/fbicon.png" height="60px" width="60px" /></td>
<td id="circle2"class="fb" align="left"><div></div></td>
<td id="name" class="fb" width="150px"align="center" style="font-family: 'Lato', sans-serif;color: #5a5a5a;" >
</td>
<td id="comment" class="fb" width="80%" align="center" style="font-family: 'Lato', sans-serif;color: #5a5a5a;"></td>
<td id="imgs" class="fb" align="right" style="width:200px"></td>
</tr>
<tr><td></td><td id="libtn" class="fb" align="right"><img src="images/fb.png"height="10" width="10"align="right"/></td><td id="likes" class="fb" style="font-family: 'Lato', sans-serif;color: #5a5a5a;" align="left"></td></tr>
</table>
</div>
<div id="twitter">
<table  id="table"style="border-color:green;">
<tr id="twitter" class="twee">

<td id="tweet_img" class="twee">
 <img class="bottom" src="images/tweet.png" height="60" width="60" />
</td>
<td id="tweet"width="50%">
<div id ="display2" align="right" >
<div id=d4  style="font-family: lato;">
<div id="myList" class="twee" style="font-family: 'Lato', sans-serif;color: #5a5a5a;width:300px;">
</div>
</div>
</div>
</td>
</tr>
</table>
</div>
</div>


<img src="images/campaign.jpg" id="marketting" onClick="display()" />
<div id="content" >Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didnt listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane</div>

</body>
</html>