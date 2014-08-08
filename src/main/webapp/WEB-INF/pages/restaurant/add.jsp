<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="add"/></title>
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="add"/>">
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
						<form:option value="OVO_LACTO"><spring:message code="ovolacto"/></form:option>
						<form:option value="LACTO"><spring:message code="lacto"/></form:option>
						<form:option value="VEGAN"><spring:message code="vegan"/></form:option>
						<form:option value="VEGETARIAN"><spring:message code="vegetarian"/></form:option>
					</form:select>
					<form:errors cssClass="error" path="type"/>
				</p>
				<p>
					<label><spring:message code="delivery"/>: </label>
					<span>
						<form:radiobutton path="delivery" value="yes"/><label for="delivery1"><spring:message code="true"/></label> 
						<form:radiobutton path="delivery" value="no"/><label for="delivery2"><spring:message code="false"/></label>
					</span>
					<form:errors cssClass="error" path="delivery"/>
				</p>
				<p>
					<label>
					<spring:message code="price"/>
					<a href="#" class="tooltip">
						<img src="/images/help.png" width="14">
						<span>
							<b></b>
							<spring:message code="price.list"/>
						</span>
					</a>
					:
					</label>
					<span class="price">
					    <input type="radio" name="price" value="0" checked /><span id="hide"></span>
					    <input type="radio" name="price" value="1"/><span></span>
					    <input type="radio" name="price" value="2"/><span></span>
					    <input type="radio" name="price" value="3"/><span></span>
					    <input type="radio" name="price" value="4"/><span></span>
					</span>
					<form:errors cssClass="error" path="price"/>
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
				<p style="display: none;">
					<label><spring:message code="country"/>: <span class="mandatory">*</span> </label>
					<form:input path="country.name" cssErrorClass="inputError" value="Brasil"/> 
					<form:errors cssClass="error" path="country.name"/>
				</p>
				<p>
					<label><spring:message code="description"/>: <span class="mandatory">*</span></label>
					<form:textarea path="description" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="description"/>
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
					<label><spring:message code="openingTimes"/>:</label>
					<form:textarea path="openingTimes" cssErrorClass="inputError"/> 
					<form:errors cssClass="error" path="openingTimes"/>
				</p>
				<p><input type="submit" value="<spring:message code="save"/>"/></p>
		</form:form>
</body>
</html>