package br.com.tdv.springbootarchetype.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tdv.springbootarchetype.services.UsuarioService;
import br.com.tdvframework.beans.UsuarioWebLogado;

@Controller
@RequestMapping("/usuario/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired 
	private UsuarioService usuarioService;
	
	/**
	 * 
	 * @param usuario
	 * @param cnpj
	 * @param rota
	 * @param session
	 * @return String
	 * @throws SQLException
	 * 
	 */
	@RequestMapping(value = "/set/{usuario}/{cnpj}/{rota}", method = RequestMethod.GET)
	public String login(@PathVariable String usuario, @PathVariable String cnpj, @PathVariable String rota, String next, HttpSession session, HttpServletRequest request){
		logger.info( "login( "+usuario+", "+cnpj+", "+rota+" )..." );
		UsuarioWebLogado usuarioWebLogado = usuarioService.getUsuario(usuario, cnpj);
		session.setAttribute("usuarioLogado", usuarioWebLogado);
		session.setAttribute("connectionDetail", this.usuarioService.getConnectionDetail());
		if(next != null && next != ""){
			return "redirect:" + next;
		}else{
			return "redirect:/";
		}
	}

	/**
	 * 
	 * Destroy Session
	 * @param session
	 * @param model 
	 * @return String
	 * 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("content_page", "core/logout.jsp");
		return "index";
	}	
	
	
}
