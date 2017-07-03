package model;

import java.io.Serializable;

public class Account implements Serializable {
	private String accountID;
	private String name;
	private String groupID;
	private String pass;
	private String role;

	public Account() {
		accountID = "";
		name = "";
		groupID = "";
		pass = "";
		role = "";
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getname() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
