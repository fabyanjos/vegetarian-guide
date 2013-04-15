<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
</head>
<body>
	<div id="main">
		<form onsubmit="codeAddress(); return false;">
			<div class="button black">
				<input id="autocomplete" name="autocomplete" type="text"/>
				&nbsp;<a href="javascript:codeAddress(); return false;"><spring:message code="search"/></a></div>
		</form>
	<div id="map-canvas"></div>
	<form:form method="post" action="/restaurant/save" modelAttribute="restaurant">
		<div id="place">
		<h3>Dados do local</h3>
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
	
	</div>
	
</body>
</html>