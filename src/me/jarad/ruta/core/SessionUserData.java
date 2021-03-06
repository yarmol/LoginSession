package me.jarad.ruta.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import me.jarad.ruta.bean.UserLoginData;
import me.jarad.ruta.dao.UserCredentialsDAO;

/**
 * 
 * Class SessionUser.
 * Encapsulate user login and hash password data.
 * Initiating DAO to check user creds.
 * 
 * @author vitaly
 * @date 06 ���. 2015 �.
 */
public class SessionUserData {
	
	private String userLogin;
	private String userPasswordHash;
	private String userID;
	private HttpSession currentSession;
	
	public SessionUserData(UserLoginData userData, HttpSession currentSession) throws NoSuchAlgorithmException {
		
		this.userLogin = userData.getLoginData();
		
		//System.out.println("userLogin="+userLogin);
		
		MessageDigest cypherObject = java.security.MessageDigest.getInstance("SHA-1");
		cypherObject.reset();
		cypherObject.update(userData.getPasswordData().getBytes());
		this.userPasswordHash = new String(cypherObject.digest());
		this.currentSession = currentSession;
		
		//System.out.println("this.userPasswordHash="+userPasswordHash);
		//System.out.println("this.getPasswordData="+userData.getPasswordData());
	}
	
	public void setUserData() {
		currentSession.setAttribute("userId", userLogin);
		currentSession.setAttribute("userPasswordHash", userPasswordHash);
	}
	
	
}
