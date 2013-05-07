$(window).load(function () {
  $.ajax({
		type : "GET",
		async : false,
		url : "/restaurant/review/list/4",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		processData : true, 
		success : function(result) {
			if((result != null)) {
				for(var i = 0; i < result.length; i++) {
					var review = result[i];
					var date = new Date(review.date).toString('dd/MM/yy HH:mm');
    				$("#lastReviews").append(
    					$('<article>').attr('class', 'holder_news').append(
    						$('<h4>').text(review.restaurant.name).append(
    							$('<span>').text(date))).append(
    	    				$('<p>').text(review.description)));
				}
    		} else {
    			alert("vazio");
    		}
		},
		eror : function() {
			$("#lastReviews").append(
					$('<article>').attr('class', 'holder_news').append(
						$('<h4>').append(
							$('<span>'))).append(
	    				$('<p>').text('not found')));
		}
		}); 
 });