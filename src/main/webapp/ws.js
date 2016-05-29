$('#submitRegister').click(function() {
		register();
	return false;
});

$('#submitLogin').click(function() {
		login();
	return false;
});

function register() {
	console.log('register');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: "http://localhost:8080/api/user/register",
		dataType: "json",
		data: registerFormToJSON(),
		success: function(data, textStatus, jqXHR){
			location.href = "index.html";
		},
		error: function(jqXHR, textStatus, errorThrown){
			location.href = "err.html";
		}
	});
}

function login() {
	console.log('login');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: "http://localhost:8080/api/user/login",
		dataType: "json",
		data: loginFormToJSON(),
		success: function(data, textStatus, jqXHR){
			alert(data['message']);
			location.href = "welcome.html";
		},
		error: function(jqXHR, textStatus, errorThrown){
			location.href = "err.html";
		}
	});
}

function registerFormToJSON() {
	return JSON.stringify({
		"firstName": $('#firstName').val(), 
		"lastName": $('#lastName').val(), 
		"username": $('#username').val(), 
		"password": $('#password').val()
		});
} 

function loginFormToJSON() {
	return JSON.stringify({
		"username": $('#username').val(), 
		"password": $('#password').val()
		});
} 