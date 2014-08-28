function numberText(number) {
	var text = "no";
	switch(number) {
		case 1: text = "one"; break;
		case 2: text = "two"; break;
		case 3: text = "three"; break;
		case 4: text = "four"; break;
		case 5: text = "five"; break;
	}
	return text;
}

$(document).ready(function () {
	if($('#carousel').length > 0) {
		$('#carousel').photobox('a',{ time:0 });
		
		// using a callback and a fancier selector
		//----------------------------------------------
		$('#carousel').photobox('li > a.family',{ time:0 }, callback);
		function callback() {
		   console.log('image has been loaded');
		}
		
		//-----------------------------------------------
		$('#carousel').photobox('prepareDOM');
		
		$('#carousel ul').carouFredSel({
		    prev: '#prev',
		    next: '#next',
		    pagination: "#pager",
		    auto: false,
		    scroll: 1000,
		    pauseOnHover: true
		});
	}
	if($('#number').length > 0) {
		$('#number').keypress(function (e) {
			if (String.fromCharCode(e.keyCode).match(/[^0-9]/g)) return false;
		});
	}
});

function setRating(name, value) {
	var rating = $('input[name=' + name + ']');
	for(var i = 1; i < 6; i++) {
		if(rating[i].value == value)
			$(rating[i]).attr('checked', 'checked'); 
	}
}

function setPrice(name, value) {
	var price = $('input[name=' + name + ']');
	for(var i = 1; i < 5; i++) {
		if(price[i].value == value)
			$(price[i]).attr('checked', 'checked'); 
	}
}

// Home banner
$(function() {
    $('#slides').slidesjs({
      width: 1024,
      height: 300,
      play: {
        auto: false,
        effect: "fade",
        interval: 4000
      },
      navigation: {
      	active: false,
          effect: "fade"
      },
      pagination: {
      	active: false,
          effect: "fade"
      },
      effect: {
          fade: {
            speed: 500,
              // [number] Speed in milliseconds of the fade animation.
            crossfade: true
              // [boolean] Cross-fade the transition.
          }
      }
    });
  });