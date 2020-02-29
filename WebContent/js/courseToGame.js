"use strict";

var courseC2G;
var playersC2G;

function element(id) {
	return document.getElementById(id);
}

function getRadioValue(name) { 
    var radio = document.getElementsByName(name); 
      
    for(var i = 0; i < radio.length; i++) { 
        if(radio[i].checked) {
        	return radio[i].value; 
        }
    } 	
}

function submitCourseOptions() {
	courseC2G = getRadioValue("courses");
	var select = element("guestsSelect");
	playersC2G = select.options[select.selectedIndex].value;
	var query = "?c=" + courseC2G + "&p=" + playersC2G;
	window.location.href = "./game.html" + query;
}

function buildCourseOptionsModal() {
	element("courseOptionsModalSpace").innerHTML = `
		<div class="modal fade" id="courseOptionsModal" tabindex="-1"
		role="dialog" aria-labelledby="courseOptionsModalTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title" id="courseOptionsModalTitle">
						Course	Options
					</h2>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container" style="text-align: center">
						<h3>Select Course</h3>
						<form id="gameOptions" action="createGame" method="post">
							<label class="radio-inline"> 
								<input type="radio" name="course" value="A" checked>
								Course A
							</label>
							&nbsp; 
							<label class="radio-inline"> 
							<input type="radio" name="course" value="B">
								Course B
							</label>
							<h3>How many players?</h3>
							<select id="guestsSelect" name="guests" data-style="btn-primary" 
							class="mdb-select md-form form-control my-form-control">
								<option value="1" selected>1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select> 
						</form>
						<br>
					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary"
							onclick="submitCourseOptions();" form="gameOptions">
							Start Game</button>
					</div>
				</div>
			</div>
		</div>
	</div>
		`;
}