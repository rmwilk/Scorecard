"use strict";

var coursePop;
var playersPop;

function element(id) {
	return document.getElementById(id);
}



function printModalHint(html) {
	element("holeHintModalSpace").innerHTML = html;
}

function receiveFromServlet(guests, course){
	playersPop = guests;
	coursePop = course;
	var s = "";
	if(playersPop != 1){
		s = "s"
	}
	element("currentGame").innerHTML = playersPop + " Player" + s + " on Course " + coursePop;
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

function printPlayersToTHead() {
	var string = `
		<tr>
		<th id="hole#">#</th>
		<th id="par">Par</th>
		<th id="p1name" name="p1name">P1</th>
	`;
	if(playersPop > 1){
		string += `<th id="p2name" name="p2name">P2</th>`;
	}
	if(playersPop > 2){
		string += `<th id="p3name" name="p3name">P3</th>`;
	}
	if(playersPop > 3){
		string += `<th id="p4name" name="p4name">P4</th>`;
	}
	string += `<th>&nbsp;</th>`;
	return string;
}

function printPlayersToTBody() {
	var string = ``;
	for(var i = 1; i <= 18; i++) {
		var space = putSpace(i);
		string += `
			<tr>
				<td style="padding-left:2px; padding-right: 2px;">
					Hole ` + space + i + `
				</td>
				<td id="hole`+ i +`par" name="hole`+ i +`par"class="bold">2</td>
				<td id="p1hole` + i + `" name="p1hole` + i + `"class="stronger">-</td>
		`;

		element("game-table").innerHTML += printPlayersToTBody;
		if(playersPop > 1){
			string += `<td id="p2hole` + i + `" name="p2hole` + i + `" class="stronger">-</td>`;
		}
		if(playersPop > 2){
			string += `<td id="p3hole` + i + `" name="p3hole` + i + `"class="stronger">-</td>`;
		}
		if(playersPop > 3){
			string += `<td id="p4hole` + i + `" name="p4hole` + i + `"class="stronger">-</td>`;
		}
	string += `
			<td>
				<button type="button" class="btn btn-secondary btn-sm"
				data-toggle="modal"  data-target="#hintModal" onclick="buildHoleHintModal(`+i+`)">
					<i class="fas fa-question-circle"></i>
				</button>
				<button type="button" class="btn btn-primary btn-sm" onclick="buildHoleScoreModal(`+i+`); fillScores(`+i+`);"
					data-toggle="modal"	data-target="#holeScoreModal" style="max-width:100%">
						<i class="fas fa-edit"></i>
					</button>
			</td>
		 </tr>
		 `;
	}
	return string;
}

function testPopulateWithModals() {
	element("game-table").innerHTML += printPlayersToTHead();
	element("game-table").innerHTML += printPlayersToTBody();
}

function buildHoleScoreModal(hole) {
	var string = `
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
						<form id="scoreModalForm" action="score" method="post">
						<input type="hidden" name="hole" value="` + hole + `"/>
						<table class="table table-condensed">
							<thead>
								<tr>
									<th id="p1nameLB">P1</th>
	`;
	if(playersPop > 1){
		string += `<th id="p2nameLB">P2</th>`;
	}
	if(playersPop > 2){
		string += `<th id="p3nameLB">P3</th>`;
	}
	if(playersPop > 3){
		string += `<th id="p4nameLB">P4</th>`;
	}
	string += `													
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<select  id="p1h`+hole+`" name="p1score`+hole+`" data-style="btn-primary"
										class="mdb-select md-form form-control my-form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3" selected>3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</td>
		`;
	if(playersPop > 1){
		string += `
									<td>
										<select  id="p2h`+hole+`" name="p2score`+hole+`" data-style="btn-primary"
										class="mdb-select md-form form-control my-form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3" selected>3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</td>
		`;
	}
	if(playersPop > 2){
		string += `
									<td>
										<select  id="p3h`+hole+`" name="p3score`+hole+`" data-style="btn-primary"
										 class="mdb-select md-form form-control my-form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3" selected>3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</td>
		`;
	}
	if(playersPop > 3){
		string += `
									<td>
										<select  id="p4h`+hole+`" name="p4score`+hole+`" data-style="btn-primary"
										class="mdb-select md-form form-control my-form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3" selected>3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</td>
			`;
	}
	string += `				
								</tr>
							</tbody>
						</table>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">
						Close
					</button>
					<button type="submit" class="btn btn-success" form="scoreModalForm" >
						Enter
					</button>
				</div>
			</div>
		</div>
	</div>
	`;
	element("holeScoreModalSpace").innerHTML = string;
	// onclick="ajaxScore(` + hole + ',' + playersPop+`)" //data-dismiss="modal"
}
//enterScores(`+hole+`);
function fillScores(hole) {
	if(isNumber(element("p1hole"+hole).innerHTML)) {
		element("p1h"+hole).selectedIndex = element("p1hole"+hole).innerHTML;
	}
	if(playersPop > 1){
		if(isNumber(element("p2hole"+hole).innerHTML)) {
			element("p2h"+hole).selectedIndex = element("p2hole"+hole).innerHTML;
		}
	}
	if(playersPop > 2){
		if(isNumber(element("p3hole"+hole).innerHTML)) {
			element("p3h"+hole).selectedIndex = element("p3hole"+hole).innerHTML;
		}
	}
	if(playersPop > 3){
		if(isNumber(element("p4hole"+hole).innerHTML)) {
			element("p4h"+hole).selectedIndex = element("p4hole"+hole).innerHTML;
		}
	}
}

function enterScores(hole){
	element("p1hole"+hole).innerHTML = element("p1h"+hole).value;
	if(playersPop > 1){
		element("p2hole"+hole).innerHTML = element("p2h"+hole).value;
	}
	if(playersPop > 2){
		element("p3hole"+hole).innerHTML = element("p3h"+hole).value;
	}
	if(playersPop > 3){
		element("p4hole"+hole).innerHTML = element("p4h"+hole).value;
	}
}

function isNumber(num) {
	switch (num) {
	case 1:case 2: case 3: case 4: case 5: case 6: case 0: {
		return true;		
	}
		default: {
			return false;
		}
	}
}

function calculateScores() {
	var p1scores = 0;
	var p2scores;
	var p3scores;
	var p4scores;
	var par = 0;
	var p1name = element("p1name").innerHTML;
	var p2name;
	var p3name;
	var p4name;
	if(playersPop > 1){
		p2scores = 0;
		p2name = element("p2name").innerHTML;
	}
	if(playersPop > 2){
		p3scores = 0;
		p3name = element("p3name").innerHTML;
	}
	if(playersPop > 3){
		p4scores = 0;
		p4name = element("p4name").innerHTML;
	}
	
	for(var i = 1; i <= 18; i ++) {
		if(isNumber(parseInt(element("p1hole" + i).innerHTML)) ) {
			p1scores +=	parseInt(element("p1hole" + i).innerHTML);			
		}
		if(playersPop > 1){
			if(isNumber(parseInt(element("p2hole" + i).innerHTML)) ) {
				p2scores +=	parseInt(element("p2hole" + i).innerHTML);			
			}
		}
		if(playersPop > 2){ 
			if(isNumber(parseInt(element("p3hole" + i).innerHTML)) ){
				p3scores +=	parseInt(element("p3hole" + i).innerHTML);			
			}
		}
		if(playersPop > 3){
			if(isNumber(parseInt(element("p4hole" + i).innerHTML)) ){
				p4scores +=	parseInt(element("p4hole" + i).innerHTML);			
			}
		}
		
		par += parseInt(element("hole"+i+"par").innerHTML);
	} // end for loop
	
	
	var string = `
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
	`;
	if(playersPop > 1){
		string += `<th>`+p2name+`</th>`;
	}
	if(playersPop >2){
		string += `<th>`+p3name+`</th>`;
	}
	if(playersPop > 3){
		string += `<th>`+p4name+`</th>`;
	}
	string += `						
								</thead>
								<tbody>
										<tr>
											<td>`+par+`</td>
											<td>`+p1scores+`</td>
	`;
	if(playersPop > 1){
		string += `<td>`+p2scores+`</td>`;
	}
	if(playersPop > 2){
		string += `<td>`+p3scores+`</td>`;
	}
	if(playersPop > 3){
		string += `<td>`+p4scores+`</td>`;
	}
	string += `											
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
						<button type="submit" form="submitscorecard" class="btn btn-success">
							Submit Scorecard
						</button>
					</div>
				</div>
			</div>
		</div>
		`;
		element("leaderboardModalSpace").innerHTML = string; 
	
}