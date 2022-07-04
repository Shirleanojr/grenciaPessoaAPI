package br.com.xpto.gerenciaPessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.gerenciaPessoa.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByPessoaNome(String nome);

}
