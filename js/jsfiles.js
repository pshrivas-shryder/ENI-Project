//our 4 items	
var $listItems 		= $('#rm_container > ul > li'),
	totalItems		= $listItems.length,
	
	//the controls
	$rm_next		= $('#rm_next'),
	$rm_prev		= $('#rm_prev'),
	$rm_play		= $('#rm_play'),
	$rm_pause		= $('#rm_pause'),
	
	//the masks and corners of the slider
	$rm_mask_left	= $('#rm_mask_left'),
	$rm_mask_right	= $('#rm_mask_right'),
	$rm_corner_left	= $('#rm_corner_left'),
	$rm_corner_right= $('#rm_corner_right'),
	
	//check if the browser is <= IE8
	ieLte8			= ($.browser.msie && parseInt($.browser.version) <= 8),

RotateImageMenu	= (function() {
...
})();
	
RotateImageMenu.init();

