/**
 * 
 */


function album(){
	    var toggle =true;
	FB.api(
			  '/790876601057998','GET',{"fields":"albums{photos{picture,likes.summary(1).limit(0),comments.summary(1){from,message},name,created_time}}"},
			  function(response) {
				  var posts=response.albums.data.length;	  
			      var calls=posts;
			      var i=0;
				  var l=response.albums.data[i].photos.data.length*2*2000;
		          var image;
		          var ima=[];
		           j=0;
                  //m=0;
                 count=0;
		          i=i-1;
		         // l=l-1;
		         // var interval=window.setInterval(function(){
		          function loop(){
		        	//console.log("l"+l);
		        	  //i++;
		        	  if(posts!=i){
		        		 
		        	    	  i++;
		        	  len=response.albums.data[i].photos.data.length;
	                  console.log("photos count:"+len);
	                  console.log("i:"+i);
	                  
				      var interval1=window.setInterval(function(){
				    	  $('#cf').hide();
				    	  $('#libtn').hide();
				    	  console.log("j:"+j)
				    	  image= document.createElement('img');
				          image.src= response.albums.data[i].photos.data[j].picture;
	                 	  document.getElementById('imgs').innerHTML='<img src="'+image.src+'">';
	                 	  $('#imgs').hide();
			              likes=response.albums.data[i].photos.data[j].likes.summary.total_count;
			              document.getElementById('likes').style.textAlign="center";
		                  document.getElementById('likes').innerHTML=likes+"Likes";
		                  $('#likes').hide();
		                  response.albums.data[i].photos.data[j].comments.total_count;
		                  length=response.albums.data[i].photos.data[j].comments.summary.total_count;
		                  document.getElementById('name').innerHTML="";
		                  document.getElementById('comment').innerHTML="";
		                  document.getElementById('circle2').innerHTML="";
		                  for(var k=0;k<length;k++){
		                	  
		                	  var pro='/'+response.albums.data[i].photos.data[j].comments.data[k].from.id+'/picture';
			               	  FB.api(pro,'GET',{"type":"small"},
			            			  function(response) {
			               	
			            			      im=document.createElement('img');
			            			      im.src=response.data.url;
			            			      document.getElementById('circle2').innerHTML='<img src="'+im.src+'">'+"<br />";
			            			      
			            			      
			               	  }
			               	  );
			               
		            	     cmt=response.albums.data[i].photos.data[j].comments.data[k].message;
		                     name=response.albums.data[i].photos.data[j].comments.data[k].from.name;
		                     document.getElementById('name').innerHTML=name+":";
		                     $('#name').hide();
		                     document.getElementById('comment').innerHTML=cmt;
		                     $('#comment').hide();
		                                 }  
		                     $('#cf').hide().fadeIn(1000);
		                     $('#circle2').hide().fadeIn(1000);
		                     $('#name').hide().fadeIn(1000);
		                     $('#comment').hide().fadeIn(1000);
		                     $('#imgs').hide().fadeIn(1000);
		                     $('#likes').hide().fadeIn(1000);
		                     $('#libtn').hide().fadeIn(1000);
		                     
		                    j++;
		                   // m++;
				            count++;
				            console.log("count"+count+"len"+len);
				           // alert("came here");
					     // mydis();
					      if(count==len){
				    		 console.log("set interval");
				    		 j=0;
				    		 count=0;
			        		 window.clearInterval(interval1);
			        		 }
				    	 
	              },5000);				     
				      calls--;
                      /*if(calls==0){
                    	  console.log("set interval1");
        	               window.clearInterval(interval); 
        	               }*/
                      l=response.albums.data[i].photos.data.length*5000;
                      window.setTimeout(loop, l)
		             }//,60000);
		          }
		          if(calls!=0){
		          loop();}
			  });
	     
	      var set=window.setInterval(function(){
	    	    
	      document.getElementById('display2').style.visibility="visible";},6000);
	      
}

