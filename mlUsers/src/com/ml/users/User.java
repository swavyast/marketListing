package com.ml.users;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "useMl")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mL_Id")
	private long userid;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email") 
	private String email;
	
	@Column(name="Phone")
	private String contact;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "addId")
	private Address address;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "myLoc") private Location loc;
	 */
	
	public User() {
		System.out.println("default constructor in User class");
	}

	public User(String username, String password, String name, String email, String contact,
			Address address) {
		System.out.println("Parameterised Constructor with Address in User class");
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public User(String username, String password, String name, String email, String contact) {
		System.out.println("Parameterised constructor in User class");
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.contact = contact;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", contact=" + contact + ", address=" + address + "]";
	}
}
