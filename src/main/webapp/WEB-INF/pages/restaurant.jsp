<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
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
	<div id="main">
	<p>
		<input id="autocomplete" type="text"/>
	</p>
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