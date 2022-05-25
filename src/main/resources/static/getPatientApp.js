/*const baseUrl = "https://pass-dev.herokuapp.com/";*/
const baseUrl = "http://localhost:8080/";

document.addEventListener('DOMContentLoaded', function() {
	var appointmentsTable = document.getElementById("appointmentsTable");

	var recentAppointmentsTable = document.getElementById("patientRecentAppointments");

	var patient = JSON.parse(localStorage.getItem("patient"));
	var patientId = patient.userId;

	fetch(baseUrl + "patient/appointments/" + patientId, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(function(response) {
		return response.json();
	}).then((res) => {
		if (res.status) {
			if (appointmentsTable) {
				for (var i = 0; i < res.data.length; i++) {
					var row = appointmentsTable.insertRow(i + 1);
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					var cell6 = row.insertCell(5);

					cell1.innerHTML = res.data[i].appointmentId;
					cell2.innerHTML = res.data[i].doctor.name;
					cell3.innerHTML = res.data[i].doctor.specialization;
					cell4.innerHTML = res.data[i].appointmentTime.toString();
					cell5.innerHTML = res.data[i].patientName;
					cell6.innerHTML = res.data[i].status;
				}
			}


			if (recentAppointmentsTable) {
				document.getElementById("totalAppBooked").innerHTML = res.data.length;
				for (var i = 0; i < res.data.length; i++) {

					var row = recentAppointmentsTable.insertRow(i + 1);
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					var cell6 = row.insertCell(5);

					cell1.innerHTML = res.data[i].appointmentId;
					cell2.innerHTML = res.data[i].doctor.name;
					cell3.innerHTML = res.data[i].doctor.specialization;
					cell4.innerHTML = res.data[i].appointmentTime.toString();
					cell5.innerHTML = res.data[i].patientName;
					cell6.innerHTML = res.data[i].status;
				}
			}

		}
	});


	// fetch(baseUrl + "patient/getRecentAppointments/" + patientId).then(res => res.json()).then(data => {
	// 	if (data.status) {
	// 		console.log("getRecentAppointments : ", data.data);
	// 	}
	// });
});