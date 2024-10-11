const form = document.getElementById("form");
const FirstName = document.getElementById("firstname");
const LastName = document.getElementById("lastname");

const Gender = document.getElementsByName("gender");

const Branch = document.getElementById("branch");
const Year = document.getElementsByName("year");
const RollNumber = document.getElementById("rollno");
const Password = document.getElementById("password");
const AdminId = document.getElementById("AdminId");
const AdminPassword = document.getElementById("AdminPassword");



const error = document.getElementById("error");


form.addEventListener("submit", (e) => {

	let errorMessages = [];
    

	if (!(Branch.value == "Bsc(cs)" || Branch.value == "Bsc(honors)" || Branch.value == "Bsc(maths)" || Branch.value == "Bsc")) {
		errorMessages.push("*Write a correct branch");
	}

    if (!(Year[0].checked || Year[1].checked || Year[3].checked)) {
		errorMessages.push("*Select a year");
	}
	if (!(Gender[0].checked || Gender[1].checked)) {
		errorMessages.push("*Select a gender");
	}

	if (validateRollNumber(RollNumber) == false) {
		errorMessages.push("Wrong RollNumber format");
		
	if (validateForm() == false) {
		errorMessages.push("already exist");

	}
	if (Password.length > 12) {
		errorMessages.push("*password should be b/w 8-12 char");

	}
	if (Password.length < 8) {
		errorMessages.push("*password should be b/w 8-12 char");
	}


	if (errorMessages.length > 0) {


		error.innerText = errorMessages.join("\n");
		e.preventDefault();
	}
});

function validateRollNumber(RollNumber) {
	// Regex: 10 digits with no comma, spaces, punctuation and no + sign
	var Rollno = /^\d{8}$/; // Regex : Regular Expression

	if (RollNumber.value.match(Rollno)) {

		return true;
	} else {
		return false;
	}
} 
function validateForm() {
      var columnValues = []; // Array to store column values

      // Loop through each row in the table
      var table = document.getElementById('getColumnData');
      for (var i = 1; i < table.rows.length; i++) { // Assuming the first row is headers
        var cell = table.rows[i].cells[2]; // Change 2 to the column index you want to check

        var value = cell.querySelector('rollno').value; // Assuming your input is within each cell

        // Check for duplicates
        if (columnValues.includes(value)) {
          alert('Duplicate values are not allowed. Please enter different values.');
          return false; // Prevent form submission
        }

        columnValues.push(value);
      }

      // Additional validation logic can be added here

      return true; // Allow form submission
    }