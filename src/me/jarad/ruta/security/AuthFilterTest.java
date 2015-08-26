package me.jarad.ruta.security;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.jarad.ruta.bean.UserLoginData;
import me.jarad.ruta.core.SessionUserData;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, servletNames = { "NO" })
public class AuthFilterTest implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilterTest() {
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

		HttpSession currentSession = ((HttpServletRequest) request).getSession(false);
		
		System.out.println(currentSession==null);
		
		//;
		
		/*
	
		HttpSession currentSession = ((HttpServletRequest) request).getSession(true);
		UserLoginData userCredentials = (UserLoginData) currentSession.getAttribute("loginForm");
		
		System.out.println("doFilter");
		
		request.setAttribute("loginForm", null);
		
		
		
		try {
			SessionUserData sessionUser = new SessionUserData(userCredentials, currentSession);
			sessionUser.setUserData();
			
			currentSession.getServletContext().getRequestDispatcher("/ledger").forward(request,response);
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} */
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
