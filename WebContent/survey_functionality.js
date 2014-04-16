//Created By: Jack Young.   SWE642


//this function is used setup the default survey page.
function defaultSettings() {
	

	//hiding the error field for the Data textfield. 
	hideElement(document.getElementById("data_error_field"));
	
	
	//onload calling the cookie stuff.
	//displayCookieStuff();
	
	//onload register handler for Form Extension and Avg & Max Comp
	registerHandler();
	
	
	//registerFormValidationHandler();
	
	
	//register reset form action handler. 
	registerResetFormHandler();
	
	registerZipHandler();
	
}


// Start of Section for =  Cookie and Greeting Implementation

//This function is the control function for the cookie functionality.
//One page load, this function is called.  
function displayCookieStuff() {

		var name; //declaring a variable called userName.

		//determining if the a cookie exists
		if (document.cookie) {

			//converting escape characters from the cookie string.
			var myCookie = unescape(document.cookie);

			//splitting the cookie into individual tokens.  Using the equals sign as the delimiter.
			var cookieTokens = myCookie.split("=");

			//setting the userName to index 1 of the cookieTooken
			name = cookieTokens[1];

			//checking to see if the user had reset the cookie. 
			if (name == "setToNull") {

				//prompting the user to input their name.
				name = window.prompt("Enter in your name:");

				//adding the name to the cookie.
				document.cookie = "userNameXYZ=" + escape(name) + "; "+ "expires=Thu, 20 Dec 2014 12:00:00 GMT";
			}

		} else {

			//prompting the user to input their name.
			name = window.prompt("Enter in your name:");

			//adding the name to the cookie.
			document.cookie = "userNameXYZ=" + escape(name) + "; "+ "expires=Thu, 20 Dec 2014 12:00:00 GMT";
		}

		//Inserting the welcome message and reset link in the upper right hand corner of the page.

		var greetings = timeOfDay();
		document.getElementById('upperRight').innerHTML = "<p>" + greetings + " " + name + ", welcome to Assignment 3.</p>" + "<a href='javascript:wrongePerson()'>" + "Click here to reset</a>";

}

//cookieSetup()


// Assumptions made for the timing functionality
//
// Good Morning == 12am ||  < 12pm 
// Good Afternoon >= 12pm  and  < 6pm
// Good Evening >= 6pm and < 10pm
// Good night >= 10pm  and < 12am
function timeOfDay() {

	var currentDate = new Date(); //current date	
	var cd = currentDate.getHours();
	var o = "";
	if (cd == 24 || cd < 12) {
		o = "Good Morning";
	} else if (cd >= 12 && cd < 18) {
		o = "Good Afternoon";
	} else if (cd >= 18 && cd < 22) {
		o = "Good Evening";
	} else if (cd >= 22 && cd < 24) {
		o = "Good Night";
	}

	console.log("Time of Day function call -  Hours: " + currentDate.getHours() + "   string = " + o);
	return o;
}

//This function will reset the document's cookie if its the person and they click the reset
function wrongePerson() {
	//the cookie that will be reset
	document.cookie = "userNameXYZ=setToNull;";
	//after the cookie has been removed. This will reload the page. 
	location.reload();
}

// END of Section for =  Cookie and Greeting Implementation







// Start of Section for =  Survey Form Extension and Average & Max Comp

