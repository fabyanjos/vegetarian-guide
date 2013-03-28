var map, places, iw;
var markers = [];
var autocomplete;

function initialize() {
	var myLatlng = new google.maps.LatLng(37.783259, -122.402708);
	var myOptions = {
		zoom : 12,
		center : myLatlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);

	autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'));
	/*
	places = new google.maps.places.PlacesService(map);
	google.maps.event.addListener(map, 'tilesloaded', tilesLoaded);
	autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'));
	*/
}

function searchPlaces() {
	google.maps.event.addListener(autocomplete, 'place_changed', function() {
		showSelectedPlace();
	});
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

function getDetails(result, i) {
	return function() {
		places.getDetails({
			reference : result.reference
		}, showInfoWindow(i));
	}
}

function showInfoWindow(i) {
	alert(i);
	return function(place, status) {
		if (iw) {
			iw.close();
			iw = null;
		}

		if (status == google.maps.places.PlacesServiceStatus.OK) {
			iw = new google.maps.InfoWindow({
				content : getIWContent(place)
			});
			iw.open(map, markers[i]);
		}
	}
}

function getIWContent(place) {
	var content = '<table style="border:0"><tr><td style="border:0;">';
	content += '<img class="placeIcon" src="' + place.icon + '"></td>';
	content += '<td style="border:0;"><b><a href="' + place.url + '">'
			+ place.name + '</a></b>';
	content += '</td></tr></table>';
	return content;
}

google.maps.event.addDomListener(window, 'load', initialize);