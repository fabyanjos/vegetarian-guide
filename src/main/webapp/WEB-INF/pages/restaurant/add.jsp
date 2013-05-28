<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
</head>
<body>
	<div id="main">
	<form:form method="post" action="/restaurant/add" modelAttribute="restaurant">
		<fieldset id="place">
			<h3><spring:message code="add.new.restaurant"/></h3>
			<c:if test="${!empty error}">
				<p class="validationMsg"><spring:message code="${error}"/></p>
			</c:if>
			<ul>
				<li>
					<label><spring:message code="type"/>: <span class="mandatory">*</span> </label>
					<form:select path="type" cssErrorClass="inputError">
						<form:option value=""></form:option>
						<form:option value="VEGETARIAN"><spring:message code="vegetarian"/></form:option>
						<form:option value="VEGAN"><spring:message code="vegan"/></form:option>
					</form:select>
					<form:errors cssClass="error" path="type"/>
				</li>
				<li>
					<label><spring:message code="name"/>: <span class="mandatory">*</span> </label>
					<form:input path="name" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="name"/>
				</li>
				<li>
					<label><spring:message code="address"/> <span class="mandatory">*</span> </label>
					<form:input path="street" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="street"/>
				</li>
				<li>
					<label><spring:message code="street_number"/>: <span class="mandatory">*</span> </label>
					<form:input path="number" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="number"/>
				</li>
				<li>
					<label><spring:message code="postal_code"/>: </label>
					<form:input path="postalCode"/>
				</li>
				<li>
					<label><spring:message code="city"/>: <span class="mandatory">*</span> </label>
					<form:input path="city" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="city"/>
				</li>
				<li>
					<label><spring:message code="state"/>: <span class="mandatory">*</span> </label>
					<form:input path="state" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="state"/>
				</li>
				<li>
					<label><spring:message code="country"/>: <span class="mandatory">*</span> </label>
					<form:input path="country.name" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="country.name"/>
				</li>
				<li>
					<label><spring:message code="website"/>: </label>
					<form:input path="website" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="website"/>
				</li>
				<li>
					<label><spring:message code="phone"/>: </label>
					<form:input path="phone"/> 
				</li>
				<li>
					<label><spring:message code="description"/>: <span class="mandatory">*</span></label>
					<form:textarea path="description" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="description"/>
				</li>
				<li><input type="submit" value="<spring:message code="save"/>" class="button"/></li>
			</ul>
		</fieldset>
	</form:form>
	
	</div>
</body>
</html>