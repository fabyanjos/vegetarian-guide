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
	$('#carousel').photobox('a',{ time:0 });
	
	// using a callback and a fancier selector
	//----------------------------------------------
	$('#carousel').photobox('li > a.family',{ time:0 }, callback);
	function callback() {
	   console.log('image has been loaded');
	}
	
	// destroy the plugin on a certain gallery:
	//-----------------------------------------------
//	$('#gallery').data('_photobox').destroy();
	
	// re-initialize the photbox DOM (does what Document ready does)
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
});