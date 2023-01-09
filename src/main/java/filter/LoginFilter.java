package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membership.MemberDAO;
import membership.MemberDTO;
import utils.JSFunction;

public class LoginFilter implements Filter {

	ServletContext application; 
			
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("LoginFilter -> init() 호출됨");
		application = filterConfig.getServletContext();			
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("LoginFilter -> doFilter() 호출됨");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		String oracleDriver = application.getInitParameter("OracleDriver");
		String oracleURL = application.getInitParameter("OracleURL");
		String oracleId = application.getInitParameter("OracleId");
		String oraclePwd = application.getInitParameter("OraclePwd");
						
		String method = req.getMethod();		
		if(method.equals("POST")) {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			String backUrl = request.getParameter("backUrl");

			MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
			MemberDTO memberDTO = dao.getMemberDTO(user_id, user_pw);
			dao.close();
			
			if (memberDTO.getId() != null) {
				session.setAttribute("UserId", memberDTO.getId()); 
				session.setAttribute("UserName", memberDTO.getName());
				if(backUrl!=null && !backUrl.equals("")) {
					resp.sendRedirect(backUrl);
				}
				else {
					resp.sendRedirect("../15FilterListener/TotalLogin.jsp");
				}
			}
			else {
				JSFunction.alertBack(resp, "로그인 실패");
				return;
			}
		}
		else if(method.equals("GET")) {			
			String mode = request.getParameter("mode");
			if(mode!=null && mode.equals("logout")) {
				session.invalidate();
			}
		}
		chain.doFilter(request, response);
	}

//	@Override
//	public void destroy() {
//		System.out.println("LoginFilter -> destroy() 호출됨");
//	}
}
