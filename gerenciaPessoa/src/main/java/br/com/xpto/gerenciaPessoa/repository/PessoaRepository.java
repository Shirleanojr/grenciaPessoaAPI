package br.com.xpto.gerenciaPessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.gerenciaPessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	List<Pessoa> findByNome(String nome);

}
