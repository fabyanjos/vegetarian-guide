$(window).load(function () {
  $.ajax({
		type : "GET",
		async : false,
		url : "/restaurant/review/list/3",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		processData : true, 
		success : function(result) {
			if((result != null)) {
				console.log('JS');
				for(var i = 0; i < result.length; i++) {
					var review = result[i];
					var date = new Date(review.date).toString('dd/MM/yy HH:mm');
					var title = review.title.substring(0,23).trim();
					if(review.title.length > 23)
						title += '...';
					var text = review.description.substring(0,130).trim();
					if(review.description.length > 130)
						text += '...';
    				$("#lastReviews").append(
    					$('<article>').append(
    						$('<h5>').append(
    							$('<a>').text(title).attr('href', '/restaurant/details/'+review.restaurant.id+'#'+review.id))
    							).append(
    	    				$('<p>').text(text)));
				}
				$('#reviewLoading').attr('style', 'display:none;');
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