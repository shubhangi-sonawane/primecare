package com.primecare.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	private Long id;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String username;
	private String password;
	private String doctorlogin;
	private String adminlogin;
	
	public User(Long id, String username, String password, String doctorlogin, String adminlogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.doctorlogin = doctorlogin;
		this.adminlogin = adminlogin;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorlogin() {
		return doctorlogin;
	}

	public void setDoctorlogin(String doctorlogin) {
		this.doctorlogin = doctorlogin;
	}

	public String getAdminlogin() {      
		return adminlogin;
	}

	public void setAdminlogin(String adminlogin) {
		this.adminlogin = adminlogin;
	}
	
	
	
	
	
	

}
