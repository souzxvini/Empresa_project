package br.com.souza.empresa.dto;

import javax.validation.constraints.NotBlank;

import br.com.souza.empresa.model.UnidadeTrabalho;

public class RequisicaoNovaUnidadeTrabalho {

	@NotBlank
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public UnidadeTrabalho toUnidadeTrabalho() {
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setNome(nome);
		
		return unidadeTrabalho;
	}
}
