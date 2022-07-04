package br.com.xpto.gerenciaPessoa.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.xpto.gerenciaPessoa.model.Pessoa;
import br.com.xpto.gerenciaPessoa.repository.PessoaRepository;

public class PessoaForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Pessoa converter() {
		return new Pessoa(this.nome, this.dataNascimento);
	}
	public Pessoa atualizar(Long id, PessoaRepository pessoaRep) {
		Pessoa pessoa = pessoaRep.getReferenceById(id);
		pessoa.setNome(this.nome);
		pessoa.setDataNascimento(LocalDateTime.parse(this.dataNascimento));
		return pessoa;
	}
	
	 
	
}
