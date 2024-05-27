package br.com.nova.erudio.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstname;
	private String lastname;
	private String address;
	private String gender;
	private Date birthday;


	public PersonVOV2() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthday, firstname, gender, id, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVOV2 other = (PersonVOV2) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
