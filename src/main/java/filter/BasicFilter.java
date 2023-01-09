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

public class BasicFilter implements Filter {

	FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("BasicFilter -> init() 호출됨");
		
		String filterName = filterConfig.getFilterName();
		System.out.println("필터이름 : "+ filterName);		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BasicFilter -> doFilter() 호출됨");
		
		String filterInitParam = config.getInitParameter("FILTER_INIT_PARAM");
		System.out.println("초기화 매개변수 : "+ filterInitParam);
		
		String method = ((HttpServletRequest)request).getMethod();
		System.out.println("method="+ method);
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("BasicFilter -> destroy() 호출됨");
	}
}
