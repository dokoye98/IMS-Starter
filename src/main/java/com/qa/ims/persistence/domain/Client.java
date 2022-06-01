package com.qa.ims.persistence.domain;

public class Client {

	private Long id;
	private String firstName;
	private String surname;
	private String username;
	private String password;
	private boolean DeluxeMember;

	//constructor with id

	public Client(Long id, String firstName, String surname, String username, String password, boolean deluxeMember) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.username = username;
		this.password = password;
		DeluxeMember = deluxeMember;
	}
//constructor without id
	public Client(String firstName, String surname, String username, String password, boolean deluxeMember) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.username = username;
		this.password = password;
		DeluxeMember = deluxeMember;
	}
	//toSTRING
	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", username=" + username
				+ ", password=" + password + ", DeluxeMember=" + DeluxeMember + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (DeluxeMember ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (DeluxeMember != other.DeluxeMember)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDeluxeMember() {
		return DeluxeMember;
	}
	public void setDeluxeMember(boolean deluxeMember) {
		DeluxeMember = deluxeMember;
	}


	

	



	

	

	
	}


