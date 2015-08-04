package me.jarad.core;

import me.jarad.bean.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CoreServlet
 */

@WebServlet("/loginProcess")
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginData userCredentials = null;
		
		PrintWriter outputWriter = response.getWriter();
	
		HttpSession currentSession = request.getSession(true);
		
				
		
		
		Enumeration<String> attributeNames = currentSession.getAttributeNames();
				if (attributeNames.hasMoreElements()) {
					String sessionAttrName = attributeNames.nextElement();
					outputWriter.write(sessionAttrName+"\n");
					userCredentials = (UserLoginData) currentSession.getAttribute(sessionAttrName);
					
				}
				
		
				
		outputWriter.write(userCredentials.getLoginData());
		outputWriter.write("-");
		outputWriter.write(userCredentials.getPasswordData());
		
		CredentialChecker checker = new CredentialChecker(userCredentials);
		outputWriter.write("-");
		outputWriter.write(Boolean.valueOf(checker.checkAccess()).toString());
		/*
		if (!checker.checkAccess()) {
			getServletContext().getRequestDispatcher("/failed.html").forward(request, response);
		}
		else {
			outputWriter.write("Access granded");
		}*/

	}
}
