package me.jarad.ruta.security;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import me.jarad.ruta.bean.UserLoginData;
import me.jarad.ruta.domain.UserDomain;
import me.jarad.ruta.service.Log;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
		 , urlPatterns = { "/login" })
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	    
   	    HttpSession currentSession = ((HttpServletRequest)request).getSession(false);
	
   	    if (!(currentSession == null)) {
	   		Log.writeLog(Level.SEVERE, "User: ");  
		 
	   		UserLoginData userCredentials = (UserLoginData) currentSession.getAttribute("loginForm");
	   		
	   		CredentialsChecker userChecker = new CredentialsChecker(userCredentials);
	   		AccessLevel accessCheckingResult = userChecker.checkUser();
	   		
	   		if (accessCheckingResult == AccessLevel.DENIED) {
	   			HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper((HttpServletRequest) request);
	   			HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper((HttpServletResponse) response);
	   			Log.writeLog(Level.SEVERE, accessCheckingResult.toString());  
	   			//currentSession.setAttribute("errorMessage", "Access is denied. User name is wrong" );
	   			//wrappedResponse.sendRedirect(wrappedRequest.getContextPath() + "/error.jsp");
	   			wrappedResponse.sendError(401, "Access is denied. User name is wrong");
	   		}
	   		else {
	   			UserDomain user = new UserDomain(userCredentials,accessCheckingResult);
	   			currentSession.setAttribute("user",user);
	   		}
	   		
	   		
	   	}
	   	
	   	    
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
