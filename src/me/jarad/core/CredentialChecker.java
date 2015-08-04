package me.jarad.core;

import me.jarad.bean.UserLoginData;

public class CredentialChecker {
	private UserLoginData userData;
	
	
	public CredentialChecker(UserLoginData userData) {
		this.userData = userData;
	}
	
	
	public boolean checkAccess() {
		if (userData == null) {
			return false;
		}

		//data base connection and cheking
		else if ((userData.getLoginData().toString().equals("admin")) && 
					(userData.getPasswordData().toString().equals("12345"))) {
			return true;
		}
		
		else {
			return false;
		}
			
		
		
		
		
	}
	

}
