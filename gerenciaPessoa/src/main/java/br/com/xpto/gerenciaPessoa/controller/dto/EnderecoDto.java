package br.com.xpto.gerenciaPessoa.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.xpto.gerenciaPessoa.model.Endereco;

public class EnderecoDto {

	private Long id;
	private String logradouro;
	private Long cep;
	private Long numero;
	private String cidade;
	private Integer principal;
	
	public Long getId() {
		return id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public Long getCep() {
		return cep;
	}
	public Long getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public Integer getPrincipal() {
		return principal;
	}
	
	public EnderecoDto(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.principal = endereco.getPrincipal();
	}
	public static List<EnderecoDto> converter(List<Endereco> endereco) {
		return endereco.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
	
	
}
