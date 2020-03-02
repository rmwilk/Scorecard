"use strict";

function forceSubmit() {
	alert("forceSubmit()");
	$.ajax({
		type : 'POST',
		url : 'game',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8;",
		dataType : "json",
		data : {
			forced : true
		},
		success : function() {
			// alert("Ajax success?");
		}
	})
}