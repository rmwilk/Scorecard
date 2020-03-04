<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="inserts/head.html"%>
<link rel="stylesheet" type="css/text" href="css/statsStyles.css" />
</head>
<style>
.pt-5, .py-5 {
	padding-top: 0 !important;
}
</style>
</head>
<body>
	<article>
		<header class="header">
			<%@ include file="inserts/topHeader.html"%>
			<button type="submit" form="backToHome" class="btn btn-primary">
				Go Back <i class="fas fa-arrow-left"></i>
			</button>
			<button type="submit" class="btn btn-danger" form="logout">
				Log Out <i class="fas fa-sign-out-alt" aria-hidden="true"></i>
			</button>
			<form id="backToHome" action="home" method="post"></form>
			<form id="logout" action="logout" method="post"></form>
			<%@ include file="inserts/bottomHeader.html"%>
		</header>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<h2>My Stats</h2>
			<h3 class="red">General Stats</h3>
			<table id="generalStats" class="table stats-table table-sm">
				<tbody>
					<tr>
						<td>Total Games:</td>
						<td id="totalGames"><c:out value="${ totalGames }" /></td>
					</tr>
					<tr>
						<td>Total Holes In One:</td>
						<td id="totalHolesInOne"><c:out value="${ totalAces }" /></td>
					</tr>
					<%-- <tr>
						<td>Total Shots:</td>
						<td id="totalShots"><c:out value="${ totalShots }" /></td>
					</tr> --%>
					<%-- <tr>
						<td>First Game Played:</td>
						<td id="firstGameDate"><c:out value="${ firstGame }"/></td>
					</tr>
					<tr>
						<td>Last Game Played:</td>
						<td id="lastGameDate"><c:out value="${ lastGame }"/></td>
					</tr> --%>
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
							<td id="totalA"><c:out value="${ totalA }" /></td>
						</tr>
						<tr>
							<td>Total Holes-In-One:</td>
							<td id="acesA"><c:out value="${ acesA }" /></td>
						</tr>
						<tr>
							<td>Best Score:</td>
							<td id="bestA"><c:out value="${ bestA }" /></td>
						</tr>
						<tr>
							<td>Worst Score:</td>
							<td id="worstA"><c:out value="${ worstA }" /></td>
						</tr>
						<tr>
							<td>Average Score:</td>
							<td id="avgA"><c:out value="${ averageA }" /></td>
						</tr>
					</table>
				</div>
				<div class="tab-pane fade" id="b-just" role="tabpanel"
					aria-labelledby="b-tab-just">
					<table id="courseBTable" class="table stats-table">
						<tbody>
							<tr>
								<td>Total Games:</td>
								<td id="totalB"><c:out value="${ totalB }" /></td>
							</tr>
							<tr>
								<td>Total Holes-In-One:</td>
								<td id="acesB"><c:out value="${ acesB }" /></td>
							</tr>
							<tr>
								<td>Best Score:</td>
								<td id="bestB"><c:out value="${ bestB }" /></td>
							</tr>
							<tr>
								<td>Worst Score:</td>
								<td id="worstB"><c:out value="${ worstB }" /></td>
							</tr>
							<tr>
								<td>Average Score:</td>
								<td id="avgB"><c:out value="${ averageB }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<br>
			<button type="button" class="btn btn-danger" data-toggle="modal"
				data-target="#deleteModal">Delete My Stats</button>
			<form id="deleteStats" name="deleteStats" action="delete"
				method="post"></form>
			<br>
			<!-- Delete Modal -->
			<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
				aria-labelledby="deleteModalTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-body">
							<div class="container" style="text-align: center">
								<p>
									<strong>Are you sure you want to delete your stats?</strong>
								</p>
								<p>This cannot be undone!!</p>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" aria-label="Close">Nevermind</button>
								<button type="submit" form="deleteStats" class="btn btn-danger">Delete</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End Delete Modal -->
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<br>
			<%@ include file="inserts/bottomMain.html"%>
		</main>
	</article>
	<%@ include file="inserts/scripts.html"%>
</body>
</html>