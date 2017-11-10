package br.com.tdv.springbootarchetype.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tdv.springbootarchetype.services.CnpjService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CnpjService service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET,produces = { "application/json", "application/xml","text/html" })
	public ModelAndView home(Model model) {
		logger.info("home()...");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("content_page", "index-content.jsp");
		System.out.println(service.findAll().size());
		mv.addObject("cnpjs", service.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, Model model) {
		logger.info("logout()...");
		session.invalidate();
		model.addAttribute("content_page", "core/logout.jsp");
		return "index";
	}	
	
}
