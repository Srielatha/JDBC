package com.main;

import com.database.ManytoMany;
import com.database.OnetoMany;
import com.database.OnetoOne;
import com.jdbc.Address;
import com.jdbc.Author;
import com.jdbc.Professor;
import com.jdbc.Student;
import com.jdbc.Courses;
import com.jdbc.Classes;

public class Insert {

	public static void main(String[] args) {

		OnetoOne.insertStudent(new Student(15, "fh", "dec-21-2015", "male"));
		OnetoOne.insertAddress(15, new Address(5, "g", "h", "i", "j", "5545", 15));

		OnetoMany.insertAuthor(new Author("hjgj", "hgfjh"));
		OnetoMany.insertCourses(24, new Courses(36, "ghv", 24));

		ManytoMany.insertProfessor(new Professor(5, "Adward", "General"));
		ManytoMany.insertClasses(new Classes(2, "vb", 23));

	}

}
