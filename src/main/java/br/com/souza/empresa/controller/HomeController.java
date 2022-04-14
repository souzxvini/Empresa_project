package br.com.souza.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.CargoDAO;
import br.com.souza.empresa.dao.FuncionarioDAO;
import br.com.souza.empresa.dao.UnidadeTrabalhoDAO;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	@Autowired
	private CargoDAO cargoDAO;
	@Autowired
	private UnidadeTrabalhoDAO unidadeTrabalhoDAO;
	
	@GetMapping
	public String home(Model model) {
		
		 return "home";
	}

}
