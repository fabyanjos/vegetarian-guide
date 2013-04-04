<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
<title>Welcome To Spring MVC Internationalization !!!</title>

<link rel="stylesheet" href="//www.google.com/cse/style/look/default.css" type="text/css" />
    <link href='//fonts.googleapis.com/css?family=Open+Sans:300,400' rel='stylesheet' type='text/css'>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script id="jqueryui" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js" defer async></script>
    <script src="//www.google.com/jsapi"></script>
    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=places&amp;language=${pageContext.response.locale}"></script>
    
<style type="text/css">

  #map-canvas {
    float: left;
    width: 500px;
    height: 400px;
  }

  .placeIcon {
    width: 16px;
    height: 16px;
    margin: 2px;
  }

  #autocomplete {
    width: 500px;
    border: 1px solid #ccc;
  }
  
  #place {
  	float: left;
  	width: 200px;
  }
  
  #place input {
  	clear: both;
  	width: 180px;
  }
  
  #place ul {
  	list-style: none;
    margin: 10px;
    padding: 0;
  }
  #place ul li {
  	margin-top: 5px;
  }
  
  #main {
  	width: 710px;
  }
</style>
</head>
<body>
	<div id="main">
	<p>
		<input id="autocomplete" type="text"/>
	</p>
	<div id="map-canvas"></div>
	
	<form action="/restaurant/save" method="post">
		<div id="place">
			<ul>
				<li><label><spring:message code="address"/>: </label><input type="text" id="route"/></li>
				<li><label><spring:message code="street_number"/>: </label><input type="text" id="street_number"/></li>
				<li><label><spring:message code="postal_code"/>: </label><input type="text" id="postal_code"/></li>
				<li><label><spring:message code="city"/>: </label><input type="text" id="locality"/></li>
				<li><label><spring:message code="state"/>: </label><input type="text" id="administrative_area_level_1"/></li>
				<li><label><spring:message code="country"/>: </label><input type="text" id="country" style="display: none;"/> <input type="text" id="country_long"/></li>
				<li><label><spring:message code="lat"/>: </label><input type="text" id="lat"/></li>
				<li><label><spring:message code="lng"/>: </label><input type="text" id="lng"/></li>
				<li><input type="submit" value="<spring:message code="save"/>"/></li>
			</ul>
		</div>
	</form>
	<p>
		Choose: <a href="<c:url value='?lang=en'/>">English</a> | <a
			href="<c:url value='?lang=pt_BR'/>">Portuguese</a>
	</p>
	
	</div>
	
	<script type="text/javascript" src="/js/maps.js"></script>
</body>
</html>