package com.meriame.modal;

public class LoginForm {
	String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password;
	public LoginForm(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
