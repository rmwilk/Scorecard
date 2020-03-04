"use strict:";

function element(id) {
	return document.getElementById(id);
}

function openCourseStats(event, course) {
	// adapted from https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_tabs
	  var i;
	  var tabcontent;
	  var tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  element(course).style.display = "block";
	  event.currentTarget.className += " active";
}

