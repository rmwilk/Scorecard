"use strict";

function element(id){
	return document.getElementById(id);
}

function login() {
	var regex = /.{4,16}/;
	var validUser = true;
	var validPass = true;
	var input = element("username").value;
	var message = "";
	
	if(regex.test(input) == false) {
		validUser = false;
		message += "Invalid username.\n";
	}
	
	input = element("password").value;
	if(regex.test(input) == false){
		validPass = false;
		message += "Invalid password.\n";
	}
	
	if(validUser && validPass){
		alert("Welcome " + element("username").value + "!");
		//document.cookie = `username="element('username').value"`;
		window.location ="./todo.html";	
	}
	else {
		alert(message);
		window.location ="./index.html";	
	}
}

function register() {
	var username = element("username").value;
	//var email = element("email").value;
	var password = element("password").value;
	var confirm = element("confirm").value;
	
	/* Regular expression to verify email syntax */
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/; 
	var address = element("email").value;
	if (reg.test(address) == false)
	{
	alert('Invalid Email Address');
	element("email").value = "";
	return (false);
	}
	else if(password == confirm && confirm.length > 0 && password.length > 0){
		alert("Thanks for making an account " + username + "!\n\nYou can now login.");
		window.location = "./index.html";
	}
	else {
		alert("Passwords do not match");
		element("password").value = "";
		element("confirm").value = "";
	}
}