
var isset = false;
function dimensions(){
	
	$('body').css('padding-bottom','0px');
	$('#footer').css('top','0px');
	
	$('body').css('height', 'auto');	
	
	var borders = 40;
	var calculated_width = $(window).width() - borders;
	if (calculated_width < 1000){
		calculated_width = 960;
	}
	var calculated_height;
	
	//as the right column is relative and the left column is absolute
	//if the left column is taller than the right column we need to override its height	
	$('#right_region_main').css('height', 'auto');
	if ($('#right_region_main').height() < $('#left_region_main').height() ){
		$('#right_region_main').css('height', $('#left_region_main').height()-borders);
	}

	if ($(document).height() > $(window).height()){
		calculated_height = $(document).height() - borders;		
	}else{
		calculated_height = $(window).height() - borders;	
	}


	$('#footer').css('top',(calculated_height - 60)+'px');

	$('body').css('height', (calculated_height)+"px");	
	
	$('body').css('width', (calculated_width)+"px");	
	
	
	//if flow layout dont add 8		
	$.each($('.tile_list_with_pagination'), function() {   	
		var container_width = $('.tile_list',this).width() + 8;
		var tile_width_with_padding = 119;
		var num_of_tiles = Math.floor(container_width / tile_width_with_padding);
		var pagination_width = (tile_width_with_padding * num_of_tiles) - 8;
		$('.pagination',this).css('width', pagination_width+ 'px');
	});
	

}

$(window).resize(function() {
	dimensions();
});

$(document).ready(function() {
	dimensions();
});
