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
    				$("#restaurantsListHome").append(
    	    				$('<article>').attr('class', 'holder_gallery').append(
	    						$('<a>').attr('class', 'photo_hover2').append(
	    							$('<image>').attr('src', '/images/picture2.jpg'))).append(
	    					$('<h2>').text(r.name.substring(0,50))).append(
	    					$('<p>').text(r.description.substring(0,200))).append(
	    					$('<span>').attr('class', 'readmore').append(
	    						$('<a>').attr('href', 'http://localhost:8080/restaurant/details/' + r.id).text('details'))));
    				
//    				 <article class="holder_gallery">
//    				   <a class="photo_hover2" href="#"><img src="/images/picture2.jpg" width="150" height="99" alt="picture1"/></a>
//    				   <h2>Lorem ipsum</h2>
//    				   <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec molestie. Sed aliquam sem ut arcu. Phasellus sollicitudin. 
//    				   Vestibulum condimentum  facilisis nulla. In hac habitasse platea dictumst.
//    				   </p> <span class="readmore"><a href="#">Read more..</a></span>
//    				   </article>
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