hello.init({ 
	facebook : '426669610763003',
	google: '911763680080.apps.googleusercontent.com'
},{redirect_uri:'/'});

function faceLogin() {
	$(window).load('/js/hello.js');
	hello.login('facebook', function(auth) {
		if(auth.error == null)
			login(auth);
	});
}
function googleLogin() {
	$(window).load('/js/hello.js');
	hello.login('google', function(auth) {
		if(auth.error == null)
			login(auth);
	});
}
function AjaxSucceeded(result) {
	window.location.href = '/';
	$(document).ajaxStop($.unblockUI);
}
function AjaxFailed(result) {
	$(document).ajaxStop($.unblockUI);
}
function login(auth) {
	modalMessage();
	hello.api(auth.network + '/me', function(user){
		var userDetail = {
				"name" : user.name,
				"email" : user.email,
				"pass": user.id,
				"imageUrl": user.picture,
			};
			$.ajax({
				type : "POST",
				async : false,
				url : "/user/login/" + auth.network,
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				data : JSON.stringify(userDetail),
				processData : true,
				success : AjaxSucceeded,
				error : AjaxFailed
			});
	});
}

function modalMessage() {
	$(window).load('/js/jquery.blockUI.js');
	if($.blockUI != null)
		$.blockUI({ message: $('#loadingMessage') }); 
}

$(document).ready(function () {
	$(window).load('/js/jquery.sharrre-1.3.4.min.js');
	$('#shareme').sharrre({
	  share: {
	    googlePlus: true,
	    facebook: true,
	    twitter: true
	  },
	  buttons: {
	    googlePlus: {size: 'tall', annotation:'bubble'},
	    facebook: {layout: 'box_count'},
	    twitter: {count: 'vertical'}
	  },
	  enableHover: true,
	  enableCounter: false,
	  enableTracking: true,
	  urlCurl: ''
	});
});