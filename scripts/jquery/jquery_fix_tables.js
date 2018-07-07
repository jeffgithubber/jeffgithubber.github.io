function fixTables(){		
	$("tbody tr:even").addClass("row_1");
	$("tbody tr:odd").addClass("row_2");
	
	$("table tr:last-child").addClass("last_row");
	$("table tr:first-child").addClass("first_row");	
	$('table tbody tr th').each(function() {		
		$(this).wrapInner("<div class='cell_wrapper'></div>");		
	});
	
	/*
	if ($.browser.msie) {
		$('table thead tr th').each(function() {		
			$(this).css('height', '39px');		
		});	
	}
	*/	
}

$(document).ready(function(){	
	fixTables();	
});

