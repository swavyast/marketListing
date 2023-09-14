package com.ml.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressId") // name attribute specifies here the name of the column to be create under address table
	private long addrId;
	
	//@OneToMany(mappedBy = "address")
	//private static List<User> users;
	
	@Column(name="HouseNumber")
	private String houseNumber;
	
	@Column(name = "PostOffice")
	private String postOffice;
	
	@Column(name = "Locality")
	private String locality;
	
	@Column(name = "Pincode")
	private int pincode;
	
	@Column(name = "Zipcode")
	private int zipcode;
	
	@Column(name = "PoliceStation")
	private String policeStation;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Country")
	private String country;
	
	@OneToOne(mappedBy = "address")
	User user;
	
	@OneToOne(mappedBy = "branchAddress")
	Bank bank;

	public Address() {
		System.out.println("Default Constructor in Address class");
	}

	public Address(String houseNumber, String postOffice, String locality, int pincode, int zipcode,
			String policeStation, String city, String state, String country) {
		super();
		this.houseNumber = houseNumber;
		this.postOffice = postOffice;
		this.locality = locality;
		this.pincode = pincode;
		this.zipcode = zipcode;
		this.policeStation = policeStation;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", houseNumber=" + houseNumber + ", postOffice=" + postOffice
				+ ", locality=" + locality + ", pincode=" + pincode + ", zipcode=" + zipcode + "]";
	}
}