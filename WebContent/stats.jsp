<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page session="true"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="inserts/head.html"%>
</head>
<style>
.pt-5, .py-5 {
	padding-top: 0 !important;
}
</style>
</head>
<body onload="openCourseStats(event, 'courseA');">
	<article>
		<header class="header">
			<%@ include file="inserts/topHeader.html"%>
			<form id="logout" action="logout" method="post"></form>
			<button type="submit" class="btn btn-danger" form="logout">
				Log Out <i class="fas fa-sign-out-alt" aria-hidden="true"></i>
			</button>
			<form id="backToHome" action="home" method="post"></form>
			<button type="submit" form="backToHome" class="btn btn-primary">
			Go Back <i class="fas fa-arrow-left"></i>
				</button>
			<%@ include file="inserts/bottomHeader.html"%>
		</header>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<h2>My Stats</h2>
			<p>
				<strong>!!!! Page Under Construction !!!!</strong>
				<!-- TODO -->
			<h3 class="red">General Stats</h3>
			<table id="generalStats" class="table stats-table table-sm">
				<tbody>
					<tr>
						<td>Total Games:</td>
						<td id="totalGames">&nbsp;</td>
					</tr>
					<tr>
						<td>Total Holes In One:</td>
						<td id="totalHolesInOne">&nbsp;</td>
					</tr>
					<tr>
						<td>First Game Played:</td>
						<td id="firstGameDate">&nbsp;</td>
					</tr>
					<tr>
						<td>Last Game Played:</td>
						<td id="lastGameDate">&nbsp;</td>
					</tr>
				</tbody>
			</table>

			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

			<h3 class="red">Course Stats</h3>
			<ul class="nav nav-tabs nav-justified md-tabs indigo" id="myTabJust"
				role="tablist">
				<li class="nav-item"><a class="nav-link active" id="a-tab-just"
					data-toggle="tab" href="#a-just" role="tab" aria-controls="a-just"
					aria-selected="true">Course A</a></li>
				<li class="nav-item"><a class="nav-link" id="b-tab-just"
					data-toggle="tab" href="#b-just" role="tab" aria-controls="b-just"
					aria-selected="false">Course B</a></li>
			</ul>
			<div class="tab-content card pt-5" id="courseA">
				<div class="tab-pane fade show active" id="a-just" role="tabpanel"
					aria-labelledby="a-tab-just">
					<table id="courseATable" class="table stats-table">
						<tr>
							<td>Total Games:</td>
							<td id="totalA">&nbsp;</td>
						</tr>
						<tr>
							<td>Best Score:</td>
							<td id="bestA">&nbsp;</td>
						</tr>
						<tr>
							<td>Worst Score:</td>
							<td id="worstA">&nbsp;</td>
						</tr>
						<tr>
							<td>Average Score:</td>
							<td id="avgA">&nbsp;</td>
						</tr>
					</table>
				</div>
				<div class="tab-pane fade" id="b-just" role="tabpanel"
					aria-labelledby="b-tab-just">
					<table id="courseBTable" class="table stats-table">
						<tbody>
							<tr>
								<td>Total Games:</td>
								<td id="totalB">&nbsp;</td>
							</tr>
							<tr>
								<td>Best Score:</td>
								<td id="bestB">&nbsp;</td>
							</tr>
							<tr>
								<td>Worst Score:</td>
								<td id="worstB">&nbsp;</td>
							</tr>
							<tr>
								<td>Average Score:</td>
								<td id="avgB">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<br>
			<%@ include file="inserts/bottomMain.html"%>
		</main>
		<%-- <footer>
			<%@ include file="inserts/topFooter.html"%>
			<button type="submit" form="backToHome"
				class="btn btn-primary">Back to Account Home</button>
			<%@ include file="inserts/bottomFooter.html"%>
		</footer> --%>
	</article>
	<%@ include file="inserts/scripts.html"%>
	<!-- <script type="text/javascript" src="../js/generalScripts.js"></script>
		<script type="text/javascript" src="../js/statsScripts.js"></script>
		<script type="text/javascript" src="../boot-js/bootstrap.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/mdb.min.js"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
</body>
</html>