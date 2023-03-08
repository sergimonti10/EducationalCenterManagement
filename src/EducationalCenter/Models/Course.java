package EducationalCenter.Models;

public class Course {
	
	private int id;
	private String description;
	
	/**
	 * 
	 */
	public Course() {
		super();
	}



	/**
	 * @param id
	 * @param description
	 */
	public Course(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + "]";
	}
	
	

}
