(function ($) {
// VERTICALLY ALIGN FUNCTION
$.fn.vAlign = function() {
	return this.each(function(i){
	var ah = $(this).height();
	var ph = $(this).parent().height();	
	var mh = Math.ceil((ph-ah) / 2);
	$(this).css('top', mh);
	});
};
})(jQuery);

$(document).ready(function() {
	//the container needs to be visible to 	
	$('.valign').each(function() {
		
		$(this).vAlign();								 
	});	
	
	
});

