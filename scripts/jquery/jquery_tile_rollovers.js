$(document).ready(function() {
	
	//set uinuqe id against the list items incase we need to override default behaviour
	var count = 0;
	$('.tile_list li').each(function() {
		$(this).attr('id', 'tile_list'+count);
		count++;
	});
	
	
	//START HIGHLIGHT LIST
	//in which all items in the list are faded except the one in focus	
	//init the list
	$('.high_light li img').stop(true, false).fadeTo(0, .5);
	$('.high_light li.active img').stop(true, false).fadeTo(0, 1);
	//END HIGHLIGHT LIST
	
	
	//START ROLLOVER LIST
	//lists where black boxes appear with valigned text inside of them
	$('.tile_list.rollover_list li').hover(function() {
		$('.description',this).stop(true, true).slideUp('slow');		
	}, function() {
		$('.description',this).stop(true, true).slideDown('slow');	
	});	
	
	
	//END ROLLOVER LIST
	



});