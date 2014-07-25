var map, places, iw;
var markers = [];
var autocomplete;
var geocoder;
var myLatlng = new google.maps.LatLng(-14.2400732,-53.1805017);
var myOptions = {
	zoom : 4,
	center : myLatlng,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};
function initialize() {
	geocoder = new google.maps.Geocoder();
	
	map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);
	
	var options = {
	  componentRestrictions: {country: 'br'}
	};

	autocomplete = new google.maps.places.Autocomplete(document.getElementById('address'), options);
}

function codeAddress() {
	clearMarkers();
	var address = document.getElementById("autocomplete").value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {

			map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);
			map.setCenter(results[0].geometry.location);
			map.setZoom(16);

			markers[0] = new google.maps.Marker({
				map : map,
				position : results[0].geometry.location
			});
			iw = new google.maps.InfoWindow({
				content : getIWContent(results[0]),
			});
			iw.open(map, markers[0]);
		} else {
			alert("Geocode was not successful for the following reason: " + status);
		}
	});
}

function createMark(index, lat, lng, name) {
	var location = new google.maps.LatLng(lat, lng);
	markers[index] = new google.maps.Marker({
    	map: map,
        position: location,
        icon: '/images/marker-green.png'
	});
	iw = new google.maps.InfoWindow({});
	google.maps.event.addListener(markers[index], 'click',
	    function(){
			iw.close();//hide the infowindow
			iw.setContent($('#infoWindow'+index).html());//update the content for this marker
			iw.open(map, markers[index]);//"move" the info window to the clicked marker and open it
	    }
	);
}

function setOrigin(lat, lng, details) {
	geocoder = new google.maps.Geocoder();
	map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);
	var location = new google.maps.LatLng(lat, lng);
	map.setCenter(location);
    map.setZoom(14);
    markers[0] = new google.maps.Marker({
    	map: map,
        position: location,
        icon: '/images/marker-blue.png'
	});
	iw = new google.maps.InfoWindow({});
	google.maps.event.addListener(markers[0], 'click',
	    function() {
			iw.close();//hide the infowindow
			iw.setContent($('#'+details).html());//update the content for this marker
			iw.open(map, markers[0]);//"move" the info window to the clicked marker and open it
	    }
	);
}

function search() {
	$('#street').val($('#autocomplete').val());
	$('#search').submit();
}

function showSelectedPlace() {
	clearMarkers();
	var place = autocomplete.getPlace();
	map.panTo(place.geometry.location);
	markers[0] = new google.maps.Marker({
		position : place.geometry.location,
		map : map
	});
	iw = new google.maps.InfoWindow({
		content : getIWContent(place)
	});
	iw.open(map, markers[0]);
}

function clearMarkers() {
	for ( var i = 0; i < markers.length; i++) {
		if (markers[i]) {
			markers[i].setMap(null);
			markers[i] == null;
		}
	}
}

function getIWContent(place) {
	var content = '<div style="border:0;margin-top:10px;">';
	content += place.formatted_address;
	content += '</div>';
	
	return content;
}
