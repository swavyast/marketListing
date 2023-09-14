package com.ml.users;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "banks")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bank{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BankId")
	private int bankId;
	
	@ElementCollection
	@CollectionTable(name = "BankUsers")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name="BankId")
	@Column(name = "BnkUsers")
	private Set<User> users;
	
	@ElementCollection
	@CollectionTable(name = "BankAccounts") 
	//@JoinColumn(table = "BankAccounts", name="BankId")
	@Column(name = "Accounts")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Account> account;
	
	@Column(name = "BankName")
	private String bankName;
	
	@Column(name = "BranchName")
	private String branch;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "brLoc") private Location branchLoc;
	 */
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "brAd")
	private Address branchAddress;
	
	public Bank() {
		System.out.println("Default constructor in Bank class");
	}

	public Bank(Set<User> users, Set<Account> account, String bankName, String branch, Address branchAddress) {
		super();
		this.users = users;
		this.account = account;
		this.bankName = bankName;
		this.branch = branch;
		this.branchAddress = branchAddress;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", users=" + users + ", account=" + account + ", name=" + bankName + ", branch="
				+ branch + ", branchAddress=" + branchAddress + "]";
	}
}
