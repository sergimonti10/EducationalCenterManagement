package EducationalCenter.Models;

public class AverageRating {
	
	private int id;
	private int idTeacher;
	private int idStudent;
	private int idSubject;
	private float average;
	/**
	 * @param id
	 * @param idTeacher
	 * @param idStudent
	 * @param idSubject
	 * @param average
	 */
	public AverageRating(int id, int idTeacher, int idStudent, int idSubject, float average) {
		super();
		this.id = id;
		this.idTeacher = idTeacher;
		this.idStudent = idStudent;
		this.idSubject = idSubject;
		this.average = average;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public int getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	
	@Override
	public String toString() {
		return "AverageRating [id=" + id + ", idTeacher=" + idTeacher + ", idStudent=" + idStudent + ", idSubject="
				+ idSubject + ", average=" + average + "]";
	}
	
	

}
