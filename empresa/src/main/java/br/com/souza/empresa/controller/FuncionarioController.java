package br.com.souza.empresa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.FuncionarioRepository;
import br.com.souza.empresa.dto.RequisicaoNovoFuncionario;
import br.com.souza.empresa.model.Funcionario;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("excluirFuncionario/{id}")
	public String excluirFuncionario(Funcionario funcionario ) {
		
			funcionarioRepository.deleteById(funcionario.getId());
		
		return "redirect:/home/homeFuncionarios";
	}
	
	@GetMapping("/formularioFuncionario")
	public String formularioFuncionario(RequisicaoNovoFuncionario requisicao, Model model) {
		return "funcionario/formularioFuncionario";
	}
	
	@PostMapping("/novoFuncionario")
	public String novoFuncionario(@Valid RequisicaoNovoFuncionario requisicao, BindingResult result ) {
		
		if(result.hasErrors()){
			return "/funcionario/formularioFuncionario";
		}
		
		Funcionario funcionario = requisicao.toFuncionario();
		funcionarioRepository.save(funcionario);
		return "redirect:/home/homeFuncionarios";
	}
	
	
	
	
}
