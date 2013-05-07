<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="/css/rating.css"/>
</head>
<body>
	<c:set var="add"/>
	<div id="main">
	<form:form method="post" action="/restaurant/review/save/${restaurantId}" modelAttribute="review">
		<h3>Review</h3>
		<span style="display: none;"><form:input path="rating"/></span>
		<div id="ratingDiv">
			<form:errors cssClass="error" path="rating"/>
			<ul class="rating nostar" id="ratingList">
				<li class="one"><a href="javascript:rating(1);" title="1 Star">1</a></li>
				<li class="two"><a href="javascript:rating(2);" title="2 Stars">2</a></li>
				<li class="three"><a href="javascript:rating(3);" title="3 Stars">3</a></li>
				<li class="four"><a href="javascript:rating(4);" title="4 Stars">4</a></li>
				<li class="five"><a href="javascript:rating(5);" title="5 Stars">5</a></li>
			</ul>
		</div>
		<fieldset id="place">
			<ul>
				<li>
					<label><spring:message code="title"/>: <span class="mandatory">*</span> </label>
					<form:input path="title"/>
					<form:errors cssClass="error" path="title"/>
				</li>
				<li>
					<label><spring:message code="description"/>: <span class="mandatory">*</span> </label>
					<form:textarea path="description"/>
					<form:errors cssClass="error" path="description"/>
				</li>
				<li>
					<label><spring:message code="pros"/>: </label>
					<form:input path="pros"/>
					<form:errors cssClass="error" path="pros"/>
				</li>
				<li>
					<label><spring:message code="cons"/>: </label>
					<form:input path="cons"/>
					<form:errors cssClass="error" path="cons"/>
				</li>
				
				<li><input type="submit" value="<spring:message code="save"/>" class="button"/></li>
			</ul>
		</fieldset>
	</form:form>
	</div>
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
	
	function numberText(number) {
		var text;
		switch(number) {
			case 1: text = "one"; break;
			case 2: text = "two"; break;
			case 3: text = "three"; break;
			case 4: text = "four"; break;
			case 5: text = "five"; break;
		}
		return text;
	}
</script>
</body>
</html>