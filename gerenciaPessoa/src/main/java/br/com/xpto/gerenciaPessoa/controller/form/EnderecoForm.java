package br.com.xpto.gerenciaPessoa.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.xpto.gerenciaPessoa.model.Endereco;
import br.com.xpto.gerenciaPessoa.model.Pessoa;
import br.com.xpto.gerenciaPessoa.repository.PessoaRepository;

public class EnderecoForm {
	
	@NotNull @NotEmpty
	private String logradouro;
	
	@NotNull @NotEmpty
	private Long cep;
	
	@NotNull @NotEmpty
	private Long numero;

	@NotNull @NotEmpty
	private String cidade;
	
	@NotNull @NotEmpty
	private Integer principal;
	
	@NotNull @NotEmpty
	private Long pessoaId;

	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Integer getPrincipal() {
		return principal;
	}
	public void setPrincipal(Integer principal) {
		this.principal = principal;
	}
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public Endereco converter(PessoaRepository repository) {
		Optional<Pessoa> pessoa = repository.findById(this.pessoaId);
		return new Endereco(this.logradouro, this.cep, this.numero, this.cidade, this.principal, pessoa.get());
	}
	
	
	
	

}
