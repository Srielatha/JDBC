package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.Professor;
import com.jdbc.Classes;

public class ManytoMany {

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srilatha", "root", "root");
		return con;
	}

	public static List<Classes> getClasses() {
		List<Classes> classes = new ArrayList<>();
		try (Connection con = getConnection();) {
			String query = "SELECT * FROM classprofessor JOIN class ON class.classid = classprofessor.classid JOIN professor ON professor.professorid = classprofessor.professorid";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Classes c = null;
			while (rs.next()) {
				if (c == null || c.getClassId() != rs.getInt("classid")) {
					c = new Classes();
					setClasses(c, classes, rs);
				}
				c.getProfessor().add(new Professor(rs.getInt("professorid"), rs.getString("name"),
						rs.getString("department"), classes));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classes;
	}

	public static void setClasses(Classes c, List<Classes> classes, ResultSet rs) {
		List<Professor> professor = new ArrayList<>();
		c.setProfessor(professor);
		try (Connection con = getConnection();) {
			c.setClassId(rs.getInt("classid"));
			c.setCoursename(rs.getString("coursename"));
			c.setNumofstudents(rs.getInt("numofstudents"));
			classes.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertProfessor(Professor p) {

		try (Connection con = getConnection();) {
			String query = "INSERT INTO professor(professorid,name,department) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p.getProfessorId());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getDepartment());
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Professor Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertClasses(Classes c) {
		try (Connection con = getConnection();) {
			String query = "INSERT INTO classes(classid,coursename,numofstudents) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, c.getClassId());
			pstmt.setString(2, c.getCoursename());
			pstmt.setInt(3, c.getNumofstudents());
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Classes Record inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateClasses(String coursename, int classid) {

		try (Connection con = getConnection();) {
			String query = "UPDATE classes SET coursename=? WHERE classid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, coursename);
			pstmt.setInt(2, classid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Classes Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateProfessor(String name, int professorid) {

		try (Connection con = getConnection();) {
			String query = "UPDATE professor SET name=? WHERE professorid=?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, professorid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("professor Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteClasses(int classid) {

		try (Connection con = getConnection();) {
			String junctionDelete = "DELETE FROM classprofessor  WHERE classid=?";
			PreparedStatement pstmt1 = con.prepareStatement(junctionDelete);
			pstmt1.setInt(1, classid);
			pstmt1.executeUpdate();
			String query = "DELETE FROM classes  WHERE classid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, classid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Classes Record Deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteProfessor(int professorid) {

		try (Connection con = getConnection();) {
			String junctionDelete = "DELETE FROM classprofessor  WHERE professorid=?";
			PreparedStatement pstmt1 = con.prepareStatement(junctionDelete);
			pstmt1.setInt(1, professorid);
			pstmt1.executeUpdate();
			String query = "DELETE FROM professor  WHERE professorid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, professorid);
			int noOfRows = pstmt.executeUpdate();
			if (noOfRows != 0)
				System.out.println("Professor Record Deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
