var map, places, iw;
var markers = [];
var autocomplete;
var geocoder;
var myLatlng = new google.maps.LatLng(37.783259, -122.402708);
var myOptions = {
	zoom : 12,
	center : myLatlng,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};
function initialize() {
	geocoder = new google.maps.Geocoder();
	
	//map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);

//	autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'));
}

function codeAddress(callback) {
	clearMarkers();
	var address = document.getElementById("autocomplete").value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			getAddressComponents(results[0].address_components);
			getGeometry(results[0].geometry);

			if (typeof callback == 'function') {
				callback();
			} else {
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
			}
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
	iw = new google.maps.InfoWindow({
		maxWidth: 100,
	});
	google.maps.event.addListener(markers[index], 'click',
	    function(){
			iw.close();//hide the infowindow
			iw.setContent($('#infoWindow'+index).html());//update the content for this marker
			iw.open(map, markers[index]);//"move" the info window to the clicked marker and open it
	    }
	);
}

function setOrigin(lat, lng) {
	map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);
	var location = new google.maps.LatLng(lat, lng);
	map.setCenter(location);
    map.setZoom(14);
    markers[0] = new google.maps.Marker({
    	map: map,
        position: location,
        icon: '/images/marker-blue.png'
	});
	iw = new google.maps.InfoWindow({
		maxWidth: 100,
	});
	var content = '<div id="infoWindow">Your place</div>';
	google.maps.event.addListener(markers[0], 'click',
	    function(){
			iw.close();//hide the infowindow
			iw.setContent(content);//update the content for this marker
			iw.open(map, markers[0]);//"move" the info window to the clicked marker and open it
	    }
	);
}

function search() {
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

function getAddressComponents(components) {
	for(var i = 0; i < components.length; i++) {
		for(var j = 0; j < components[i].types.length; j++) {
			if(components[i].types[j] == 'route')
				document.getElementById('street').value = components[i].long_name;
			if(components[i].types[j] == 'street_number')
				document.getElementById('number').value = components[i].long_name;
			if(components[i].types[j] == 'postal_code')
				document.getElementById('postalCode').value = components[i].long_name;
			if(components[i].types[j] == 'locality')
				document.getElementById('city').value = components[i].long_name;
			if(components[i].types[j] == 'administrative_area_level_1')
				document.getElementById('state').value = components[i].long_name;
			if(components[i].types[j] == 'country') {
				document.getElementById('country.name').value = components[i].short_name;
				document.getElementById('country_long').value = components[i].long_name;
			}
		}
	}
}

function getGeometry(geometry) {
	document.getElementById('latitude').value = geometry.location.lat();
	document.getElementById('longitude').value = geometry.location.lng();
}

$('#autocomplete').keypress(function (e) {
	//searchPlaces();
});

google.maps.event.addDomListener(window, 'load', initialize);

// Facebook
