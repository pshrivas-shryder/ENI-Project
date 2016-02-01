/**
 * 
 */

function album(){
	    var toggle =true;
	FB.api(
			  '/790876601057998','GET',{"fields":"albums{photos{picture,likes.summary(1).limit(0),comments.summary(1){from,message},name}}"},
			  function(response) {
				  var posts=response.albums.data.length;
				  console.log("album length"+posts);
				  var calls=posts;
				  var i=0,j=0;
		          var length=response.albums.data[i].photos.data[j].comments.summary.total_count;
		          var len=response.albums.data[i].photos.data.length;
		          console.log("photo count"+len);
		          var image;
		          var descrp;
		          i=i-1;
		          var interval=window.setInterval(function(){
		        	  i++;
	            	  len=response.albums.data[i].photos.data.length;
	                  console.log("photos count:"+len);
	                  console.log("i:"+i);
	                  var j=0;
	                  var count=0;
				      var interval1=window.setInterval(function(){
				    	  console.log("J:"+j)
				    	  
				    	  
			             
			              if(toggle){
			            	  
						      image= document.createElement('img');
				              image.src= response.albums.data[i].photos.data[j].picture;
			            	  document.getElementById('display2').style.visibility="hidden"; 
			            	  document.getElementById('imgs').style.visibility="visible"; 
			            	  document.getElementById('des').style.visibility="visible"; 
			            	  document.getElementById('comment').style.visibility="visible"; 
			            	  document.getElementById('name').style.visibility="visible"; 
			            	  document.getElementById('circle2').style.visibility="visible"; 
			            	  document.getElementById('d5').style.visibility="visible"; 
			            	  descrp=response.albums.data[i].photos.data[j].name;
			                  document.getElementById('des').innerHTML=descrp;
			              document.getElementById('imgs').innerHTML='<img src="'+image.src+'">';
			              likes=response.albums.data[i].photos.data[j].likes.summary.total_count;
			              document.getElementById('circle1').style.textAlign="center";
		                  document.getElementById('circle1').innerHTML="<br>"+"<br>"+likes+"Likes";
		                  response.albums.data[i].photos.data[j].comments.total_count;
		                  length=response.albums.data[i].photos.data[j].comments.summary.total_count;
		                  for(var k=0;k<length;k++){
		                	  var pro='/'+response.albums.data[i].photos.data[j].comments.data[k].from.id+'/picture';
			               	  FB.api(pro,'GET',{"type":"small"},
			            			  function(response) {
			            			      var im=document.createElement('img');
			            			      im.src=response.data.url;
			            			      document.getElementById('circle2').innerHTML='<img src="'+im.src+'">';
			            			  }
			            			);
		            	     var cmt=response.albums.data[i].photos.data[j].comments.data[k].message;
		                     var name=response.albums.data[i].photos.data[j].comments.data[k].from.name;
		                     document.getElementById('name').innerHTML=name+":";
		                     document.getElementById('comment').innerHTML=cmt;
		                     
		                    }  
			              
		                  
		                  j++;
				      count++;
				      
			              toggle = false;
			             }
			              
			              
			              else{
					     // alert("came here");
					      document.getElementById('imgs').style.visibility="hidden";
					      document.getElementById('des').style.visibility="hidden"; 
		            	  document.getElementById('comment').style.visibility="hidden"; 
		            	  document.getElementById('name').style.visibility="hidden"; 
		            	  document.getElementById('d5').style.visibility="hidden"; 
		            	  document.getElementById('circle2').style.visibility="hidden"; 
					      document.getElementById('display2').style.visibility="visible";
					     // mydis();
					      toggle=true;
					      
			              }
					      
			              
			             
				     
				      if(count==len){
				    	  window.clearInterval(interval1);}
	              },3000);
				      
				     
				      calls--;
                      if(calls==0){
        	               window.clearInterval(interval); }
                      
		             },10000);
	            	 
						 			  
			  }		  
				  
			);
}

function sleep(milliseconds) {
	  var start = new Date().getTime();
	  for (var i = 0; i < 1e7; i++) {
	    if ((new Date().getTime() - start) > milliseconds){
	      break;
	    }
	  }
}
function mydis() {
      if(!x){
    	alert("came here");	  
    // var y=x.toString();     
	 document.getElementById('display2').innerHTML=x;
      }
   // console.log(x);
}
