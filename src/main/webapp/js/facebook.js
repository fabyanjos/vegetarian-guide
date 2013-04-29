// Additional JS functions here
window.fbAsyncInit = function() {
	FB.init({
		appId : '426669610763003', // App ID
		channelUrl : '//localhost:8080/channel.html', // Channel File
		status : true, // check login status
		cookie : true, // enable cookies to allow the server to access the
		// session
		xfbml : true
	// parse XFBML
	});
};

function login() {
	FB.login(function(response) {
		if (response.authResponse) {
			// alert("connected");
			// connected
			testAPI();
		} else {
			// cancelled
			alert("cancelled");
		}
	}, {
		scope : 'email,user_location'
	});
}

function testAPI() {
	FB.api('/me', function(response) {
		var user = {
			"name": response.name,
			"email": response.email,
			"login": response.username
		};
//		alert(response.location.name);
		$.ajax({
			type : "PUT",
			async : false,
			url : "/rest/user",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			data: JSON.stringify(user),
			processData : true, 
			success : function(result) {
				AjaxSucceeded(result);
			},
			eror : AjaxFailed
		});
	});
	function AjaxSucceeded(result) {
		window.location.href = '/';
	}
	function AjaxFailed(result) {
		alert(result);
	}
}

// Load the SDK Asynchronously
(function(d) {
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	ref.parentNode.insertBefore(js, ref);
}(document));

/*
 * Supported scopes: ads_management create_event create_note email export_stream
 * friends_about_me friends_activities friends_birthday friends_checkins
 * friends_education_history friends_events friends_games_activity
 * friends_groups friends_hometown friends_interests friends_likes
 * friends_location friends_notes friends_online_presence
 * friends_photo_video_tags friends_photos friends_questions
 * friends_relationship_details friends_relationships friends_religion_politics
 * friends_status friends_subscriptions friends_videos friends_website
 * friends_work_history manage_friendlists manage_notifications manage_pages
 * offline_access photo_upload publish_actions publish_checkins publish_stream
 * read_friendlists read_insights read_mailbox read_page_mailboxes read_requests
 * read_stream rsvp_event share_item sms status_update user_about_me
 * user_activities user_birthday user_checkins user_education_history
 * user_events user_games_activity user_groups user_hometown user_interests
 * user_likes user_location user_notes user_online_presence
 * user_photo_video_tags user_photos user_questions user_relationship_details
 * user_relationships user_religion_politics user_status user_subscriptions
 * user_videos user_website user_work_history video_upload xmpp_login
 */