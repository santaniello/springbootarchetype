package br.com.tdv.springbootarchetype.interceptors;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthorizerInterceptor extends HandlerInterceptorAdapter {

	private final static Logger logger = LoggerFactory.getLogger(AuthorizerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		//  pagina login e acesso publico
		if(uri.contains("/usuario/login") || uri.contains("/usuario/getusuariosessao")) {
			logger.info(uri);
			return true;
		}	
		// arquivos estaticos
		if(uri.contains("/core/") || uri.contains("/plugins/") || uri.contains("/resources/") ) {
			return true;
		}
		// if usuario logado
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		} 
		logger.info(uri);
		response.sendRedirect(request.getContextPath()+"/usuario/login/logout?next="+uri);
		return false;
	}
}