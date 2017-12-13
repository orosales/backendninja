package com.udemy.backendninja.model;

public class ContactModel {

	private int id;
	private String firstname;
	private String lastname;
	private String city;
	private String telephone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public ContactModel(int id, String firstname, String lastname, String city, String telephone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.telephone = telephone;
	}

	public ContactModel() {

	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city
				+ ", telephone=" + telephone + "]";
	}
	
	
}
