<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="review"/></title>
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
		<span style="display: none;"><form:input path="rating"/></span>
		<p style="display:inline-block;">
			<label><spring:message code="rate"/>: <span class="mandatory">*</span> </label>
				<ul class="rating nostar" id="ratingList" style="display:inline-block;top:-30px;right:25px;">
					<li class="one"><a href="javascript:rating(1);" title="1 Star">1</a></li>
					<li class="two"><a href="javascript:rating(2);" title="2 Stars">2</a></li>
					<li class="three"><a href="javascript:rating(3);" title="3 Stars">3</a></li>
					<li class="four"><a href="javascript:rating(4);" title="4 Stars">4</a></li>
					<li class="five"><a href="javascript:rating(5);" title="5 Stars">5</a></li>
				</ul>
			<form:errors cssClass="error" path="rating" cssStyle="display: inline-block;position: absolute;margin: -2px 0 0 200px;"/>
		</p>
		<p style="margin-top:-30px;">
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