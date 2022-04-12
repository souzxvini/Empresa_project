package br.com.souza.empresa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	private String cpf;
	private Double salario;
	
	@Column(name="data_contratacao")
	private LocalDate dataContratacao;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "unidade_trabalho_id")
	private UnidadeTrabalho unidadeTrabalho;
	
	public Funcionario() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public LocalDate getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
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

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario
				+ ", dataContratacao=" + dataContratacao + ", cargo=" + cargo + ", unidadeTrabalho=" + unidadeTrabalho
				+ "]";
	}
	
	
	
	
}
