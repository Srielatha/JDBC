package com.jdbc;

import java.util.List;

public class Professor {
	private int professorId;
	private String name;
	private String department;
	private List<Classes> classes;

	public Professor(int professorId, String name, String department) {
		super();
		this.professorId = professorId;
		this.name = name;
		this.department = department;
	}

	public Professor(int professorId, String name, String department, List<Classes> classes) {
		super();
		this.professorId = professorId;
		this.name = name;
		this.department = department;
		this.classes = classes;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", name=" + name + ", department=" + department + "]";
	}

}
