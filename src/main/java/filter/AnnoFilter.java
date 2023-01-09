package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="AnnoFilter", urlPatterns={"/15FilterListener/AnnoFilter.jsp"})
public class AnnoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AnnoFilter -> init() 호출됨");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AnnoFilter -> doFilter() 호출됨");

		String method = ((HttpServletRequest)request).getMethod();
		System.out.println("method="+ method);
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("AnnoFilter -> destroy() 호출됨");
	}
}
