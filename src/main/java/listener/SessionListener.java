package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

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
