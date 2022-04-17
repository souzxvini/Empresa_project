package br.com.souza.empresa.dto;

import javax.validation.constraints.NotBlank;

import br.com.souza.empresa.model.Cargo;

public class RequisicaoNovoCargo {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String area;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public Cargo toCargo() {
		
		Cargo cargo = new Cargo();
		cargo.setNome(nome);
		cargo.setArea(area);
		
		return cargo;
	}

	
	
	
}
