package com.ml.users;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@PrimaryKeyJoinColumn(name = "AccNo")
public class Account extends Bank {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AcID")
	private long acId;
	
	@Column(name = "AcNo")
	private long acNo;
	
	@Column(name = "Balance")
	private double bal;
	
	@Column(name = "Credit")
	private double credit;
	
	@Column(name = "Debit")
	private double debit;
	
	@Column(name = "Remarks")
	private String remarks;
	
	public Account() {}


	public Set<Account> getAccount(Vendor v) {
		return v.getAcNo();
	}


	public Account(long acId, long acNo, double bal, double credit, double debit, String remarks) {
		super();
		this.acId = acId;
		this.acNo = acNo;
		this.bal = bal;
		this.credit = credit;
		this.debit = debit;
		this.remarks = remarks;
	}


	public long getAcId() {
		return acId;
	}


	public void setAcId(long acId) {
		this.acId = acId;
	}


	public long getAcNo() {
		return acNo;
	}


	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}


	public double getBal() {
		return bal;
	}


	public void setBal(double bal) {
		this.bal = bal;
	}


	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}


	public double getDebit() {
		return debit;
	}


	public void setDebit(double debit) {
		this.debit = debit;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "Account [acId=" + acId + ", acNo=" + acNo + ", bal=" + bal + ", credit=" + credit + ", debit=" + debit
				+ ", remarks=" + remarks + "]";
	}
}
