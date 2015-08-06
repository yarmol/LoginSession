package me.jarad.ruta.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import me.jarad.ruta.bean.UserLoginData;

public class SessionUser {
	
	private String userLogin;
	private String userPasswordHash;
	private String userID;
	
	
	public SessionUser(UserLoginData userData) throws NoSuchAlgorithmException {
		
		this.userLogin = userData.getLoginData();
		
		MessageDigest cypherObject = java.security.MessageDigest.getInstance("SHA-1");
		cypherObject.reset();
		cypherObject.update(userData.getPasswordData().getBytes());
		
		this.userPasswordHash = new String(cypherObject.digest());
		
		
	}
}
