package model;

import java.io.Serializable;

public class Member implements Serializable {
	private String name;
	private String pass;

	public Member() {
		name = "";
		pass = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
