package com.ceasa.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartNoProjeto {

	@GetMapping("/home")
	public String start(Model model) {
		model.addAttribute("message", "Olá seja bem vindo - Sistema DEVCEASA -  ambiente de testes");
		
		return "/testes/start";
		
	}
	
	@GetMapping("/css")
	public String css() {
				
		return "/testes/start-css-js-teste";
		
	}
	
	@GetMapping("/bootstrap")
	public String boot() {
				
		return "/testes/add-bootstrap.html";
		
	}

}
