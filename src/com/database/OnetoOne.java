package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.Address;
import com.jdbc.Student;

public class OnetoOne {

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srilatha", "root", "root");
		return con;
	}

	public static List<Student> getStudent() {
		List<Student> student = new ArrayList<>();
		try (Connection con = getConnection();) {
			String query = "SELECT * FROM student s INNER JOIN address a ON s.stdid = a.stdid";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Address a = new Address(rs.getInt("address_id"), rs.getString("street"), rs.getString("city"),
						rs.getString("state"), rs.getString("country"), rs.getString("zipcode"), 115);
				Student std = new Student();
				std.setStdId(rs.getInt("stdid"));
				std.setName(rs.getString("name"));
				std.setGender(rs.getString("gender"));
				std.setDateOfJoing(rs.getString("dateofjoing"));

				std.setAddress(a);
				student.add(std);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public static void insertStudent(Student std) {

		try (Connection con = getConnection();) {
			String query = "INSERT INTO Student(name,gender,dateofjoing) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, std.getName());
			pstmt.setString(2, std.getDateOfJoing());
			pstmt.setString(3, std.getGender());
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Student Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertAddress(int id, Address add) {

		try (Connection con = getConnection();) {
			String query = "INSERT INTO address(address_id,street,city,state,country,zipcode,stdid) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, add.getAddress_id());
			pstmt.setString(2, add.getStreet());

			pstmt.setString(3, add.getCity());
			pstmt.setString(4, add.getState());
			pstmt.setString(5, add.getCountry());
			pstmt.setString(6, add.getZipCode());
			pstmt.setInt(7, id);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Address Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateStudent() {

		try (Connection con = getConnection();) {
			String query = "UPDATE student SET name=? WHERE stdid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "suha");
			pstmt.setInt(2, 13);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Student Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateAddress(int stdid, String street) {

		try (Connection con = getConnection();) {
			String query = "UPDATE address SET street=? WHERE stdid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, street);
			pstmt.setInt(2, stdid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Address Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteStudentAndAddress(int stdid) {

		try (Connection con = getConnection();) {
			String addressDelete = "DELETE FROM address  WHERE stdid=?";
			PreparedStatement pstmt1 = con.prepareStatement(addressDelete);
			pstmt1.setInt(1, stdid);
			pstmt1.executeUpdate();
			String query = "DELETE FROM student  WHERE stdid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stdid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Student Record Deleted successfully with respective address");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
