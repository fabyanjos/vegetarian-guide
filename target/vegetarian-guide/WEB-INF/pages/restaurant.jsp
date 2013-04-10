<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" 				prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<title>Restaurant</title>

<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=places&amp;language=${pageContext.response.locale}"></script>
    
<style type="text/css">

  #map-canvas {
    float: left;
    width: 650px;
    height: 500px;
    border: solid red 0px;
  }

  .placeIcon {
    width: 16px;
    height: 16px;
    margin: 2px;
  }

  #autocomplete {
    width: 500px;
    border: 1px solid #ccc;
    height: 20px;
  	font-size: 16px;
  }
  
  #place {
  	float: left;
  	width: 250px;
  	border: solid blue 0px;
  	font-size: 13px;
  }
  
  #place input {
  	width: 180px;
  	display: block;
  }
  
  #place select {
  	width: 180px;
  	display: block;
  }
  
  #place ul {
  	list-style: none;
    margin: -5px 0 0 10px;
    padding: 0;
  }
  #place ul li {
  	margin-top: 5px;
  }
  
  #main {
  	width: 910px;
  	border: solid black 0px;
  	margin: 0px auto;
  }
</style>
</head>
<body>

<script>
  // Additional JS functions here
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '426669610763003', // App ID
      channelUrl : '//localhost:8080/channel.html', // Channel File
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });

    // Additional init code here
    
    FB.getLoginStatus(function(response) {
    	  if (response.status === 'connected') {
    	    alert('connected');
    	  } else if (response.status === 'not_authorized') {
    		  alert('not_authorized');
    	  } else {
    		  alert('not_logged_in');
    	  }
    	 });

  };

  // Load the SDK Asynchronously
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
</script>
	<div id="main">
		<form onsubmit="codeAddress(); return false;">
			<p>
				<input id="autocomplete" name="autocomplete" type="text"/>
				<input type="submit" value="Encode">
			</p>
		</form>
	<div id="map-canvas"></div>
	
	<form:form method="post" action="/restaurant/save" modelAttribute="restaurant">
		<div id="place">
			<ul>
				<li>
					<label><spring:message code="type"/>: </label>
					<select id="type" name="type">
						<option value=""></option>
						<option value="VEGETARIAN"><spring:message code="vegetarian"/></option>
						<option value="VEGAN"><spring:message code="vegan"/></option>
					</select>
					
				</li>
				<li><label><spring:message code="name"/>: </label><input type="text" id="name" name="name"/></li>
				<li><label><spring:message code="address"/>: </label><input type="text" id="street" name="street"/></li>
				<li><label><spring:message code="street_number"/>: </label><input type="text" id="number" name="number"/></li>
				<li><label><spring:message code="postal_code"/>: </label><input type="text" id="postalCode" name="postalCode"/></li>
				<li><label><spring:message code="city"/>: </label><input type="text" id="city" name="city"/></li>
				<li><label><spring:message code="state"/>: </label><input type="text" id="state" name="state"/></li>
				<li>
					<label><spring:message code="country"/>: </label>
					<input type="text" id="country" name="country.name" style="display: none;"/> 
					<input type="text" id="country_long" name="country_long"/>
				</li>
				<li style="display: none;"><label><spring:message code="lat"/>: </label><input type="text" id="latitude" name="latitude"/></li>
				<li style="display: none;"><label><spring:message code="lng"/>: </label><input type="text" id="longitude" name="longitude"/></li>
				<li><input type="submit" value="<spring:message code="save"/>"/></li>
			</ul>
		</div>
	</form:form>
	<p>
		Choose: <a href="<c:url value='?lang=en'/>">English</a> | <a
			href="<c:url value='?lang=pt_BR'/>">Portuguese</a>
	</p>
	
	</div>
	
	<script type="text/javascript" src="/js/maps.js"></script>
</body>
</html>