package br.com.souza.empresa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.souza.empresa.dao.CargoRepository;
import br.com.souza.empresa.dto.RequisicaoNovoCargo;
import br.com.souza.empresa.model.Cargo;

@Controller
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping("/excluirCargo/{id}")
	public String excluirCargo(Cargo cargo ) {
		
			cargoRepository.deleteById(cargo.getId());
		
		return "redirect:/home/homeCargos";
	}
	
	@GetMapping("/formularioCargo")
	public String formularioCargo(RequisicaoNovoCargo requisicao) {
		return "cargo/formularioCargo";
	}
	
	@PostMapping("/novoCargo")
	public String novoCargo(@Valid RequisicaoNovoCargo requisicao, BindingResult result ) {
		
		if(result.hasErrors()){
			return "/cargo/formularioCargo";
		}
		
		Cargo cargo = requisicao.toCargo();
		cargoRepository.save(cargo);
		return "redirect:/home/homeCargos";
	}
	
}
