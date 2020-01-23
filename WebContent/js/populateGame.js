"use strict";

function element(id) {
	return document.getElementById(id);
}

function clearTableData() {
	element("game-table").innerHTML = "";
	testPopulate();
}

function testPopulateWithModals(){
	element("game-table").innerHTML += `
		<tr>
			<th id="hole#">#</th>
			<th id="par">Par</th>
			<th id="p1">P1</th>
			<th id="p2">P2</th>
			<th id="p3">P3</th>
			<th id="p4">P4</th>
			<th></th>
		</tr>`;
	for(var i = 1; i <= 18; i++){
		getID("game-table").innerHTML += `
			<tr>
				<td>
					<button type="button" class="btn btn-primary"
					data-toggle="modal"	data-target="#holeModal" onclick="buildHoleModal(`+i+`)">
						Hole ` + i + `
					</button></td>
				<td>2</td>
				<td id="p1hole` + i + `">
					-
				</td>
				<td id="p2hole` + i + `">
					-
				</td>
				<td id="p3hole` + i + `">
					-
				</td>
				<td  id="p4hole` + i + `">
					-
				</td>
				<td>
					<button type="button" class="btn btn-primary btn-sm"
					 data-toggle="modal"  data-target="#hintModal" onclick="buildHoleHintModal(`+i+`)">
						Hint
					</button>
				</td>
			</tr>`;
	}
}

function testPopulate(){
	element("game-table").innerHTML += `
		<tr>
			<th id="hole#">#</th>
			<th id="par">Par</th>
			<th id="player1">P1</th>
			<th id="player2">P2</th>
			<th id="player3">P3</th>
			<th id="player4">P4</th>
			<th>Hint</th>
		</tr>`;
	for(var i = 1; i <= 18; i++){
	getID("game-table").innerHTML += `
		<tr>
			<td>` + i + `</td>
			<td>2</td>
			<td>
				<select class="mdb-select md-form">
					<option value="0" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td>
				<select class="mdb-select md-form">
					<option value="0" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td>
				<select class="mdb-select md-form">
					<option value="0" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td>
				<select class="mdb-select md-form">
					<option value="0" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
		</tr>`;
	}
}

function buildHoleHintModal(hole){
	element("holeHintModalSpace").innerHTML = 
		`<div class="modal fade" id="hintModal" tabindex="-1"
		role="dialog" aria-labelledby="#hintModalTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="hintModalTitle">
							Hole `+ hole + ` Hint
						</h2>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container" style="text-align: center">
							<!-- TODO -->
							<p>This is where the hint goes!</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">
							Close
						</button>
					</div>
				</div>
			</div>
		</div>`;
}

function buildHoleModal(hole) {
	element("holeScoreModalSpace").innerHTML = `
	<div class="modal fade" id="holeScoreModal" tabindex="-1"
		role="dialog" aria-labelledby="#holeScoreModalTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title" id="holeScoreModalTitle">
						Hole `+hole+` Score
					</h2>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container" style="text-align: center">
						<h3>Input Everyone's Scores</h3>
						<table class="table">
							<thead>
								<tr>
									<th>P1</th>
									<th>P2</th>
									<th>P3</th>
									<th>P4</th>									
								</tr>
							</thead>
							<tbody>
								<tr>
			<td>` + i + `</td>
			<td>2</td>
			<td id="p1h`+hole+`">
				<select class="mdb-select md-form">
					<option value="4" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td id="p2h`+hole+`">
				<select class="mdb-select md-form">
					<option value="4" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td id="p3h`+hole+`">
				<select class="mdb-select md-form">
					<option value="4" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
			<td id="p4h`+hole+`">
				<select class="mdb-select md-form">
					<option value="4" selected disabled hidden="true"></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</td>
		</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">
						Close
					</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" 
					onclick="enterScores(hole);">
						Enter
					</button>
				</div>
			</div>
		</div>
	</div>
	`;
}

function enterScores(hole){
	element("p1hole"+hole).innerHTML = element("p1h"+hole).value;
	element("p2hole"+hole).innerHTML = element("p2h"+hole).value;
	element("p3hole"+hole).innerHTML = element("p3h"+hole).value;
	element("p4hole"+hole).innerHTML = element("p4h"+hole).value;
}
function calculateScores() {
	window.location = "./index.html";
}