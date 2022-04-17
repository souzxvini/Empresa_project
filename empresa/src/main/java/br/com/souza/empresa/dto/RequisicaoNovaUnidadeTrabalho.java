package br.com.souza.empresa.dto;

import javax.validation.constraints.NotBlank;

import br.com.souza.empresa.model.UnidadeTrabalho;

public class RequisicaoNovaUnidadeTrabalho {

	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public UnidadeTrabalho toUnidadeTrabalho() {
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setNome(nome);
		unidadeTrabalho.setEndereco(endereco);
		return unidadeTrabalho;
	}
}
