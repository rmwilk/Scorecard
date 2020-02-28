<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="inserts/head.html"%>
</head>
<body>
	<article>
		<%@ include file="inserts/topHeader.html"%>
		<%@ include file="inserts/bottomHeader.html"%>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<%@ include file="inserts/carousel.html"%>
			<br>
			<div class="form-container">
				<div class="form-group">
					<p>
						Login with your account here <br>
						<button type="button" class="btn btn-danger" data-toggle="modal"
							data-target="#loginModal">
							Login <i class="fas fa-sign-in-alt"></i>
						</button>
					</p>
					<form id="guest-game" action="guest" method="post">
						<p>
							Not worried about saving your scores? <br>
							<button type="button" class="btn btn-primary"
								onclick="buildCourseOptionsModal2();" data-toggle="modal"
								data-toggle="modal" data-target="#courseOptionsModal2">
								Continue as a Guest <i class="fas fa-user"></i>
							</button>
						</p>
					</form>
					<form id="create-account" action="register " method="post">
						<p>
							Keep your stats and save your past scores by signing up for free!
							<br>
							<button type="submit" class="btn btn-secondary">
								Click here to sign up <i class="fas fa-user-plus"></i>
							</button>
						</p>
					</form>
				</div>
			</div>
			<%@ include file="inserts/bottomMain.html"%>
		</main>
		<%-- <footer>
			<%@ include file="inserts/topFooter.html"%>
			<button type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#loginModal">
				Login <i class="fas fa-sign-in-alt"></i>
			</button>
			<%@ include file="inserts/bottomFooter.html"%>
		</footer> --%>
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
								<form id="login" class="form-container" action="login"
									method="post">
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
								</form>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Go Back</button>
								<button type="submit" form="login" class="btn btn-primary">
									Login</button>
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
	<%@ include file="inserts/scripts.html"%>
</body>
</html>