package br.com.caspoke.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller) throws Exception {
		String uri = req.getRequestURI();
		/*if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources"))
			return true;
		
		if (req.getSession().getAttribute("usuarioLogado") != null)
			return true;
		
		res.sendRedirect("loginForm");
		return false;*/
		return true;
	}
}
