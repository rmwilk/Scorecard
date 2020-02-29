"use strict";

function ajaxScore(hole, players) {
	var p1 = getScores(hole, 1);
	var p2 = 0;
	var p3 = 0;
	var p4 = 0;
	
	if(players > 1){
		p2 = getScores(hole, 2);
	}
	if(playersPop > 2){
		p3 = getScores(hole, 3);
	}
	if(playersPop > 3){
		p4 = getScores(hole, 4);
	}
	
	alert(p1 + " " + p2+ " "  + p3 + " " + p4);
	$.ajax({
		type : 'POST',
		url : 'score',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
	    dataType: "json",
		data: {
			hole : hole,
			p1 : p1,
			p2 : p2,
			p3 : p3,
			p4 : p4
		},
		success : function() {
			//alert("Ajax success?");
		}
	})
}

function element(id){
	return document.getElementById(id);
} 

function getScores(hole, p) {
	var id = "p" + p + "h" + hole;
	var e = element(id);
	if(e.options[e.selectedIndex].value != null){
		return e.options[e.selectedIndex].value;
	}
	else{
		return 0;
	}
}