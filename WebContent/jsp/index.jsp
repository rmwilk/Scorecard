<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="html/head.html"%>
<style>
<!-- Any Inline Styles -->
</style>
</head>
<body>
	<article>
		<%@ include file="html/header.html"%>
		<main>
			<div class="container-fluid list content">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12"></div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="border-container square-radius">
							<%@ include file="html/carousel.html"%>
							<br>
							<form class="form-container">
								<div class="form-group">
									<p>
										Not worried about saving your scores? <br>
										<button type="button" class="btn btn-primary"
											onclick="buildCourseOptionsModal2();" data-toggle="modal"
											data-toggle="modal" data-target="#courseOptionsModal2">
											Continue as a Guest <i class="fas fa-user"></i>
										</button>
									</p>
									<p>
										Keep your stats and save your past scores by signing up for
										free! <br> <a href="./signup.html">Click here to sign
											up </a> <i class="fas fa-user-plus"></i>
									</p>
								</div>
							</form>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12"></div>
					</div>
				</div>
			</div>
		</main>
		<footer>
			<div class="container-fluid list content">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12"></div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="border-container mid-footer">
							<button type="button" hidden="true" style="">&nbsp;</button>
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#loginModal">
								Login <i class="fas fa-sign-in-alt"></i>
							</button>
							<div class="footer-message">2020 - Designed by: Ryan Wilk</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12"></div>
				</div>
			</div>
		</footer>
		<!-- Code for Modals -->
		<!-- Login Modal -->
		<div id="loginModalSpace">
			<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
				aria-labelledby="loginModalTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h2 class="modal-title" id="loginModalTitle">Login</h2>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="container">
								<form id="login" class="form-container" action="LoginServlet" method="post">
									<h3>Enter Your Account Information</h3>
									<div class="form-group">
										<div class="input-group">
											<input type="email" id="email" name="emailTB"
												class="form-control" placeholder="Email"></input>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<input type="password" id="current-password"
												name="passwordTB" class="form-control"
												placeholder="Password"></input>
										</div>
									</div>
								<div id="errorMessageSpace"></div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Go Back</button>
								<button type="submit" class="btn btn-primary"
									<!-- onclick="testOpenAccountHomePage();" --> >Login</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Login Modal -->
		<!-- Course Options Modal -->
		<div id="courseOptionsModalSpace2"></div>
		<!-- End Course Options Modal -->

	</article>
	<%@ include file="html/scripts.html"%>
</body>
</html>