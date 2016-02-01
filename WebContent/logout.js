/**
 * 
 */
function logout(){
  FB.logout(function(response) {
	  if(response.status==='connected'){
		  document.getElementById('status').innerHTML='connected';
		  		  }
	  else if(response.status==='not_authorized'){
		  document.getElementById('status').innerHTML='not connected';		  
		  }
		  else{
			  document.getElementById('status').innerHTML='not logged in';}
	  
	  	});
     location.reload();
  }