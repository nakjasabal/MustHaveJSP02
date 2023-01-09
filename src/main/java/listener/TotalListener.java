package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TotalListener {
	
}

class SRListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed() 호출됨");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized() 호출됨");
	}
} 
class SRAListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("attributeAdded() 호출됨");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("attributeRemoved() 호출됨");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("attributeReplaced() 호출됨");
	}
}


class HSListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated() 호출됨");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed() 호출됨");
	}
} 
class HSAListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("attributeAdded() 호출됨");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("attributeRemoved() 호출됨");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("attributeReplaced() 호출됨");
	}	
} 


class SCListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed() 호출됨");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized() 호출됨");
	}
}
class SCAListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("attributeAdded() 호출됨");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("attributeRemoved() 호출됨");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("attributeReplaced() 호출됨");
	}
} 
