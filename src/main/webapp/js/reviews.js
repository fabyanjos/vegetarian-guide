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
    					$('<article>').append(
    						$('<h4>').append(
    							$('<a>').text(review.restaurant.name).attr('href', '/restaurant/details/'+review.restaurant.id+'#'+review.id))
    							.append(
    							$('<span>').attr('class', 'light-green').text(date))).append(
    	    				$('<p>').text(review.description.substring(0,130))));
				}
    		} else {
    			alert("vazio");
    		}
		},
		error : function() {
			$("#lastReviews").append(
					$('<article>').attr('class', 'holder_news').append(
						$('<h4>').append(
							$('<span>'))).append(
	    				$('<p>').text('')));
		}
		}); 
 });