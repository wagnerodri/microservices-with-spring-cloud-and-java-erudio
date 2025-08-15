package br.com.wagnerodri.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id ;
	private String fisrtName;
	private String lastName;
	private String address;
	private String gender;

	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLasttName() {
		return lastName;
	}

	public void setLasttName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, fisrtName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(fisrtName, other.fisrtName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
	
}
