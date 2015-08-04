package me.jarad.bean;

import java.io.Serializable;

//import javax.inject.Named;
//import javax.enterprise.context.Dependent;
//import javax.enterprise.context.SessionScoped;

//@Named("UserData")
//@SessionScoped
public class UserLoginData implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	public String  passwordData;
	public boolean sessionData;
	public String  loginData;
	
	public UserLoginData() {
		// TODO Auto-generated constructor stub
	}


	
	public String toString() {
		return "" + getLoginData() + "\\" + getPasswordData() + "\\" + sessionData; 
	}



	public boolean isSessionData() {
		return sessionData;
	}



	public void setSessionData(boolean sessionData) {
		this.sessionData = sessionData;
	}



	public String getPasswordData() {
		return passwordData;
	}



	public void setPasswordData(String passwordData) {
		this.passwordData = passwordData;
	}



	public String getLoginData() {
		return loginData;
	}



	public void setLoginData(String loginData) {
		this.loginData = loginData;
	}

	
	
	
	

}
