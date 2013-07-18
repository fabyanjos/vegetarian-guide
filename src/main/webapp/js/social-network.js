hello.init({ 
	facebook : '426669610763003',
	google: '911763680080.apps.googleusercontent.com'
},{redirect_uri:'/'});

function faceLogin() {
	hello.login('facebook', function(auth) {
		if(auth.error == null)
			login(auth);
	});
}
function googleLogin() {
	hello.login('google', function(auth) {
		if(auth.error == null)
			login(auth);
	});
}
function AjaxSucceeded(result) {
	window.location.href = '/';
}
function AjaxFailed(result) {
}
function login(auth) {
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