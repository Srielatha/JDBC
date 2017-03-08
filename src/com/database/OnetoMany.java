package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.Author;
import com.jdbc.Courses;

public class OnetoMany {

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srilatha", "root", "root");
		return con;
	}

	public static List<Author> getAuthorData() {
		List<Author> author = new ArrayList<>();
		try (Connection con = getConnection();) {
			String query = "SELECT * FROM author a INNER JOIN courses c ON a.authorid = c.authorid";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Author auth = null;
			while (rs.next()) {
				if (auth == null || auth.getAuthorId() != rs.getInt("authorid")) {
					auth = new Author();
					setAuthor(rs, author, auth);
				}
				auth.getCourses()
						.add(new Courses(rs.getInt("courseid"), rs.getString("coursename"), rs.getInt("authorid")));
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;

	}

	private static void setAuthor(ResultSet rs, List<Author> author, Author auth) throws SQLException {
		List<Courses> courses = new ArrayList<>();
		auth.setCourses(courses);

		auth.setAuthorId(rs.getInt("authorid"));
		auth.setFirstName(rs.getString("firstName"));
		auth.setLastName(rs.getString("lastName"));
		author.add(auth);
	}

	public static void insertAuthor(Author auth) {

		try (Connection con = getConnection();) {
			String query = "INSERT INTO author(firstName,LastName) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, auth.getFirstName());
			pstmt.setString(2, auth.getLastName());
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Author Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertCourses(int corseId, Courses c) {

		try (Connection con = getConnection();) {
			String query = "INSERT INTO courses(courseId,courseName,authorid) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, c.getCourseId());
			pstmt.setString(2, c.getCourseName());
			pstmt.setInt(3, c.getAuthorId());
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Courses Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateAuthor(String firstName, int authorId) {

		try (Connection con = getConnection();) {
			String query = "UPDATE Author SET firstName=? WHERE authorid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, firstName);
			pstmt.setInt(2, authorId);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Author Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateCourses(int courseId, String courseName) {

		try (Connection con = getConnection();) {
			String query = "UPDATE courses SET courseName=? WHERE courseid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, courseName);
			pstmt.setInt(2, courseId);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Courses Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteAuthorAndCourses(int authorId) {

		try (Connection con = getConnection();) {
			String coursesDelete = "DELETE FROM courses  WHERE authorid=?";
			PreparedStatement pstmt1 = con.prepareStatement(coursesDelete);
			pstmt1.setInt(1, authorId);
			pstmt1.executeUpdate();
			String query = "DELETE FROM author  WHERE authorid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, authorId);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Author Record Deleted successfully with respective Courses");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