// This function is the handler for the Data text field.
// When the user tabs out of the field it validates the 
// field.  Checks to make sure there are 10 numbers
// seperated by commas, and those said numbers are in the
// range 1 to 100 inclusively.  If it does not meet those 
// conditions it displays an error message that indicates 
// the problem area.  Else, it computes the Average and 
// Maximum of the entered numbers, and display the results
// in their respective textfields.  
//Test case: {1,2,3,4,5,6,11,8,9,7}
// Average: 5.6   Maximum: 11
function dataHandler() {
	var inputS = document.getElementById("Data").value;
	var isError = false;
	var errorMessage = "";
	if (inputS == '') {
		isError = true;
		errorMessage = "Error, this cannot be a empty field.";
	} else {
		var tokens = inputS.split(",");
		if (tokens.length == 10) {
			if (areTokensNumbers(tokens)) {
				//Tokens are all numbers
				
				if (areInRange(tokens)) {
					//Numbers are all in range
					var avg = calculateAverage(tokens);
					var max = calculateMaximum(tokens);
					document.getElementById("Average").value = avg;
					document.getElementById("Maximum").value = max;
				} else {
					isError = true;
					errorMessage = "Error, The numbers must be between 1 and 100 inclusively.";
				}
			} else {
				isError = true;
				errorMessage = "Error, The inputs must all be numbers";
			}
		} else {
			isError = true;
			errorMessage = "Error, You need 10 values";
		}
	}
	
	if (isError) {
		//a error was found, so display message
		var eF = document.getElementById("data_error_field");
		showElement(eF);
		eF.innerHTML = errorMessage;
	} else {
		//no error was found, so hide error field if need be
		var eF = document.getElementById("data_error_field");
		eF.innerHTML = "All good";
		hideElement(eF);
	}
}

//function is used to hide an element on the page
function hideElement(el) {
	el.style.visibility = 'hidden';
	el.style.display = 'none';
}

//function is used to display element on page
function showElement(el) {
	el.style.visibility = 'visible';
	el.style.display = 'block';
}


//checking to see if the items in the token array are between 1 and 100 inclusive
function areInRange(tokens) {
	for (var x = 0; x < tokens.length; x++) {
		var temp = tokens[x];
		 if(temp < 1 || temp > 100){
			console.log("[" + x + "] = " + temp + " , not in the range");
			return false;
		}
	}
	return true;
}


//checking to see if the items in the token array are all numbers
function areTokensNumbers(tokens) {
	for (var x = 0; x < tokens.length; x++) {
		 if(isNaN(tokens[x])){
			return false;
		}
	}
	return true;
}


function registerHandler() {
	var field = document.getElementById("Data");
	field.onblur = dataHandler;
}

//This fucntion is used to calculate the average of the token array
function calculateAverage(tokens) {
	var sum = 0;
	for (var x = 0; x < tokens.length; x++) {
		 sum += parseInt(tokens[x]);
	}
	var avg = (sum / tokens.length);
	return avg;
}

//This function is used to find the max value in the token array
function calculateMaximum(tokens) {
	var tmp = parseInt(tokens[0]);
	for (var x = 0; x < tokens.length; x++) {
		if (tmp < parseInt(tokens[x])) {
			tmp = parseInt(tokens[x]);
		}
	}
	return tmp;
}

// END of Section for =  Survey Form Extension and Average & Max Comp









// START of Section for =  Form Validation Event Handling




function formValidation() {
	
	console.log("Form Validation Called");
	
	document.getElementById("errorBox").innerHTML = "";
	var ERROR_MESSAGES = new Array();

	if (!nameCheck()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, name should only be alphabetical characters and cannot be empty.";
	}
	
	if (!emailCheck()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, email is in a invalid format.";
	}
	
	if (!radioButtonCheck()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, a radio button option must be selected.";
	}
	
	if (!checkBoxesCheck()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, at least two checkboxes must be checked.";
	}
	
	if (!addressCheck()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, street address can only contain numbers and or alphabetical characters.";
		document.getElementById("streetAddress").value = "";	
	}
	
	if (!verifyUniqueStudentID()) {
		ERROR_MESSAGES[ERROR_MESSAGES.length] = "Error, The entered StudentID already exist. Please try again";
	}
	
	var go = false;
	
	if (ERROR_MESSAGES.length > 0) {
		var es = "<ul>";
		for (var x = 0; x < ERROR_MESSAGES.length; x++) {
			es += "<li>" + ERROR_MESSAGES[x] + "</li>";
		}
		es += "</ul>"
		document.getElementById("errorBox").innerHTML = es;
		
	} else {
		document.getElementById("errorBox").innerHTML = "";
		go = true;
	}

	
 // $(function() {
	if (!go) {
    $( "#dialog-modal" ).dialog({
      height: 300,
      width: 600,
      modal: true
    });
	}
  // });

    return go;
}


