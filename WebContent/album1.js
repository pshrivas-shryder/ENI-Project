
function album(){

	  var toggle=true;
	FB.api(
			  '/790876601057998','GET',{"fields":"albums{photos{picture,likes.summary(1).limit(0),comments.summary(1){from,message},name,created_time}}"},
			  function(response) {
				  var posts=response.albums.data.length;	  
			      var calls=posts;
			       i=0;
				  var l=response.albums.data[i].photos.data.length*5000;
		          var image;
		          var ima=[];
		           j=0;
                 count=0;
                
                 var myVar;
                 window.clearTimeout(myVar);
		         function loop(){
		         ( function next(i)	{console.log(i);
		         	  len=response.albums.data[i].photos.data.length;
	                  console.log("photos count:"+len);                
				       interval1=window.setInterval(function(){
				    	
				    	  //$('#cf').hide();
				    	  //$('#libtn').hide();
				    	  console.log("j:"+j)
				    	  image= document.createElement('img');
				          image.src= response.albums.data[i].photos.data[j].picture;
	                 	  document.getElementById('imgs').innerHTML='<img src="'+image.src+'">';
	                 	  //$('#imgs').hide();
			              likes=response.albums.data[i].photos.data[j].likes.summary.total_count;
			              document.getElementById('likes').style.textAlign="center";
		                  document.getElementById('likes').innerHTML=likes+"Likes";
		                  //$('#likes').hide();
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
		                     //$('#name').hide();
		                     document.getElementById('comment').innerHTML=cmt;
		                     //$('#comment').hide();
		                     }  
		                 /*$('#myList').show();
		                 $('#tweet_img').show();*/
		                  if(toggle){
		                	  $(".twee").hide();
		                      $(".fb").hide().fadeIn(1000);
		                  
		                  toggle=false;}
		                  else
		                	  {
		                	  $(".fb").hide();
		                	  $(".twee").hide().fadeIn(1000);
		                	  toggle=true;
		                	  }
		                  j++;
		                  count++;
		                     /*var id=((toggle==true)?'facebook':'twitter');
		                    
		                     (function toggleDiv(divId) {
		                    	 
		                    	if(toggle){
		                    		toggle=false;
		                    		$('#cf').show();
				                     $('#circle2').show();
				                     $('#name').show();
				                     $('#comment').show();
				                     $('#imgs').show();
				                     $('#likes').show();
				                     $('#libtn').show();
			                    	 $("#"+divId).slideToggle();
		                 		     j++;
				                     count++;
		                    	}else{
		                    		toggle=true;
		                    		$('#myList').show();
		                    		$('#tweet_img').show();
		                    		$("#"+divId).slideToggle();
				                    

		                    	}
		                    	 })(id);*/
				            console.log("count"+count+"len"+len);
				          if(count==len){
				    		 console.log("set interval");
				    		 j=0;
				    		 count=0;
				    		window.clearInterval(interval1);
				          }
				        /*  $(function(){
				        	  $(this).closest('div').next().slideToggle();
				        	});*/
				         
					     // interval1=window.setTimeout(loop1,5000);
	              },5000);		
				    
				      calls--;
                      /*if(calls==0){
                    	  console.log("set interval1");
        	               window.clearInterval(interval); 
        	               }*/
				      j=0;
			          count=0;
			          //loop1();
                      l=(response.albums.data[i].photos.data.length)*5000;
                      //console.log("l:"+l);
                      //window.setTimeout(loop,l);
                      myVar=window.setTimeout(function(){if(i!=posts){i++;next(i);}},l);
		        	  //}
		        	
		        	})(i);
		          
		          }
		          if(calls!=0){
		          console.log("here");
		          loop();
		          }
		      	setTimeout(function(){ window.clearInterval(interval1);window.clearTimeout(myVar);status();},60000);
		         
			  });	      
}
/*function toggleDivs($this){
    var $that = ($this.attr('id') === 'facebook' ? $('#tweet','#tweet_img') : $('#facebook'));

    $this.animate({right:1},1000,function(){
        toggleDivs($that);
    });
}*/