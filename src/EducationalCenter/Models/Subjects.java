package EducationalCenter.Models;

public class Subjects {
	
	private int id;
	private String name;
	private String acronym;
	private int course_id;
	/**
	 * @param id
	 * @param name
	 * @param acronym
	 * @param course_id
	 */
	public Subjects(int id, String name, String acronym, int course_id) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.course_id = course_id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", acronym=" + acronym + ", course_id=" + course_id + "]";
	}
	
	
	
}