//Function is used to check the entered student ID agaisnt existing IDs,
//which are stored in a text file.  If it finds a match, returns false.
//if it doesnt find a match it returns true.  
function verifyUniqueStudentID() {
	//http://localhost:8080/AS4_JackYoung_SWE642/SurveyData_JackYoung.txt
	var enteredID = $("#studentID").val();
	var result = true;
    $.ajax({
        url: "http://localhost:8080/AS4_JackYoung_SWE642/SurveyData_JackYoung.txt",
        async: false,
        success: function (data){
           var lines = data.split('\n');
           console.log("Length: " + lines.length);
           if ( lines.length > 0 ) {
        	   for (var x = 0; x < lines.length; x++) {
        		   console.log(lines[x]);
        		   if ( enteredID == lines[x]) {
        			   console.log("Found a matching studentID");
        			   result = false;
        		   }
        	   }
           }
        }
    });
    return result;
}


// function is used to make sure at least two of the 
// checkboxes are checked.  If so return true, else
// return false.
function checkBoxesCheck() {
	var bb = document.getElementsByName("likeMost[]");
	var count = 0;
	for (var y = 0; y < bb.length; y++) {
		if (bb[y].checked) {
			count++;
		}
	}
	if (count >= 2) {
		return true;
	} else {
		return false;
	}
}

// function is used to check if a radio button has been
// selected or not.  returns a boolean result.  
function radioButtonCheck() {
	var result = false;
	var bb = document.getElementsByClassName("rad");
	for (var y = 0; y < bb.length; y++) {
		if (bb[y].checked) {
			result = true;
		}
	}
	return result;
}

//function is used to validate the email using regex
//Email must meet following criteria:
//- begin with a letter
// - have the @ symbol
// - have the period
function emailCheck() {
	var f = document.getElementById("email").value;
	var Pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;  
   return Pattern.test(f);
}

//Used to validate this: The name box should only contain Alphabets.
//It also checks to make sure that the field is not empty 
function nameCheck() {
	var f = document.getElementById("fullName").value;
	var regex = /^[a-zA-Z _]*$/;
	if (regex.test(f) && f != "") {
		return true;
	} else {
		return false;
	}
}

//Used to validate and make sure that the street address text
// field only contains letters and or numbers.
function addressCheck() {
	var f = document.getElementById("streetAddress").value;
	var Pattern = /^[0-9a-zA-Z _]+$/;
	return Pattern.test(f);
}


//this function will be used to reset the form
function resetForm() {
	alert("Reset Button was pressed, all form contents have been cleared.");
	//document.getElementById("survey_form").reset();
	//document.getElementById("json_city").innerHTML = "";
	//document.getElementById("json_state").innerHTML = "";
	$("#username").val("");
	$("#fullName").val("");
	$("#streetAddress").val("");
	$("#zip").val("");
	$("#state").val("");
	$("#city").val("");
	$("#telephoneNumber").val("");
	$("#email").val("");
	$("#url").val("");
	$("#surveyDate").val("");
	$("#gradMonth").val("");
	$("#GraduationYear").val("");
	$("#studentID").val("");
	$("#Data").val("");
	$("#comments").val("");
	$("#recommendToFriend").val("");
	
}

function registerResetFormHandler() {
	var field = document.getElementById("resetForm_button");
	field.onclick = resetForm;
}

//function registerFormValidationHandler() {
//	console.log("form validation handler registered");
//	var field = document.getElementById("f-submit");
//	field.onclick = formValidation;
//}

// START of Section for =  Form Validation Event Handling