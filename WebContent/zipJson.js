//Created By: Jack Young.   SWE642

function getRequestObject() {
	if(window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return (null);
	}
}

function ajaxResult(zip) {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		showResponseText(request, zip);
	}
	request.open("GET", "data.json", true);
	request.send(null);
}

function showResponseText(request, zip) {
	if ((request.readyState == 4) && (request.status == 200)) {
		//alert(request.responseText);
		var r = extractInfo(request.responseText, zip);
		if(r[0]) {
			document.getElementById("city").value = r[1];
			document.getElementById("state").value = r[2];
			document.getElementById("zip_error_field").innerHTML = ""; //clear zip error field
		} else {
			//alert("Error, did not find corresponding info with the provide Zip code.");
			document.getElementById("zip_error_field").innerHTML = "Error, invalid zip.";
		}
		//return request.responseText;
	}
}



//index 0: if true means found result, else it did not find match result
//index 1: city
//index 2: state
function extractInfo(response, desiredZip) {
	var obj = JSON.parse(response);
	var size = obj.zipcodes.length;
	
	var result = new Array;
	result[0] = false; //didnt find it
	result[1] = "null";
	result[2] = "null";
	
	console.log("JSON Size: " + size);
	for (var x = 0; x < size; x++) {
		var tp = obj.zipcodes[x];
		if(tp.zip == desiredZip) {
			result[0] = true; //found it
			result[1] = tp.city;
			result[2] = tp.state;
			console.log("Found Index: " + x + "  , City: " + tp.city + " , State: " + tp.state);
		}
	}
	return result;
	
}

function zipSearcher() {
	var zip = document.getElementById("zip").value;
	
	if (zipChecker(zip)) {
		//its 5 digits, its valid
		console.log("The zip code Pulled: " + zip);
		ajaxResult(zip);
	} else {
		//alert("Error, zip code should only be 5 digits long.");
		document.getElementById("zip_error_field").innerHTML = "Error, invalid zip.";
	}

}


//validates the zipcode before dispatching a ajax
//call
function zipChecker(f) {
	var Pattern = /^\d{5}$/;
	return Pattern.test(f);
}

function registerZipHandler() {
	var field = document.getElementById("zip");
	field.onblur = zipSearcher;
}