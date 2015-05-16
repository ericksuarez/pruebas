package kinetic.dream;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import entidades.one_one.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.api.server.spi.response.CollectionResponse;

@SuppressWarnings("serial")
public class Kinetic_dream_866Servlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/plain");
		resp.getWriter().println("Test");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		
		Employee e = new Employee("Perenganota", "aaaaaa");
		
		Key k = KeyFactory.createKey(ContactInfo.class.getSimpleName(), "5");
		ContactInfo ci = new ContactInfo("su direccion");
		ci.setKey(k);
		
		e.setContactInfo(ci);
		pm.makePersistent(e);

		
		EmployeeEndpoint eep = new EmployeeEndpoint();
		List<Employee> empleados = eep.listEmployee(null, null);
		for(Employee es: empleados){
			resp.getWriter().println(es.getKey());
			resp.getWriter().println(es.getNombre());
			resp.getWriter().println(es.getApellido());
			resp.getWriter().println(es.getContactInfo());
		}
		
		/*Employee em = getEmployee();
		resp.getWriter().println("Get emepleado");
		resp.getWriter().println(em.getNombre() + "-" + em.getApellido() + "-" + em.getContactInfo());
		ContactInfo eci = new ContactInfo(null);
		resp.getWriter().println("Get Contacto");
		eci = em.getContactInfo();
		resp.getWriter().println(eci.getStreetAddress());*/
		
		/*
		 * UserService userService = UserServiceFactory.getUserService();
		 * 
		 * String thisURL = req.getRequestURI();
		 * 
		 * resp.setContentType("text/html"); if (req.getUserPrincipal() != null)
		 * { resp.getWriter().println("<p>Hello, " +
		 * req.getUserPrincipal().getName() + "!  You can <a href=\"" +
		 * userService.createLogoutURL(thisURL) + "\">sign out</a>.</p>"); }
		 * else { resp.getWriter().println("<p>Please <a href=\"" +
		 * userService.createLoginURL(thisURL) + "\">sign in</a>.</p>"); }
		 */

	}
	
	public Employee getEmployee() {
	    PersistenceManager pm = PMF.get().getPersistenceManager();
	    Employee employee, detached = null;
	    try {
	        employee = pm.getObjectById(Employee.class,"2");
	        detached = pm.detachCopy(employee);
	    } finally {
	        pm.close();
	    }
	    return detached;
	}

}
