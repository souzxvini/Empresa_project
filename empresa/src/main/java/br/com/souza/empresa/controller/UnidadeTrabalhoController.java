package br.com.souza.empresa.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.UnidadeTrabalhoRepository;
import br.com.souza.empresa.dto.RequisicaoNovaUnidadeTrabalho;
import br.com.souza.empresa.model.Cargo;
import br.com.souza.empresa.model.UnidadeTrabalho;

@Controller
@RequestMapping("/unidadeTrabalho")
public class UnidadeTrabalhoController {
	
	@Autowired
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	@GetMapping("excluirUnidadeTrabalho/{id}")
	public String excluirUnidadetrabalho(UnidadeTrabalho unidade ) {
			unidadeTrabalhoRepository.deleteById(unidade.getId());
		return "redirect:/home/homeUnidadesTrabalho";
	}
	
	@GetMapping("/formularioUnidadeTrabalho")
	public String formularioUnidadeTrabalho(RequisicaoNovaUnidadeTrabalho requisicao) {
		return "unidadeTrabalho/formularioUnidadeTrabalho";
	}
	
	@PostMapping("/novaUnidadeTrabalho")
	public String novaUnidadeTrabalho(@Valid RequisicaoNovaUnidadeTrabalho requisicao, BindingResult result ) {
		
		if(result.hasErrors()){
			return "/unidadeTrabalho/formularioUnidadeTrabalho";
		}
		
		UnidadeTrabalho unidade = requisicao.toUnidadeTrabalho();
		unidadeTrabalhoRepository.save(unidade);
		return "redirect:/home/homeUnidadesTrabalho";
	}
	
	@GetMapping("/atualizarUnidadeTrabalho/{id}")
	public String atualizarUnidadeTrabalho(@PathVariable("id")  Long id, Model model) {
		Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(id);

		if (unidade.isEmpty()) {
			throw new IllegalArgumentException("Pedido inválido");
		} else {
			model.addAttribute("unidadeTrabalho", unidade);
		}
		return "unidadeTrabalho/formularioEditarUnidadeTrabalho";
	}
	
	@PostMapping("/atualizar")
	public String atualizar(UnidadeTrabalho unidadeTrabalho, BindingResult result) {
	
		if(result.hasErrors()) {
			return "cargo/formularioEditarCargo.html";
		}else {
			unidadeTrabalhoRepository.save(unidadeTrabalho);
			return "redirect:/home/homeUnidadesTrabalho"	;
		}
		
	}
	
}
