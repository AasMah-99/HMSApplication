package com.hsmapplication.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue
	private Long doctorId;
	private String email;
	private String password;
	private String name;
	private String specialization;
	private String gender;
	private String about;
	private String experience;
	private Double fee;
	private Boolean isASpecialist;
	private Date dob;
	private Boolean status;

	public Doctor() {
	}

	public Doctor(String email, String password, String name, String specialization, String gender, String about,
			String experience, Double fee, Boolean isASpecialist, Date dob, Boolean status) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.specialization = specialization;
		this.gender = gender;
		this.about = about;
		this.experience = experience;
		this.fee = fee;
		this.isASpecialist = isASpecialist;
		this.dob = dob;
		this.status = status;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Boolean getIsASpecialist() {
		return isASpecialist;
	}

	public void setIsASpecialist(Boolean isASpecialist) {
		this.isASpecialist = isASpecialist;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", specialization=" + specialization + ", gender=" + gender + ", about=" + about + ", experience="
				+ experience + ", fee=" + fee + ", isASpecialist=" + isASpecialist + ", dob=" + dob + ", status="
				+ status + "]";
	}

}
