package br.com.souza.empresa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.empresa.model.UnidadeTrabalho;

@Repository
public interface UnidadeTrabalhoDAO extends JpaRepository<UnidadeTrabalho, Long>{

}
