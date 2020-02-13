"use strict";

function element(id) {
	return document.getElementById(id);
}

function testOpenAccountHomePage() {
	window.location = "./accountHome.html";
}

function testOpenIndexPage() {
	window.location = "./index.html";
}

function testOpenStatsPage() {
	window.location = "./stats.html";
}

function testOpenGamePage() {
	window.location = "./game.html";
}

function testOpenInfoPage() {
	window.location = "./info.html";
}

function createAccountSubmitLink() {
	element("create-account").submit();
}