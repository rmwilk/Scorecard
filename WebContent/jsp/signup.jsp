<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/html/head.html"%>
</head>
<body>
	<article>
		<header class="header">
			<%@ include file="/html/header.html"%>
		</header>
		<main>
			<%@ include file="/html/topMain.html"%>
			<h2>Create your account</h2>
			<form id="signup-form" action="/create" method="post">
			<div class="form-group">
				<div class="input-group">
					<input type="text" id="name" name="nameTB" class="form-control"
						placeholder="Your Name"></input>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<input type="email" id="email" name="emailTB" class="form-control"
						placeholder="Email"></input>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<input type="password" id="password" name="passwordTB"
						class="form-control" placeholder="Password"></input>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<input type="password" id="passwordConfirm" name="passwordTB"
						class="form-control" placeholder="Confirm Password"></input>
				</div>
			</div>
			</form>
			<%@ include file="/html/bottomMain.html"%>
		</main>
		<footer>
			<%@ include file="/html/topFooter.html"%>
			<button id="sub" type="submit" hidden="true" form="signup-form"></button>
			<button type="button" class="btn btn-secondary"
				onclick="testOpenIndexPage();" class="btn btn-primary">Go
				Back</button>
			<button type="button" class="btn btn-primary"
				onclick="register();" class="btn btn-primary">
				Sign Up</button>
			<%@ include file="/html/bottomFooter.html"%>
		</footer>

		<!-- Message Modal -->
		<div id="messageModalSpace"></div>
		<!-- End Message Modal -->
	</article>
	<%@ include file="/html/scripts.html"%>
	<!-- <script type="text/javascript" src="../js/inputChecking.js"></script>
	<script type="text/javascript" src="../js/generalScripts.js"></script>
	<script type="text/javascript" src="../boot-js/bootstrap.min.js" /></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
</body>
</html>