package listener;

import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener, 
		HttpSessionListener, 
		HttpSessionAttributeListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {				
		Enumeration<String> apps = sce.getServletContext().getInitParameterNames();
		while(apps.hasMoreElements()) {
			System.out.println("[리스너]컨텍스트 초기화 매개변수 생성:"+ apps.nextElement());
		}	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
			Enumeration<String> apps = sce.getServletContext().getInitParameterNames();
			while(apps.hasMoreElements()) {
				System.out.println("[리스너]컨텍스트 초기화 매개변수 소멸:"+ apps.nextElement());
			}
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("[리스너]세션 생성:"+ se.getSession().getId());			
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("[리스너]세션 소멸:"+se.getSession().getId());
			 
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("[리스너]세션 추가:"+se.getName()+"="+se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("[리스너]세션 제거:"+se.getName()+"="+se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("[리스너]세션 변경:"+se.getName()+"="+se.getValue());
	}	
}