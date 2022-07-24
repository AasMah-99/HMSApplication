document.addEventListener('DOMContentLoaded', () => {
	const doctor = JSON.parse(localStorage.getItem('doctor'));

	fetch("http://localhost:8080/appointment/doctorId/" + doctor.doctorId, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(res => res.json())
		.then(data => {
			if (data.status) {

				var docTotalApp = document.getElementById("docTotalApp");
				var docScheduleApp = document.getElementById("docScheduleApp");
				var docPendingApp = document.getElementById("docPendingApp");

				docTotalApp ? docTotalApp.innerHTML = parseInt(data.data.length) : null;

				docScheduleApp ? docScheduleApp.innerHTML = parseInt(data.data.filter(app => app.status === "Confirmed").length) : null;
				docPendingApp ? docPendingApp.innerHTML = parseInt(data.data.filter(app => app.status === "Pending").length) : null;


				var docPatName = document.getElementById("docPatName");
				var docPatGender = document.getElementById("docPatGender");
				var docPatStatus = document.getElementById("docPatStatus");
				var docPatFee = document.getElementById("docPatFee");

				var patName = document.getElementById("patName");
				var patGender = document.getElementById("patGender");
				var appStatus = document.getElementById("appStatus");
				var appDate = document.getElementById("appDate");

				data.data.forEach(element => {

					if (patName) {
						var nameLi = document.createElement("li");
						nameLi.innerHTML = element.patientName;
						patName.appendChild(nameLi);


						var genderLi = document.createElement("li");
						genderLi.innerHTML = element.patientGender;
						patGender.appendChild(genderLi);


						var statusLi = document.createElement("li");
						statusLi.innerHTML = element.status;
						appStatus.appendChild(statusLi);


						var dateLi = document.createElement("li");
						dateLi.innerHTML = element.appointmentTime;
						appDate.appendChild(dateLi);
					}
				});

				data.data.forEach(element => {


					if (docPatName) {
						var docPatNameLi = document.createElement("li");
						docPatNameLi.innerHTML = element.patientName;
						docPatName.appendChild(docPatNameLi);


						var docPatGenderLi = document.createElement("li");
						docPatGenderLi.innerHTML = element.patientGender;
						docPatGender.appendChild(docPatGenderLi);


						var docPatStatusLi = document.createElement("li");
						docPatStatusLi.innerHTML = element.status;
						docPatStatus.appendChild(docPatStatusLi);


						var docPatDateLi = document.createElement("li");
						docPatDateLi.innerHTML = element.appointmentTime;
						docPatFee.appendChild(docPatDateLi);
					}
				});


			}
		})
});