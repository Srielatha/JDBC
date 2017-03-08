package com.main;

import com.database.ManytoMany;
import com.database.OnetoMany;
import com.database.OnetoOne;

public class Delete {

	public static void main(String[] args) {
		OnetoOne.deleteStudentAndAddress(12);
		OnetoMany.deleteAuthorAndCourses(23);
		ManytoMany.deleteClasses(6);
		ManytoMany.deleteProfessor(2);
	}

}
