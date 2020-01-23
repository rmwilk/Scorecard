"use strict";

function element(id) {
	return document.getElementById(id);
}

function clearTableData() {
	element("game-table").innerHTML = "";
	testPopulate();
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
	<td>`+i+`</td>
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
	<td>
		<!-- <button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-question-sign">?</span></button> -->
		<img class="hint-img" src="../images/hint-img.png">
	</td>
</tr>`;
	}
}

function calculateScores() {
	window.location = "./index.html";
}