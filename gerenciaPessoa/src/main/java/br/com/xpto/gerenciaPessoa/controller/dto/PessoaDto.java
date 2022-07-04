package br.com.xpto.gerenciaPessoa.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.xpto.gerenciaPessoa.model.Pessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private LocalDateTime dataNascimento;
	private List<EnderecoDto> enderecos;

	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	
	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecos = new ArrayList<>();
		this.enderecos.addAll(pessoa.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList()));
	}
	public static List<PessoaDto> converter(List<Pessoa> pessoa) {
		return pessoa.stream().map(PessoaDto::new).collect(Collectors.toList());
	}
}
