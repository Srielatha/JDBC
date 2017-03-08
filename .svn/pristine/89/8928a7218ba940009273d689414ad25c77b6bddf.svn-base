package com.jdbc;

public class Student {

	private int stdId;
	private String name;
	private String gender;
	private String dateOfJoing;
	private Address address;

	public Student() {

	}

	public Student(int stdid, String name, String gender, String dateOfJoing) {
		super();
		this.stdId = stdid;
		this.name = name;
		this.gender = gender;
		this.dateOfJoing = dateOfJoing;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(String dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", name=" + name + ", gender=" + gender + ", dateOfJoing=" + dateOfJoing
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stdId != other.stdId)
			return false;
		return true;
	}

}
