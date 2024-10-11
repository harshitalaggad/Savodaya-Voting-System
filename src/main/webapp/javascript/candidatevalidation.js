
       //validations for candidates
const cform = document.getElementById("cform");
const year = document.getElementById("year");
const image = document.getElementById("image");
const error = document.getElementById("error");


cform.addEventListener("submit", (e) => {


  //candidate 
	if (!(year[0].checked || year[1].checked)) {
		errorMessages.push("*Select a year");
	}
	if (validateimage(image) == false) {
		errorMessages.push("*Select a image");
	}

	if (errorMessages.length > 0) {


		error.innerText = errorMessages.join("\n");
		e.preventDefault();
	}

});





function validateimage(image) {
	var validexe = ["jpeg", "png", "jpg"];
	if (image.value != "") {
		var exe = image.value.lastIndexOf('.');
		var imgext = image.value.substring(exe);
		var result = validexe.includes(imgext);
		if (result == false) {
			errorMessages.push("*selected file is not an image");
			return false;
		}
		else {
			return true;
		}
	}
}