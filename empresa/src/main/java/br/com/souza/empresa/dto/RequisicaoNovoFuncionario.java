package br.com.souza.empresa.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.souza.empresa.dao.CargoRepository;
import br.com.souza.empresa.dao.FuncionarioRepository;
import br.com.souza.empresa.dao.UnidadeTrabalhoRepository;
import br.com.souza.empresa.model.Funcionario;

public class RequisicaoNovoFuncionario {

	private CargoRepository cargoRepository;
	private FuncionarioRepository funcionarioRepository;
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	@NotBlank
	private String Id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotNull
	private BigDecimal salario;
	
		@NotNull
	private Long cargoId;
	
		
	
	@NotNull
	private Long unidadeTrabalhoId;

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

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Long getUnidadeTrabalhoId() {
		return unidadeTrabalhoId;
	}

	public void setUnidadeTrabalhoId(Long unidadeTrabalhoId) {
		this.unidadeTrabalhoId = unidadeTrabalhoId;
	}

	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Funcionario toFuncionario() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		
		
		return funcionario;
	}

	
	
	
}
