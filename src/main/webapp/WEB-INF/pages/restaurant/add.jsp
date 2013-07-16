<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="add"/></title>
</head>
<body>
		<form:form method="post" action="/restaurant/add" modelAttribute="restaurant">
			<h2><spring:message code="add.new.restaurant"/></h2>
			<c:if test="${!empty error}">
				<p class="validationMsg"><spring:message code="${error}"/></p>
			</c:if>
			
				<p>
					<label><spring:message code="type"/>: <span class="mandatory">*</span> </label>
					<form:select path="type" cssErrorClass="inputError">
						<form:option value=""></form:option>
						<form:option value="VEGETARIAN"><spring:message code="vegetarian"/></form:option>
						<form:option value="VEGAN"><spring:message code="vegan"/></form:option>
					</form:select>
					<form:errors cssClass="error" path="type"/>
				</p>
				<p>
					<label><spring:message code="name"/>: <span class="mandatory">*</span> </label>
					<form:input path="name" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="name"/>
				</p>
				<p>
					<label><spring:message code="address"/> <span class="mandatory">*</span> </label>
					<form:input path="street" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="street"/>
				</p>
				<p>
					<label><spring:message code="street_number"/>: <span class="mandatory">*</span> </label>
					<form:input path="number" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="number"/>
				</p>
				<p>
					<label><spring:message code="postal_code"/>: </label>
					<form:input path="postalCode"/>
				</p>
				<p>
					<label><spring:message code="city"/>: <span class="mandatory">*</span> </label>
					<form:input path="city" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="city"/>
				</p>
				<p>
					<label><spring:message code="state"/>: <span class="mandatory">*</span> </label>
					<form:input path="state" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="state"/>
				</p>
				<p>
					<label><spring:message code="country"/>: <span class="mandatory">*</span> </label>
					<form:input path="country.name" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="country.name"/>
				</p>
				<p>
					<label><spring:message code="website"/>: </label>
					<form:input path="website" cssErrorClass="inputError"/>
					<form:errors cssClass="error" path="website"/>
				</p>
				<p>
					<label><spring:message code="phone"/>: </label>
					<form:input path="phone"/> 
				</p>
				<p>
					<label><spring:message code="description"/>: <span class="mandatory">*</span></label>
					<form:textarea path="description" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="description"/>
				</p>
				<p><input type="submit" value="<spring:message code="save"/>"/></p>
		</form:form>
</body>
</html>