package br.com.souza.empresa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.empresa.model.Funcionario;

@Repository
public interface FuncionarioDAO extends JpaRepository<Funcionario, Long> {

}
