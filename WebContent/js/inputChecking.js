"use strict";

function element(id) {
	return document.getElementById(id);
}

function login() {
	var regex = /.{4,16}/;
	var address;
	var validEmail = true;
	var validPass = true;
	var password;
	var message = "";
	/* Regular expression to verify email syntax */
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if (element("email").value != null){
		address = element("email").value;
	}
	if (element("current-password").value != null){
		password = element("current-password").value;
	}
	
	if (reg.test(address) == false) {
		validEmail = false;
		message += "Invalid Email Address<br>";
	}
	if (password == confirm && confirm.length > 0 && password.length > 0) {
		buildMessageModal("Login Sucess","Welcome " + address + "!");
	}
	
	if (regex.test(password) == false) {
		validPass = false;
		message += "Invalid password.<br>";
	}

	if (validEmail && validPass) {
		; // do nothing
	} else {
		buildMessageModal("Login Failed", message);
		element("email").value = "";
		element("current-password").value = "";
	}
}

function register() {
	var regex = /.{4,16}/;
	var address;
	var validEmail = true;
	var validPass = true;
	var validPassMatch = true;
	var password;
	var passwordConfirm;
	var message = "";
	/* Regular expression to verify email syntax */
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if (element("email").value != null && element("email").value != ""){
		address = element("email").value;
	}
	if (element("password").value != null && element("password").value != ""){
		password = element("password").value;
	}
	if (element("passwordConfirm").value != null && element("passwordConfirm").value != ""){
		passwordConfirm = element("passwordConfirm").value;
	}
	
	if (reg.test(address) == false) {
		validEmail = false;
		message += "Invalid Email Address<br>";
	}
	if (regex.test(password) == false) {
		validPass = false;
		message += "Invalid password.<br>";
	}
	if (password == confirm && confirm.length > 0 && password.length > 0) {
		validPasswordConfirm = false;
		message += "Passwords Do Not Match<br>";
	}
	

	if (validEmail && validPass && validPassMatch) {
		buildMessageModal("Sign-Up Sucess","Welcome " + address + "!");
		var form = document.getElementsByName("signupform");
		 form[0].submit();
	} else {
		buildMessageModal("Sign-Up Failed", message);
		element("email").value = "";
		element("password").value = "";
		element("passwordConfirm").value = "";
	}
}

function buildMessageModal(title, message){
	var output = `
		<div class="modal fade" id="messageModal" tabindex="-1"
			role="dialog" aria-labelledby="messageModalTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="messageModalTitle">
	`;
	output += title;
	output += `
						</h2>
					</div>
					<div class="modal-body">
						<div class="container" style="text-align: center">
							<p>
	`;
	output += message;
	output += `
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
							data-dismiss="modal">
								OK
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	`;
	
	element("messageModalSpace").innerHTML = output;
	$('#messageModal').modal('show');
}