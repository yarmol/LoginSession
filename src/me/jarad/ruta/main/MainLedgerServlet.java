package me.jarad.ruta.main;

import me.jarad.ruta.bean.*;
import me.jarad.ruta.gui.DateView;
import me.jarad.ruta.service.Log;
import me.jarad.ruta.dao.ServiceDao;
import me.jarad.ruta.domain.DocumentDomainObject;
import me.jarad.ruta.domain.TableWrapper;
















import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;












import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class CoreServlet
 */

@WebServlet(urlPatterns={"/ledger","/ledger/*"})
public class MainLedgerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainLedgerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Map<String, String[]> params 	= request.getParameterMap();
		  Log.writeLog(Level.SEVERE,"post: "+  new HashSet<String>(request.getParameterMap().keySet()).toString());
		  if ((params.size() > 0) && (params.get("new")[0].equals("+"))) {
			  HttpSession session 		  = request.getSession(true);
			  session.setAttribute("uuid", "qwe48d4a6sd54a6sd4asd");
	    	  session.setAttribute("dateOfToday", "26.08.2015");
	    	  session.setAttribute("numberNext", "0000000055");
	    	  session.setAttribute("notPassed", "false");
	    	  session.setAttribute("nullStatus", "CREATED");
	    	  DocumentDomainObject documentDomain = new DocumentDomainObject("qwe48d4a6sd54a6sd4asd");
	    	  
	    	  session.setAttribute("documentDomain",documentDomain); 
	    	  session.setAttribute("attributeCollections",documentDomain.getAttributeList()); 
	    	  getServletContext().getRequestDispatcher("/docNew.jsp").forward(request, response);
	      }   
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
   	    
	      HttpSession session 		  = request.getSession(true);
	      long timeOfSession 			  = session.getCreationTime();
	      SimpleDateFormat  dataFormat  = new SimpleDateFormat();
	      String dateView    			  = dataFormat.format(new Date(timeOfSession));
	      Map<String, String[]> params 	= request.getParameterMap();
		
	      ServiceDao serviceData = new ServiceDao(request);
	      serviceData.setHeader("∆урнал");
		
	      Log.writeLog(Level.SEVERE, "get: " +  new HashSet<String>(request.getParameterMap().keySet()).toString());
	      
	      if ((params.size() > 0) && (params.get("new")[0].equals("+"))) {
	    	  session.setAttribute("uuid", "qwe48d4a6sd54a6sd4asd");
	    	  session.setAttribute("dateOfToday", "26.08.2015");
	    	  session.setAttribute("numberNext", "0000000055");
	    	  session.setAttribute("notPassed", "false");
	    	  session.setAttribute("nullStatus", "CREATED");
	    	  getServletContext().getRequestDispatcher("/docNew.jsp").forward(request, response);
	      }
	      
	      //Logger.getLogger("ff").
		
		//реквизиты даты с-по
		Calendar cl = Calendar.getInstance();
		Date currentDate = new Date(cl.getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String currentDateString = formatter.format(currentDate);
		
		DateView date1 = new DateView("date_from","date_to","с ","max",currentDateString);
		DateView date2 = new DateView("date_to","date_from","по ","min",currentDateString);
		
		
		
		
		List<DateView> listDateEdit = new ArrayList<>();
		listDateEdit.add(date1);
		listDateEdit.add(date2);
		
		TreeSet<DocumentDomainObject> documentView = new TreeSet<>();
		Padding.paddingDocs(documentView);
		
		
		session.setAttribute("dateEditCollection", listDateEdit);
		
		TableWrapper<DocumentDomainObject> tableCollection = new TableWrapper<DocumentDomainObject>("RoutePlanner", documentView);
		 
	
		session.setAttribute("tableOfDocs", tableCollection);

		session.setAttribute("countOfPages", tableCollection.getPagesCount());
		
		
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		
	
		
		
		//AsyncContext
		
		/*UserLoginData userCredentials = null;
		
		PrintWriter outputWriter = response.getWriter();
	
		HttpSession currentSession = request.getSession(true);
		
				
		
		
		Enumeration<String> attributeNames = currentSession.getAttributeNames();
				if (attributeNames.hasMoreElements()) {
					String sessionAttrName = attributeNames.nextElement();
					outputWriter.write(sessionAttrName+"\n");
					userCredentials = (UserLoginData) currentSession.getAttribute(sessionAttrName);
					
				}
				
	
		//java.security.MessageDigest.getInstance("SHA-1")
				
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
