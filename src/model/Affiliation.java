package model;

import java.io.Serializable;

public class Affiliation implements Serializable {
	private int affiliationID;
	private String accountID;
	private String groupID;
	private String role;//0:申請 1:メンバー 2:副代表 3:代表
	private boolean isMain;

	public Affiliation() {
		affiliationID = 0;
		accountID = "";
		groupID = "";
		role = "";
		isMain = false;
	}

	public int getAffiliationID() {
		return affiliationID;
	}

	public void setAffiliationID(int affiliationID) {
		this.affiliationID = affiliationID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getIsMain() {
		return isMain;
	}

	public void setIsMain(boolean isMain) {
		this.isMain = isMain;
	}

}
