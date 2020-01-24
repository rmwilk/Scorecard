"use strict";

function element(id) {
	return document.getElementById(id);
}

function clearTableData() {
	element("game-table").innerHTML = "";
	testPopulateWithModals();
}

function putSpace(num) {
	if(num <10) {
		return "&nbsp;&nbsp;";
	}
	else {
		return "";
	}
}

function testPopulateWithModals() {
	element("game-table").innerHTML += `
		<tr>
			<th id="hole#">#</th>
			<th id="par">Par</th>
			<th id="p1name">P1</th>
			<th id="p2name">P2</th>
			<th id="p3name">P3</th>
			<th id="p4name">P4</th>	
			<th></th>
		</tr>
		`;
	for(var i = 1; i <= 18; i++) {
		var space = putSpace(i);
		element("game-table").innerHTML += `
			<tr>
				<td>
					<button type="button" class="btn btn-primary" onclick="buildHoleScoreModal(`+i+`);"
					data-toggle="modal"	data-target="#holeScoreModal">
						Enter Hole ` + space + i + `
					</button>
				</td>
				<td id="hole`+i+`par" class="bold">2</td>
				<td id="p1hole` + i + `" class="stronger">
					-
				</td>
				<td id="p2hole` + i + `" class="stronger">
					-
				</td>
				<td id="p3hole` + i + `" class="stronger">
					-
				</td>
				<td  id="p4hole` + i + `" class="stronger">
					-
				</td>
				<td>
					<button type="button" class="btn btn-primary btn-sm"
					 data-toggle="modal"  data-target="#hintModal" onclick="buildHoleHintModal(`+i+`)">
						Hint
					</button>
				</td>
			</tr>
			`;
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

function buildHoleScoreModal(hole) {
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
						<h3>Input Everyone's Scores for Hole ` + hole + `</h3>
						<table class="table table-condensed">
							<thead>
								<tr>
									<th id="p1nameLB">P1</th>
									<th id="p2nameLB">P2</th>
									<th id="p3nameLB">P3</th>
									<th id="p4nameLB">P4</th>									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<select  id="p1h`+hole+`" class="mdb-select md-form">
											<option value="4" selected disabled hidden="true"></option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
										</select>
									</td>
									<td>
										<select  id="p2h`+hole+`" class="mdb-select md-form">
											<option value="4" selected disabled hidden="true"></option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
										</select>
									</td>
									<td>
										<select  id="p3h`+hole+`" class="mdb-select md-form">
											<option value="4" selected disabled hidden="true"></option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
										</select>
									</td>
									<td>
										<select  id="p4h`+hole+`" class="mdb-select md-form">
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
					onclick="enterScores(`+hole+`);">
						Enter
					</button>
				</div>
			</div>
		</div>
	</div>
	`;
}

function enterScores(hole){
	console.log(element("p1h"+hole).value);
	element("p1hole"+hole).innerHTML = element("p1h"+hole).value;
	element("p2hole"+hole).innerHTML = element("p2h"+hole).value;
	element("p3hole"+hole).innerHTML = element("p3h"+hole).value;
	element("p4hole"+hole).innerHTML = element("p4h"+hole).value;
}

function isNumber(num) {
	switch (num) {
	case 1:case 2: case 3: case 4: case 0: {
		return true;		
	}
		default: {
			return false;
		}
	}
}

function calculateScores() {
	var p1scores = 0;
	var p2scores = 0;
	var p3scores = 0;
	var p4scores = 0;
	var par = 0;
	var p1name = element("p1name").innerHTML;
	var p2name = element("p2name").innerHTML;
	var p3name = element("p3name").innerHTML;
	var p4name = element("p4name").innerHTML;
	
	for(var i = 1; i <= 18; i ++) {
		if(isNumber(parseInt(element("p1hole" + i).innerHTML)) ) {
			p1scores +=	parseInt(element("p1hole" + i).innerHTML);			
		}
		if(isNumber(parseInt(element("p2hole" + i).innerHTML)) ) {
			p2scores +=	parseInt(element("p2hole" + i).innerHTML);			
		}
		if(isNumber(parseInt(element("p3hole" + i).innerHTML)) ){
			p3scores +=	parseInt(element("p3hole" + i).innerHTML);			
		}
		if(isNumber(parseInt(element("p4hole" + i).innerHTML)) ){
			p4scores +=	parseInt(element("p4hole" + i).innerHTML);			
		}
		par += parseInt(element("hole"+i+"par").innerHTML);
	} // end for loop
	
	
	element("leaderboardModalSpace").innerHTML = `
		<div class="modal fade" id="leaderboardModal" tabindex="-1"
			role="dialog" aria-labelledby="#leaderboardModalTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title" id="leaderboardModalTitle">
							Leaderboard
						</h2>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container" style="text-align: center; align-content: center">
							<h3>Lowest score wins!</h3>
							<table id="leaderboard" class="table" style="margin: auto">
								<thead>
									<tr>
										<th>Par</th>
										<th>`+p1name+`</th>
										<th>`+p2name+`</th>
										<th>`+p3name+`</th>
										<th>`+p4name+`</th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<td>`+par+`
											<td>`+p1scores+`</td>
											<td>`+p2scores+`</td>
											<td>`+p3scores+`</td>
											<td>`+p4scores+`</td>
										</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" 
						data-dismiss="modal">
							Back to Scorecard
						</button>
						<button type="button" class="btn btn-success" 
						data-dismiss="modal" onclick="testOpenIndexPage();">
							Submit Scorecard
						</button>
					</div>
				</div>
			</div>
		</div>
		`;
	
}