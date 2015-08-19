package me.jarad.ruta.main;

import me.jarad.ruta.bean.*;
import me.jarad.ruta.gui.DateView;
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
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;












import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CoreServlet
 */

@WebServlet("/ledger")
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
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session 		  = request.getSession(true);
		long timeOfSession 			  = session.getCreationTime();
		SimpleDateFormat  dataFormat  = new SimpleDateFormat();
		String dateView    			  = dataFormat.format(new Date(timeOfSession));
		Enumeration<String> params = request.getParameterNames();
		
		ServiceDao serviceData = new ServiceDao(request);
		serviceData.setHeader("∆урнал");
		
		
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
		
	/*	ObjectViewDescriptor docDescriptor = new ObjectViewDescriptor("RoutePlannig");
		TreeMap<Integer,String> docDescriptorContent = docDescriptor.getDescription();
		docDescriptorContent.put(1, "");
		
		ObjectViewDescriptorsCollection objDescriptorsCollection = ObjectViewDescriptorsCollection.addDescriptor(viewDescriptor);
	*/	
		
		
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
