package com.myproject.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile_no")
	private String mobilenum;

	
	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	@Column(name="date")
	private Date date;

	
	
	

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public User() {
		
	}
	

	public User(long user_id, String firstName, String lastName, String password, String emailId, String mobilenum,
			String appointment, Date date) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.mobilenum = mobilenum;
		
		this.date = date;
	}

	public long getId() {
		return user_id;
	}
	public void setId(long id) {
		this.user_id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
}
