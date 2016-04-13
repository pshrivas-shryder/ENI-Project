/**
 * 
 */
window.fbAsyncInit = function() {
    FB.init({
      appId      : '1662797027322011',
      xfbml      : true,
      version    : 'v2.5'
    	  
    });
  
    FB.getLoginStatus(function(response){
 	   if (response.status==='connected'){
 		   document.getElementById('status').innerHTML=' connected';
 		   hideshow();
		   refresh();
 		   
 		   }
 		   else if(response.status='not_authorized'){
 			   document.getElementById('status').innerHTML='not connected';}
 		   else{
 			   document.getElementById('status').innerHTML='not logged into fb ';
 	   }
    });
    
  };
 
  
  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  	   function status()
  	   {
  		 FB.getLoginStatus(function(response){
  	 	   if (response.status==='connected'){
  	 		   document.getElementById('status').innerHTML=' connected';
  	 		   
  	 		   hideshow();
  			   refresh();
  	 		   
  	 		   }
  	 		   else if(response.status='not_authorized'){
  	 			   document.getElementById('status').innerHTML='not connected';
  	 			   $('#circle2').hide();
  	 			   $('#name').hide();
                   $('#comment').hide();
                   $('#imgs').hide();
                   $('#likes').hide();
                   $('#libtn').hide();
                   document.getElementById('status').style.visibility="visible";
             	  document.getElementById('button1').style.visibility="visible";
             	  document.getElementById('button2').style.visibility="visible";
  	 			   
  	 			   }
  	 		   else{
  	 			   document.getElementById('status').innerHTML='not logged into fb ';
  	 	   }
  	    });
  	    
  	   }
  	   
  function login()
  {
	  FB.login(function(response){
		  if(response.status==='connected'){
			  document.getElementById('status').innerHTML='connected';
			  refresh();
			  hideshow()
			  }
		  else if(response.status==='not_authorized'){
			  document.getElementById('status').innerHTML='not connected';}
			  else{
				  document.getElementById('status').innerHTML='not logged in';}
	  },true);
	  
  }
  function refresh()
  {
	 album();
  }
  function hideshow(){
	  document.getElementById('status').style.visibility="hidden";
	  document.getElementById('button1').style.visibility="hidden";
	  document.getElementById('button2').style.visibility="hidden";
	  }