package br.com.souza.empresa.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.souza.empresa.model.Cargo;
import br.com.souza.empresa.model.Funcionario;
import br.com.souza.empresa.model.UnidadeTrabalho;

public class RequisicaoNovoFuncionario {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotNull
	private BigDecimal salario;
	
	@NotNull
	private Date dataContratacao;
	
	@NotNull
	private Cargo cargo;
	
	@NotNull
	private UnidadeTrabalho unidadeTrabalho;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public UnidadeTrabalho getUnidadeTrabalho() {
		return unidadeTrabalho;
	}

	public void setUnidadeTrabalho(UnidadeTrabalho unidadeTrabalho) {
		this.unidadeTrabalho = unidadeTrabalho;
	}
	
	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Funcionario toFuncionario() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setCargo(cargo);
		funcionario.setUnidadeTrabalho(unidadeTrabalho);
		funcionario.setDataContratacao(dataContratacao);
		
		return funcionario;
	}

	
	
	
}
