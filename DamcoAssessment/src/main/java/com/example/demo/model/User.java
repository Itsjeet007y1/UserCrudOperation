package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * User Document or entity
 */
@Document("user") // This annotation is mandatory in case of mongodb, we can change the document
					// name inside that
public class User {

	@Id // It shows the id field of the document or entity
	@NotNull // This annotation validates for non null values
	@NotEmpty // This annotation validates for empty data
	@NotBlank // This validation validates for blank data
	private String userId;

	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String sirName;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // This validation check the proper data format given inside pattern
											// attribute
	private Date dob;
	@NotNull
	@NotEmpty
	private String title;

	// Parameterized constructor
	public User(String userId, String firstName, String sirName, Date dob, String title) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.sirName = sirName;
		this.dob = dob;
		this.title = title;
	}

	// Setters and Getters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSirName() {
		return sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// toString method to debug and test the data
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", sirName=");
		builder.append(sirName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}

}
