function ajaxHint(hole) {
	// alert("Ajax called on hole: " + hole);
	$.ajax({
		type : 'POST',
		url : 'HintModalBuilder',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
	    dataType: "json",
		data: {
			hole : hole
		},
		success : function() {
			//alert("Ajax success?");
		}
	})
}
/*
 * $.ajax({ url: url, data: data, success: success, dataType: dataType });
 */

//function callAjax(hole) {
//
//	document.getElementById('loading').innerHTML = "Loading Data...";
//
//	var httpRequest = new XMLHttpRequest();
//
//	if (!httpRequest) {
//		console.log('Unable to create XMLHTTP instance');
//		return false;
//	}
//	httpRequest.open('POST', 'HintModalBuilder');
//	httpRequest.responseType = 'json';
//	httpRequest.send();
//	httpRequest.onreadystatechange = function() {
//		if (httpRequest.readyState === XMLHttpRequest.DONE) {
//
//			document.getElementById('loading').innerHTML = "";
//
//			if (httpRequest.status === 200) {
//
//				var array = httpRequest.response;
//				for (var i = 0; i < array.length; i++) {
//
//					var table = document.getElementById('contentTable');
//					var row = table.insertRow(table.rows.length);
//					var cell1 = row.insertCell(0);
//					var cell2 = row.insertCell(1);
//					var name = document.createTextNode(array[i].name);
//					var age = document.createTextNode(array[i].age);
//					cell1.appendChild(name);
//					cell2.appendChild(age);
//				}
//			} else {
//				console.log('Something went wrong..!!');
//			}
//		}
//	}
//}