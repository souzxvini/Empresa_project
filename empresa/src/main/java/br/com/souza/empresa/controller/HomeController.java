package br.com.souza.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.CargoRepository;
import br.com.souza.empresa.dao.FuncionarioRepository;
import br.com.souza.empresa.dao.UnidadeTrabalhoRepository;
import br.com.souza.empresa.model.Cargo;
import br.com.souza.empresa.model.Funcionario;
import br.com.souza.empresa.model.UnidadeTrabalho;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	@GetMapping
	public String home(Model model) {
		 return "home";
	}
	
	@GetMapping("/homeFuncionarios")
	public String homeFuncionarios(Model model) {
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		 model.addAttribute("funcionarios", funcionarios);
		 
		 return "/home/homeFuncionarios";
	}

	@GetMapping("/homeCargos")
	public String homeCargos(Model model) {
		
		List<Cargo> cargos = cargoRepository.findAll();
		 model.addAttribute("cargos", cargos);
		 
		 return "/home/homeCargos";
	}
	
	@GetMapping("/homeUnidadesTrabalho")
	public String homeUnidadesTrabalho(Model model) {
		
		List<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		 model.addAttribute("unidades", unidades);
		 
		 return "/home/homeUnidadesTrabalho";
	}
}
