<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inserts/head.html"%>
<style>
.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
</head>
<body>
	<article>
		<%@ include file="inserts/topHeader.html"%><%@ include
			file="inserts/bottomHeader.html"%>
		<main>
			<%@ include file="inserts/topMain.html"%>
			<!-- -------------------------------------------------------------------------- -->
			<h2>Submitting Score...</h2>
			<div class="loader"></div>
			<!-- -------------------------------------------------------------------------- -->
			<%@ include file="inserts/bottomMain.html"%>
		</main>
	</article>
	<!-- Scripts -->
	<%@ include file="inserts/scripts.html"%>
	<script type="text/javascript" src="js/populateGame.js"></script>
	<script type="text/javascript" src="js/ajaxHint.js"></script>
	<script type="text/javascript" src="js/ajaxScore.js"></script>
</body>
</html>