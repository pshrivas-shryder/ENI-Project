<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <link rel="Stylesheet" type="text/css" href="css/smoothTouchScroll.css" />
    <link rel="stylesheet" href="dist/jquery.rondell.css" type="text/css" media="all" title="Screen">
    <script type="text/javascript" src="libs/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="libs/modernizr-2.0.6.min.js"></script>
    <script type="text/javascript" src="dist/jquery.rondell.js"></script>
    <link rel="Stylesheet" type="text/css" href="css/smoothTouchScroll.css" />
     <link rel="Stylesheet" type="text/css" href="css/style1.css" />
    <style type="text/css">
    #TouchScroller
    {
    position:relative;
    left:780px;
    bottom:300px;
    width:100%;
    height:auto;
    }
#TouchScroller div.scrollableArea img
{
    
	position: relative;
	float: left;
	padding: 0;
	margin: 0px 5px;
	width:60px;
	
	/*height:20%;*/
	
	
	
}

		</style>
		
	   
	   <script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	   <script src="js/jquery.kinetic.min.js"></script>
	   <script src="js/jquery.smoothTouchScroll.min.js"></script>

</head>
<body>
<div id="page">

     <sql:setDataSource var="webappDataSource"
    driver="com.mysql.jdbc.Driver" url="jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support"
    user="db_user" password="password123" />

     <sql:query dataSource="${webappDataSource}"
    sql="select imgid  from carousel_three" var="result1" />
     
  
   
      
<div id="car1" class="carousel">    
<div id="rondellCarousel" class="hidden">
  
           <c:forEach var="row" items="${result1.rows}"> 
         
                  
            <img id="img" src="${pageContext.servletContext.contextPath }/Imagedb?id=${row.imgid}"  /> 
          
       
 
     </c:forEach>  
 </div>
</div>
</div>
<script type="text/javascript">
var click_count=new Array();
var swipe_count=new Array();
var count1;
$(document).ready(function() {
	
	for(i=1;i<=10;i++){
		click_count[i]=0;
		swipe_count[i]=0;
		//alert(i+"count"+count[i]);
		
	}
});
  $(function() {
   
    $("#rondellCarousel").rondell({
      preset: "carousel",
      
      onAfterShift:function(idx){
    	  var ip_addrs;
    	  $.getJSON("http://jsonip.com/?callback=?", function (data) {
    	  ip_addrs=data.ip;
       	  $.ajax({
    	      type : "GET",
    	      url : "Log_swipe_count",
    	      data:{co:++swipe_count[idx],ip_addr:ip_addrs,id:idx},
    	      success : function(data) {}
    	  });
    	  $('.favo').html('') ;
    	  var im = $('<img class="fav">'); 
    	  im.attr('src','images/images.png');
    	  im.attr('id','im'+idx);
    	  im.appendTo('.favo').after("").hide().fadeIn(1000);
    	  $('.fav').click(function(){
    	  $.get("Log_click_count1",{count:++click_count[idx]}, function(data) {    	    	  
    	      });
      });
    	  });
    	  itemLoadCallback: trigger(idx)
    	
      }
    });
  });


  function trigger(idx, state)
  {
	  
	  $('.scrollableArea').html('') ;
	  $('#heart').hide();
	  $.ajax({
	      type : "GET",
	      url : "Sampleimage1",
	      contentType :"application/json",
	      data:{id:idx},
	      success : function(data) {
	    	 
	    	  $('#heart').after("").hide().fadeIn(1000);
	    	  
	    	    $.each(data,function(index,item){	
	    	    
	    			 $.each(item,function(i,obj){
	    				 var img = $('<img class="dynamic" id>'); //Equivalent: $(document.createElement('img'))
	    				 img.attr('src','data:image/jpg;base64,' +obj.map.key );
	    				 img.appendTo('.scrollableArea').after("").hide().fadeIn(1000);
	    				/* var d=$('<div>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqsapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc</div>');
	    				 $('.dynamic ').on('click',function(){
	    					$('#container').hide();
	    				   d.appendTo('#TouchScroller').hide().fadeIn(1000);
	    				 });*/
	    				// setInterval(function(){d.remove();$('#container').show();},5000);
	    				    				 
	            
	                
	    		 });
	          });
	    	
	    	    
	 	 
	    	  
          }
	      
	    });
	  
	
  }
  </script>
  <div id="heart" class="favo"> </div>
 <div id ="car2" class="carousel1">
 
<div id="TouchScroller">
</div>
		
</div>		
<script>
//Initialize the plugin with no custom options

$("#TouchScroller").smoothTouchScroll({ 
	continuousScrolling: true
});
</script>
			
</body>
</html>