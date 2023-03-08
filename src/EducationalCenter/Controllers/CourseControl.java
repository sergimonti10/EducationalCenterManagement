package EducationalCenter.Controllers;

import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import EducationalCenter.Models.Course;

public class CourseControl {

	private static Connection conn = null;

	/**
	 * 
	 * @return
	 */
	public Course loadFirstRecord() {
		Course course = null;

		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");

			if (rs.next()) {
				course = new Course();
				course.setId(rs.getInt(1));
				course.setDescription(rs.getString(2));
			}

			st.close();
			rs.close();
			return course;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Course loadLastRecord() {
		Course course = null;

		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.curso);");

			if (rs.next()) {
				course = new Course();
				course.setId(rs.getInt(1));
				course.setDescription(rs.getString(2));
			}

			st.close();
			rs.close();
			return course;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Course loadPreviusRecord(Course c) {
		Course course = null;

		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso\r\n" + "WHERE id < " + c.getId()
					+ "\r\n" + "ORDER BY id DESC\r\n" + "LIMIT 1;");

			if (rs.next()) {
				course = new Course();
				course.setId(rs.getInt(1));
				course.setDescription(rs.getString(2));
			}

			st.close();
			rs.close();
			return course;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Course loadNextRecord(Course c) {
		Course course = null;

		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso\r\n" + "WHERE id > " + c.getId()
					+ "\r\n" + "ORDER BY id ASC\r\n" + "LIMIT 1;");

			if (rs.next()) {
				course = new Course();
				course.setId(rs.getInt(1));
				course.setDescription(rs.getString(2));
			}

			st.close();
			rs.close();
			return course;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 *
	 */
	public static int deleteCourse(Course c) {
		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			int affected = st.executeUpdate("delete from curso where id=" + c.getId());

			st.close();
			return affected;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int saveCourse(Course c) {
		int affected;

		try {
			conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();

			try {
				affected = st.executeUpdate("INSERT INTO centroeducativo.curso (id, descripcion)" + "VALUES ("
						+ c.getId() + ",'" + c.getDescription() + "');");

			} catch (SQLIntegrityConstraintViolationException e) {
				affected = st.executeUpdate("UPDATE centroeducativo.curso " + "SET descripcion = '" + c.getDescription()
						+ "' " + "WHERE id = " + c.getId() + " ;");
			}

			st.close();
			return affected;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
