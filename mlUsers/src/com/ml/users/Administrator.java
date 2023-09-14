package com.ml.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "admId")
public class Administrator extends User{
	@Column(name = "dbId")
	private String dbId;
	@Column(name = "dbPwd")
	private String dbPwd;
	
	public Administrator() {
		System.out.println("Default Constructor in Administrator");
	}

	public Administrator(String dbId, String dbPwd) {
		super();
		this.dbId = dbId;
		this.dbPwd = dbPwd;
	}

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	@Override
	public String toString() {
		return "Administrator [dbId=" + dbId + ", dbPwd=" + dbPwd + "]";
	}
}
