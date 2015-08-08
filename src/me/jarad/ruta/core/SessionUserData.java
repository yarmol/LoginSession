package me.jarad.ruta.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import me.jarad.ruta.bean.UserLoginData;
import me.jarad.ruta.dao.UserCredentialsDAO;

/**
 * 
 * Class SessionUser.
 * Encapsulate user login and hash password data.
 * Initiating DAO to check user creds.
 * 
 * @author vitaly
 * @date 06 рту. 2015 у.
 */
public class SessionUserData {
	
	private String userLogin;
	private String userPasswordHash;
	private String userID;
	
	
	public SessionUserData(UserLoginData userData) throws NoSuchAlgorithmException {
		
		this.userLogin = userData.getLoginData();
		
		MessageDigest cypherObject = java.security.MessageDigest.getInstance("SHA-1");
		cypherObject.reset();
		cypherObject.update(userData.getPasswordData().getBytes());
		this.userPasswordHash = new String(cypherObject.digest());
		
		//UserCredentialsDAO userDAO = new UserCredentialsDAO(this);
	
		
		
	}
}
