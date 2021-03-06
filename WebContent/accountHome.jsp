<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="inserts/head.html"%>
</head>
<body>
	<article>
		<%@ include file="inserts/topHeader.html"%>
		<!-- Page Specific Buttons Go Here -->
		<form id="logout" action="logout" method="post"></form>
		<button type="submit" class="btn btn-danger" form="logout">
			Log Out <i class="fas fa-sign-out-alt" aria-hidden="true"></i>
		</button>
		<%@ include file="inserts/bottomHeader.html"%>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<h2 id="greeting">Logged In As: ${ sessionScope.account.email }</h2>
			<div class="container">
				<div class="btn-group-vertical d-flex btn-group-lg ">
					<button type="button" onclick="buildCourseOptionsModal();"
						class="btn btn-primary btn-border-bottom stats-btn"
						data-toggle="modal" data-target="#courseOptionsModal">
						<i class="fas fa-golf-ball" aria-hidden="true"></i> Play
						<!-- / Continue -->
						A Round <i class="fas fa-golf-ball" aria-hidden="true"></i>
					</button>
					<button type="submit"
						class="btn btn-primary btn-border-bottom stats-btn" form="myStats">
						Check My Stats <i class="fas fa-chart-line" aria-hidden="true"></i>
					</button>
					<button type="button"
						class="btn btn-primary btn-border-bottom stats-btn"
						data-toggle="modal" data-target="#courseRulesModal">
						Course Rules <i class="fa fa-gavel" aria-hidden="true"></i>
					</button>
					<button type="submit" class="btn btn-primary stats-btn"
						form="parkInfo">
						Park Info <i class="fas fa-info-circle" aria-hidden="true"></i>
					</button>
				</div>
			</div>
			<form id="myStats" action="stats" method="post"></form>
			<form id="parkInfo" action="info" method="post"></form>

			<%@ include file="inserts/bottomMain.html"%>
		</main>
		<%-- <footer>
			<%@ include file="html/topFooter.html"%>
			<button type="button" hidden="true" style="">&nbsp;</button>
			<button type="submit" class="btn btn-danger" form="logout">
				Log Out <i class="fas fa-sign-out-alt" aria-hidden="true"></i>
			</button>
			<%@ include file="html/bottomFooter.html"%>
		</footer> --%>
		<!-- Course Options Modal -->
		<div id="courseOptionsModalSpace"></div>
		<!-- Course Rules Modal -->
		<div class="modal fade" id="courseRulesModal" tabindex="-1"
			role="dialog" aria-labelledby="courseRulesModalTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="courseRulesModalTitle">Mini Golf
							Rules</h2>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container">
							<h3>Course Rules</h3>
							<ul>
								<li><strong>ALL CHILDREN</strong> must be accompanied by an
									adult</li>
								<li>Please limit all groups to a maximum of four (4)
									players</li>
								<li>Please play holes in order</li>
								<li><strong>45 MINUTE TIME LIMIT</strong>(18 holes)</li>
								<li>Please use putting strokes only! <strong>NO
										FULL SWINGS</strong></li>
								<li>Please <strong>STAY OUT</strong> of ponds and
									landscaped areas
								</li>
								<li>Please be courteous to course wildlife</li>
								<li>Please no running or horseplay</li>
								<li>Please <strong>NO ROCK THROWING</strong></li>
								<li>Be considerate of others</li>
								<li>Do not bang clubs on objects</li>
							</ul>
							<h3>Playing Rules</h3>
							<ul>
								<li>Every player in group putts a ball before a second shot
									is taken</li>
								<li>Player farthest from the hole putts next</li>
								<li>One stroke penalty for any of the following:
									<ul>
										<li>ball jumps side rail (replace where ball jumped rail)</li>
										<li><strong>DO NOT HIT BALL OFF REAL GRASS OR
												CEMENT</strong></li>
										<li>ball snagged in an obstacle (replace 6 inches from
											obstacle)</li>
										<li>ball rolls back to tee (replace on tee and hit again)</li>
									</ul>
								</li>
								<li>Move ball 6 inches from obstacle or rail (no penalty)</li>
								<li>Ball hit by another ball - return to original spot (no
									penalty)</li>
								<li><strong>MAXIMUM OF 6 STROKES PER HOLE - MOVE
										TO NEXT TEE</strong></li>
								<li>Replaying of any hole is not permitted - stay on course</li>
								<li>Player with the lowest score on hole tees first on next
									hole</li>
							</ul>
							<p class="fancy-centered">Please Be Courteous! Have Fun!</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- About Midway Modal -->
		<div class="modal fade" id="aboutMidwayModal" tabindex="-1"
			role="dialog" aria-labelledby="aboutMidwayModalTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="aboutMidwayModalTitle">About
							Midway</h2>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container" style="text-align: center">
							<h3>Admission</h3>
							<p>Midway is a pay as you go park, so there is no admission
								fee or "GATE CHARGE". You pay only for the attractions you
								participate in and are not required to purchase anything. Feel
								free to just bring the kids or grandkids in and follow them
								around the park. Midway offers "Ticket Value Paks" that are
								great for families and groups that are looking to do a little of
								everything. Unlimited ride wristbands are sold to groups of 50
								or more who have made reservations. Please see our group party
								section or call us at 313-277-9156 to book a group event.</p>
							<h3>Weather</h3>
							<p>Get ready for a day of fun and good times, but be prepared
								for all types of weather. Midway is an outdoor park and
								sometimes Mother Nature can cause us to temporarily suspend
								operations on some of our rides and attractions. However,
								Midway's unused ride tickets do not expire so you can always
								come back later in the day or another day. Go Karts, Miniature
								Golf, Bumper Cars (Sheltered), EuroBungy (Dome) and Batting
								Cages can all operate in a light to moderate rain. Our Golf
								Driving Range has sheltered tees so you can always hit golf
								balls rain or shine. Don't forget the sunscreen; even on cloudy
								days harmful rays can reach your skin.</p>
							<p>
								For more information, refer to our info page: <br> <a
									href="http://www.midwayfun.com/public/park-info/index.cfm">Additional
									Park Info</a>
							</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End About Modal -->
		<!-- Scripts -->
		<%@ include file="inserts/scripts.html"%>
	<script type="text/javascript" src="js/populateGame.js"></script>
	<script type="text/javascript" src="js/ajaxHint.js"></script>
	<script type="text/javascript" src="js/ajaxScore.js"></script>
	<script type="text/javascript" src="js/forceSubmit.js"></script>
		<!-- <script type="text/javascript" src="js/generalScripts.js"></script>
		<script type="text/javascript" src="js/courseToGame.js"></script>
		<script type="text/javascript" src="boot-js/bootstrap.min.js" /></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.js"
			integrity="sha256-2JRzNxMJiS0aHOJjG+liqsEOuBb6++9cY4dSOyiijX4="
			crossorigin="anonymous"></script>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/mdb.min.js"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
	</article>
</body>
</html>