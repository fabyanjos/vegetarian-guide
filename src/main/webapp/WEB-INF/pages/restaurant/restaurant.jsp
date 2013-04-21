<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"				prefix="c"%>
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
		<fieldset id="place">
			<h3>Dados do local</h3>
			<ul>
				<li>
					<label><spring:message code="type"/>: </label>
					<form:select path="type">
						<form:option value=""></form:option>
						<form:option value="VEGETARIAN"><spring:message code="vegetarian"/></form:option>
						<form:option value="VEGAN"><spring:message code="vegan"/></form:option>
					</form:select>
					<form:errors cssClass="error" path="type"/>
				</li>
				<li>
					<label><spring:message code="name"/>: </label>
					<form:input path="name"/>
					<form:errors cssClass="error" path="name"/>
				</li>
				<li>
					<label><spring:message code="address"/>: </label>
					<form:input path="street"/>
					<form:errors cssClass="error" path="street"/>
				</li>
				<li>
					<label><spring:message code="street_number"/>: </label>
					<form:input path="number"/>
					<form:errors cssClass="error" path="number"/>
				</li>
				<li>
					<label><spring:message code="website"/>: </label>
					<form:input path="website"/>
					<form:errors cssClass="error" path="website"/>
				</li>
				<li style="display: none;">
					<label><spring:message code="postal_code"/>: </label>
					<form:input path="postalCode"/>
				</li>
				<li style="display: none;">
					<label><spring:message code="city"/>: </label>
					<form:input path="city"/>
				</li>
				<li style="display: none;">
					<label><spring:message code="state"/>: </label>
					<form:input path="state"/>
				</li>
				<li style="display: none;">
					<label><spring:message code="country"/>: </label>
					<form:input path="country.name"/> 
					<input type="text" id="country_long" name="country_long"/>
				</li>
				<li style="display: none;"><label><spring:message code="lat"/>: </label><form:input path="latitude"/></li>
				<li style="display: none;"><label><spring:message code="lng"/>: </label><form:input path="longitude"/></li>
				<li><input type="submit" value="<spring:message code="save"/>"/></li>
			</ul>
		</fieldset>
	</form:form>
	
	</div>
	
</body>
</html>