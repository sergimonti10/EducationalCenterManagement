package EducationalCenter.Models;

public class Teacher {
	
	private int id;
	private String name;
	private String surname1;
	private String surname2;
	private int dni;
	private String address;
	private String email;
	private String phone;
	/**
	 * @param id
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param dni
	 * @param address
	 * @param email
	 * @param phone
	 */
	public Teacher(int id, String name, String surname1, String surname2, int dni, String address, String email,
			String phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.address = address;
		this.email = email;
		this.phone = phone;
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
	public String getSurname1() {
		return surname1;
	}
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	public String getSurname2() {
		return surname2;
	}
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2 + ", dni="
				+ dni + ", address=" + address + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
