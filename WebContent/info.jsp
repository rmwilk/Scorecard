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
		<%@ include file="inserts/topHeader.html"%>
		<button type="button" class="btn btn-danger" data-toggle="modal"
			data-target="#loginModal">
			Logout <i class="fas fa-sign-in-alt"></i>
		</button>
		<form id="backToHome" action="home" method="post"></form>
		<button type="submit" class="btn btn-primary" form="backToHome">
		Go Back <i class="fas fa-arrow-left"></i></button>
		<%@ include file="inserts/bottomHeader.html"%>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<!-- About Midway Section -->
			<h2>Park Info</h2>
			<div class="container" style="text-align: center">
				<h3 class="red">Admission</h3>
				<p>
					Midway is a pay as you go park, so there is no admission fee or
					"GATE CHARGE". You pay only for the attractions you participate in
					and are not required to purchase anything. Feel free to just bring
					the kids or grandkids in and follow them around the park. Midway
					offers "Ticket Value Paks" that are great for families and groups
					that are looking to do a little of everything. Unlimited ride
					wristbands are sold to groups of 50 or more who have made
					reservations. <br> Please see our group party section or call
					us at 313-277-9156 to book a group event.
				</p>
				<h3 class="red">Weather</h3>
				<p>
					Get ready for a day of fun and good times, but be prepared for all
					types of weather. Midway is an outdoor park and sometimes Mother
					Nature can cause us to temporarily suspend operations on some of
					our rides and attractions. However, <strong>Midway's
						unused ride tickets do not expire</strong> so you can always come back
					later in the day or another day. Go Karts, Miniature Golf, Bumper
					Cars (Sheltered), EuroBungy (Dome) and Batting Cages can all
					operate in a light to moderate rain. Our Golf Driving Range has
					sheltered tees so you can always hit golf balls rain or shine.
					Don't forget the sunscreen; even on cloudy days harmful rays can
					reach your skin.
				</p>
				<p>
					For more information, refer to our info page: <br> <a
						href="http://www.midwayfun.com/public/park-info/index.cfm">Additional
						Park Info</a> <i class="fas fa-external-link-alt"></i>
				</p>
			</div>
			<%@ include file="inserts/bottomMain.html"%>
		</main>
		<%-- <footer>
			<%@ include file="inserts/topFooter.html"%>
			<button type="button" hidden="true" style="">&nbsp;</button>
			<button type="submit" class="btn btn-primary"
				form="backToHome">Back to My Account</button>
			<%@ include file="inserts/bottomFooter.html"%>
		</footer> --%>
	</article>
	<%@ include file="inserts/scripts.html"%>
	<!-- Scripts -->
	<!-- <script type="text/javascript" src="../js/generalScripts.js"></script>
	<script type="text/javascript" src="../js/courseToGame.js"></script>
	<script type="text/javascript" src="../boot-js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.js" integrity="sha256-2JRzNxMJiS0aHOJjG+liqsEOuBb6++9cY4dSOyiijX4=" crossorigin="anonymous"></script>
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