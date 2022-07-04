package br.com.xpto.gerenciaPessoa.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.xpto.gerenciaPessoa.controller.dto.EnderecoDto;
import br.com.xpto.gerenciaPessoa.controller.form.EnderecoForm;
import br.com.xpto.gerenciaPessoa.model.Endereco;
import br.com.xpto.gerenciaPessoa.repository.EnderecoRepository;
import br.com.xpto.gerenciaPessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRep;
	
	@Autowired
	private PessoaRepository pessoaRep;

	@GetMapping
	public List<EnderecoDto> listar(@RequestParam String nome) {
		List<Endereco> endereco = enderecoRep.findByPessoaNome(nome);
		return EnderecoDto.converter(endereco);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder) {
		Endereco endereco = form.converter(pessoaRep);
		enderecoRep.save(endereco);
		
		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}
}
