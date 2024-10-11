package com.pojo;

//here we will store the entities if admin
public class Admin {
	private String AdminId;
	private String AdminPassword;

	public Admin() {
		super();

	}

	public Admin(String adminId, String adminPassword) {
		super();
		AdminId = adminId;
		AdminPassword = adminPassword;
		

	}

	public String getAdminId() {
		return AdminId;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
}