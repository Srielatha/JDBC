package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.jdbc.Address;
import com.jdbc.Student;

public class SavepointDemo {

	static Connection con = null;

	public static Connection getConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srilatha", "root", "root");
		return con;
	}

	public static void insertStudentAddress(Student std, int stdid, Address add) {
		Savepoint savePoint = null;
		try {
			Connection con = getConnection();
			String query1 = "INSERT INTO student(name,dateofjoining,gender) VALUES (?,?,?)";
			String query2 = "INSERT INTO address(street,city,state,country,zipcode,empid) VALUES (?,?,?,?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setString(1, std.getName());
			pstmt.setString(2, std.getDateOfJoing());
			pstmt.setString(3, std.getGender());
			int noOfRows = pstmt.executeUpdate();
			savePoint = con.setSavepoint("Student Record inserted successfully- savepoint");
			if (noOfRows != 0)
				System.out.println("Student Record inserted successfully");

			PreparedStatement pstmt1 = con.prepareStatement(query2);
			pstmt1.setInt(1, add.address_id);
			pstmt1.setString(2, add.getStreet());
			pstmt1.setString(3, add.getCity());
			pstmt1.setString(4, add.getState());
			pstmt1.setString(5, add.getCountry());
			pstmt1.setString(6, add.getZipCode());
			pstmt1.setInt(7, stdid);
			noOfRows = pstmt1.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Address Record inserted successfully");
			con.commit();
		}

		catch (SQLException e) {
			try {
				if (savePoint == null) {
					con.rollback();
					System.out.println("transaction rolled back successfully, failure occured in student insertion");
				} else {
					con.rollback(savePoint);
					System.out.println("Rolled back to the save point and student record inserted succusfully");
					con.commit();
				}
				con.close();
			} catch (SQLException e1) {
				e1.getMessage();
				e1.getErrorCode();
			}
			e.getMessage();
			e.getErrorCode();
		}

	}

}
