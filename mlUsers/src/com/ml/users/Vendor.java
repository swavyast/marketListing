package com.ml.users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
@PrimaryKeyJoinColumn(name = "venId")
public class Vendor extends User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vendorID")
	private long vendorId;
	@Column(name="gstn")
	private String gstn;
	@Column(name="pan")
	private String pan; //pan can also be mapped with Location Class
	@Column(name="voterID")
	private String voterId;
	@Column(name="aadhaar")
	private long aadhaar;
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@Column()
	//private List<Location> region;
	//@Column(name="acNo")
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ActNo")
	private Set<Account> acNo;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="catId") Catalogue cat;
	 */
	
	public Vendor() {
		System.out.println("Default constructor in Vendor class");
	}

	public Vendor(String username, String password, String name, String email, String contact, Address address) {
		super(username, password, name, email, contact, address);
	}

	public Vendor(long vendorId, String gstn, String pan, String voterId, long aadhaar, Set<Account> acNo) {
		super();
		this.vendorId = vendorId;
		this.gstn = gstn;
		this.pan = pan;
		this.voterId = voterId;
		this.aadhaar = aadhaar;
		this.acNo = acNo;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getGstn() {
		return gstn;
	}

	public void setGstn(String gstn) {
		this.gstn = gstn;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(long aadhaar) {
		this.aadhaar = aadhaar;
	}

	public Set<Account> getAcNo() {
		return acNo;
	}

	public void setAcNo(Set<Account> acNo) {
		this.acNo = acNo;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", gstn=" + gstn + ", pan=" + pan + ", voterId=" + voterId
				+ ", aadhaar=" + aadhaar + ", region=" + "region" + ", acNo=" + acNo + "]";
	}
}
