package com.jdbc;

import java.util.List;

public class Author {
	private int authorId;
	private String firstName;
	private String LastName;
	private List<Courses> Courses;

	public Author(String firstName, String LastName) {
		super();
		this.firstName = firstName;
		this.LastName = LastName;
	}

	public Author() {

	}

	public List<Courses> getCourses() {
		return Courses;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", LastName=" + LastName + ", Courses="
				+ Courses + "]";
	}

	public void setCourses(List<Courses> courses2) {

	}

}