package com.jdbc;

import java.util.List;

public class Classes {

	private int classId;
	private String coursename;
	private int numofstudents;
	private List<Professor> Professor;

	public Classes(int classId, String coursename, int numofstudents, List<Professor> professor) {
		super();
		this.classId = classId;
		this.coursename = coursename;
		this.numofstudents = numofstudents;

	}

	public Classes(int classid, String coursename, int numofstudents) {
		super();
		this.classId = classid;
		this.coursename = coursename;
		this.numofstudents = numofstudents;

	}

	public Classes() {

	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getNumofstudents() {
		return numofstudents;
	}

	public void setNumofstudents(int numofstudents) {
		this.numofstudents = numofstudents;
	}

	public List<Professor> getProfessor() {
		return Professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.Professor = professor;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", coursename=" + coursename + ",  numofstudents=" + numofstudents
				+ ", professor=" + Professor + "]";
	}

}
