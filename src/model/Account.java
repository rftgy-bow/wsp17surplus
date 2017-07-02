package model;

import java.io.Serializable;

public class Account implements Serializable {
	private String accountID;
	private String pass;
	private String userName;

	public Account() {
		accountID = "";
		pass = "";
		userName = "";
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
