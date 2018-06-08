function submitEmployeeForm() {
	// getting the employee form values
	var name = $('#name').val().trim();
	var age = $('#age').val();
	var salary = $('#salary').val();
	if (name.length == 0) {
		alert('Please enter name');
		$('#name').focus();
		return false;
	}

	if (age <= 0) {
		alert('Please enter proper age');
		$('#age').focus();
		return false;
	}

	if (salary <= 0) {
		alert('Please enter proper salary');
		$('#salary').focus();
		return false;
	}
	return true;
};