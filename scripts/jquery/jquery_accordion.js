$(document).ready(function() {
	$.each($('.expandable a.btn_expandable'), function() {  
		$(this).click(function(ev) {
			if ($(this).hasClass('expanded')){
				$('.inner_area', $(this).parent()).stop(true, true).slideUp("fast", dimensions);
				$(this).removeClass('expanded');
			}else{
				$('.inner_area', $(this).parent()).stop(true, true).slideDown("fast", dimensions);
				$(this).addClass('expanded');
			}
			
		});	
	});
	$('.expandable .inner_area').css('display','none');
});