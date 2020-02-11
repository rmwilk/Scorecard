<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../html/head.html"%>
</head>
<body>
	<article>
		<%@ include file="../html/header.html"%>
		<main>
			<%@ include file="../html/topMain.html"%>
			<%@ include file="../html/carousel.html"%>
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
						Keep your stats and save your past scores by signing up for free!
						<br> 
						<a href="./signup.html">
						Click here to sign up </a><i	class="fas fa-user-plus"></i>
					</p>
				</div>
			</form>
			<%@ include file="../html/bottomMain.html"%>
		</main>
		<footer>
			<%@ include file="../html/topFooter.html"%>
			<button type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#loginModal">
				Login <i class="fas fa-sign-in-alt"></i>
			</button>
			<%@ include file="../html/bottomFooter.html"%>
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
								<form id="login" class="form-container" action="../LoginServlet"
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
	<%@ include file="../html/scripts.html"%>
</body>
</html>