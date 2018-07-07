$(document).ready(function(){
	$("ul li:last-child").addClass("last_item");
	$("ul li:first-child").addClass("first_item");	


	$.each($('ul.jquery_picker'), function() {   	
		var class_name=$(this).attr('class');
		classes = class_name.split(" ");
		var num_cols = -1;
		for (var i = 0; i < classes.length; i++){			
			//if after splitting the class starts with a num_cols_
			if (classes[i].indexOf("num_cols_") >= 0){				
				num_cols = classes[i].split("num_cols_")[1];				
			}
		}
		
		if (num_cols > 0){
			var count = 0;
			$.each($('li', this), function() {   	
				count++;
				if (count % num_cols == 0){
					$(this).addClass('list_break');
				}				
			});
		}		
	});		
});