var map, places, iw;
var markers = [];
var autocomplete;
var geocoder;

function initialize() {
	geocoder = new google.maps.Geocoder();
	var myLatlng = new google.maps.LatLng(37.783259, -122.402708);
	var myOptions = {
		zoom : 12,
		center : myLatlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	//map = new google.maps.Map(document.getElementById('map-canvas'), myOptions);

	autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'));
}

function codeAddress() {
	alert($('#autocomplete').val());
	$("#map-canvas").gmap3({
		  getlatlng:{
		    address: $('#autocomplete').val(),
		    callback: function(results){
		    	alert(results);
		      if ( !results ) alert('erro');
		      $(this).gmap3({
		        marker:{
		          latLng:results[0].geometry.location
		        }
		      });
		    }
		  }
		});
	/*
	clearMarkers();
    var address = document.getElementById("autocomplete").value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        
        var pyrmont = new google.maps.LatLng(results[0].geometry.location.lat(),results[0].geometry.location.lng());
        
        var request = {
		    location: pyrmont,
		    radius: 500,
		    query: 'all'
		  };
	
		  service = new google.maps.places.PlacesService(map);
		  service.textSearch(request, callback);
       
        markers[0] = new google.maps.Marker({
        	map: map,
            position: results[0].geometry.location
    	});
        iw = new google.maps.InfoWindow({
    		content : getIWContent(results[0])
    	});
    	iw.open(map, markers[0]);
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });*/
}

function callback(results, status) {
	  if (status == google.maps.places.PlacesServiceStatus.OK) {
		  for (var i = 0; i < results.length; i++) {
		  markers[i] = new google.maps.Marker({
	        	map: map,
	            position: results[i].geometry.location
		  });
		  }
	    
	  }
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

function getIWContent(place) {
	var content = '<table style="border:0"><tr><td style="border:0;">';
	content += '<img class="placeIcon" src="' + place.icon + '"></td>';
	content += '<td style="border:0;"><b><a href="' + place.url + '">'
			+ place.formatted_address + '</a></b>';
	content += '</td></tr></table>';
	
	getAddressComponents(place.address_components);
	getGeometry(place.geometry);

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
				document.getElementById('country').value = components[i].short_name;
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