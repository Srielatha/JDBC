package com.main;

import com.database.ManytoMany;
import com.database.OnetoMany;
import com.database.OnetoOne;

public class Update {

	public static void main(String[] args) {

		OnetoOne.updateStudent();
		OnetoOne.updateAddress(14, "valley");

		OnetoMany.updateAuthor("sri", 23);
		OnetoMany.updateCourses(34, "android");

		ManytoMany.updateClasses("gfy", 5);
		ManytoMany.updateProfessor("hjf", 5);

	}
}
