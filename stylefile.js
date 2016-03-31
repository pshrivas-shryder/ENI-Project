<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Rotating Image Slider with jQuery & CSS3</title>
	<meta charset="UTF-8" />
        <meta name="description" content="Rotating Image Slider with jQuery & CSS3" />
        <meta name="keywords" content="jquery, rotation, slider, images, slideshow, autoplay, play, pause, css3"/>
	<meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
	<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css' />
	<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
	<script type="text/javascript">
		// Don't use this code on your site
  		var _gaq = _gaq || [];
  		_gaq.push(['_setAccount', 'UA-7243260-2']);
 		_gaq.push(['_trackPageview']);

  		(function() {
    			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  		})();
	</script>
<script type="text/javascript">
	<!--
		if (top.location!= self.location) {
			top.location = self.location.href
		}
	//-->
</script>
<style>#adpack-wrapper{top:5px !important;}</style>
    </head>
    <body>
		<div class="content">
			<h1>Rotating Image Slider</h1>
			<div class="rm_wrapper">
				<div id="rm_container" class="rm_container">
					<ul>
						<li data-images="rm_container_1" data-rotation="-15"><img src="images/1.jpg"/></li>
						<li data-images="rm_container_2" data-rotation="-5"><img src="images/2.jpg"/></li>
						<li data-images="rm_container_3" data-rotation="5"><img src="images/3.jpg"/></li>
						<li data-images="rm_container_4" data-rotation="15"><img src="images/4.jpg"/></li>
					</ul>
					<div id="rm_mask_left" class="rm_mask_left"></div>
					<div id="rm_mask_right" class="rm_mask_right"></div>
					<div id="rm_corner_left" class="rm_corner_left"></div>
					<div id="rm_corner_right" class="rm_corner_right"></div>
					<h2>Fashion Explosion 2012</h2>
					<div style="display:none;">
						<div id="rm_container_1">
							<img src="images/1.jpg"/>
							<img src="images/5.jpg"/>
							<img src="images/6.jpg"/>
							<img src="images/7.jpg"/>
						</div>
						<div id="rm_container_2">
							<img src="images/2.jpg"/>
							<img src="images/8.jpg"/>
							<img src="images/9.jpg"/>
							<img src="images/10.jpg"/>
						</div>
						<div id="rm_container_3">
							<img src="images/3.jpg"/>
							<img src="images/11.jpg"/>
							<img src="images/12.jpg"/>
							<img src="images/13.jpg"/>
						</div>
						<div id="rm_container_4">
							<img src="images/4.jpg"/>
							<img src="images/14.jpg"/>
							<img src="images/15.jpg"/>
							<img src="images/16.jpg"/>
						</div>
					</div>
				</div>
				<div class="rm_nav">
					<a id="rm_next" href="#" class="rm_next"></a>
					<a id="rm_prev" href="#" class="rm_prev"></a>
				</div>
				<div class="rm_controls">
					<a id="rm_play" href="#" class="rm_play">Play</a>
					<a id="rm_pause" href="#" class="rm_pause">Pause</a>
				</div>
			</div>
		</div>
		<div class="footer">
			<a class="left" href="http://tympanus.net/Development/RestaurantTemplate/"><span>&laquo; Previous Demo:</span> Restaurant Website and Gallery Template</a>
			<a href="http://tympanus.net/codrops/2011/04/28/rotating-image-slider/"><strong>back to the Codrops tutorial</strong></a>
			<a href="http://www.behance.net/AndrewLili" target="_blank">Photos by Andrew & Lili</a>
		</div>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.transform-0.9.3.min_.js"></script>
		<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
		<script type="text/javascript" src="js/jquery.RotateImageMenu.js"></script>
	<script src="http://tympanus.net/codrops/adpacks/demoad.js"></script>
    </body>
</html>