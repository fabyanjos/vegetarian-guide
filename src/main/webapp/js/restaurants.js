$(window).load(function () {
  $.ajax({
		type : "GET",
		async : false,
		url : "/restaurant/list/2",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		processData : true, 
		success : function(result) {
			if((result != null)) {
				for(var i = 0; i < result.length; i++) {
					var r = result[i];
					var link = 'http://localhost:8080/restaurant/details/' + r.id;
    				$("#restaurantsListHome").append(
    	    				$('<article>').attr('class', 'holder_gallery').append(
	    						$('<a>').attr('href', link).attr('class', 'photo_hover2').append(
	    							$('<image>').attr('src', '/images/picture2.jpg'))).append(
	    					$('<a>').attr('href', link).append($('<h2>').text(r.name.substring(0,50)))).append(
	    					$('<p>').text(r.description.substring(0,300))));
//	    					.append(
//	    					$('<span>').attr('class', 'readmore').append(
//	    						$('<a>').attr('href', link).text('details'))));
				}
    		} else {
    			alert("vazio");
    		}
		},
		eror : function() {
			$("#restaurantsListHome").append(
					$('<article>').attr('class', 'holder_news').append(
						$('<h4>').append(
							$('<span>'))).append(
	    				$('<p>').text('not found')));
		}
		}); 
 });