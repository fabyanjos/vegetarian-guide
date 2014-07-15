<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="review"/></title>
	<meta name="description" content="<spring:message code="meta.description"/>, <spring:message code="review"/>">
</head>
<body>
	<form:form method="post" action="/restaurant/review/save/${restaurantId}" modelAttribute="review">
		<h2>
			<spring:message code="review"/>
		</h2>
		<c:if test="${!empty error}">
			<p class="validationMsg">
				<spring:message code="${error}"/><br/>
			</p>
		</c:if>
		<p>
			<label><spring:message code="rate"/>: <span class="mandatory">*</span> </label>
			<span class="rating">
			    <input type="radio" name="rating" value="0" checked /><span id="hide"></span>
			    <input type="radio" name="rating" value="1"/><span></span>
			    <input type="radio" name="rating" value="2"/><span></span>
			    <input type="radio" name="rating" value="3"/><span></span>
			    <input type="radio" name="rating" value="4"/><span></span>
			    <input type="radio" name="rating" value="5"/><span></span>
			</span>
			<form:errors cssClass="error" path="rating" cssStyle="display: inline-block;position: absolute;margin: -2px 0 0 200px;"/>
		</p>
		<p>
			<label><spring:message code="summary"/>: <span class="mandatory">*</span> </label>
			<form:input path="title" cssErrorClass="inputError" maxlength="40"/>
			<form:errors cssClass="error" path="title"/>
		</p>
		<p>
			<label><spring:message code="description"/>: <span class="mandatory">*</span> </label>
			<form:textarea path="description" cssErrorClass="inputError"/>
			<form:errors cssClass="error" path="description"/>
		</p>
		<p>
			<label><spring:message code="pros"/>: </label>
			<form:input path="pros" cssErrorClass="inputError" maxlength="100"/>
			<form:errors cssClass="error" path="pros"/>
		</p>
		<p>
			<label><spring:message code="cons"/>: </label>
			<form:input path="cons" cssErrorClass="inputError" maxlength="100"/>
			<form:errors cssClass="error" path="cons"/>
		</p>
		<p><input type="submit" value="<spring:message code="save"/>" class="button"/></p>
	</form:form>
<script type="text/javascript">
	$(window).load(function () {
		var rating = $("#rating").val();
		if(rating > 0) {
			var star = numberText(parseInt(rating));
			var style = "rating " + star + "star";
			$("#ratingList").attr("class", style);
		}
	});

	function rating(rating) {
		var star = numberText(rating);
		var style = "rating " + star + "star";
		$("#ratingList").attr("class", style);
		$("#rating").val(rating);
	}
	
</script>
</body>
</html>