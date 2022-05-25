package com.hsmapplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receptionist")
public class Receptionist {

	@Id
	@GeneratedValue
	private Long receptionistId;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private String gender;

	public Receptionist() {
	}

	public Receptionist(Long receptionistId, String name, String email, String password, Date dob, String gender) {
		this.receptionistId = receptionistId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}

	public Long getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Long receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Receptionist [receptionistId=" + receptionistId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", dob=" + dob + ", gender=" + gender + "]";
	}

}
