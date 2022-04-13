package br.com.souza.empresa.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.CargoRepository;
import br.com.souza.empresa.dao.FuncionarioRepository;
import br.com.souza.empresa.dao.UnidadeTrabalhoRepository;
import br.com.souza.empresa.dto.RequisicaoNovoFuncionario;
import br.com.souza.empresa.model.Cargo;
import br.com.souza.empresa.model.Funcionario;
import br.com.souza.empresa.model.UnidadeTrabalho;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	@GetMapping("excluirFuncionario/{id}")
	public String excluirFuncionario(Funcionario funcionario ) {
		
			funcionarioRepository.deleteById(funcionario.getId());
		
		return "redirect:/home/homeFuncionarios";
	}
	
	@GetMapping("/formularioFuncionario")
	public String formularioFuncionario(RequisicaoNovoFuncionario requisicao, Model model) {
		
		Cargo cargo = new Cargo();
	    model.addAttribute("cargo", cargo);
		
		return "funcionario/formularioFuncionario";
	}
	
	@PostMapping("/novoFuncionario")
	public String novoFuncionario(@Valid RequisicaoNovoFuncionario requisicao, BindingResult result ) {
		
		Funcionario funcionario = requisicao.toFuncionario();
		
		Optional<Cargo> cargo = cargoRepository.findById(requisicao.getCargoId());
        funcionario.setCargo(cargo.get());
        
        Optional<UnidadeTrabalho> unidadeTrabalho = unidadeTrabalhoRepository.findById(requisicao.getUnidadeTrabalhoId());
        funcionario.setUnidadeTrabalho(unidadeTrabalho.get());
		funcionarioRepository.save(funcionario);
		return "redirect:/home/homeFuncionarios";
	}
	
	
	
	
}
