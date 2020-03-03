<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page session="true"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="inserts/head.html"%>
</head>
<body>
	<article>
		<header class="header">
			<%@ include file="inserts/topHeader.html"%>
			<%@ include file="inserts/bottomHeader.html"%>
		</header>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<h2>Create your account</h2>
			<form id="signupform" name="signupform" action="create" method="post">
				<div class="form-group">
					<div class="input-group">
						<input type="email" id="email" name="emailTB" class="form-control"
							placeholder="Email"  required></input>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<input type="text" id="name" name="nameTB" class="form-control"
							placeholder="Your Scorecard Initials"
							maxlength="2"  required></input>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<input type="password" id="password" name="passwordTB"
							class="form-control" placeholder="Password"  required></input>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<input type="password" id="passwordConfirm" name="passwordCon"
							class="form-control" placeholder="Confirm Password" required></input>
					</div>
				</div>
			</form>
				<button id="sub" type="submit" hidden="true" form="signupform"></button>
				<form id="goBack" action="index" method="post"></form>
				<button type="submit" class="btn btn-secondary"
					class="btn btn-primary" form="goBack">Go Back</button>
				<button type="button" class="btn btn-primary" onclick="register();"
					class="btn btn-primary">Sign Up</button>
				<button type="submit" class="btn btn-primary" form="signupform"
					class="btn btn-success">Submit</button>
			<%@ include file="inserts/bottomMain.html"%>
		</main>

		<!-- Message Modal -->
		<div id="messageModalSpace"></div>
		<!-- End Message Modal -->
	</article>
	<%@ include file="inserts/scripts.html"%>
</body>
</html>