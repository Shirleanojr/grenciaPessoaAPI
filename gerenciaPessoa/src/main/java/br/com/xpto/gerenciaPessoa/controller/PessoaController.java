package br.com.xpto.gerenciaPessoa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.xpto.gerenciaPessoa.controller.dto.PessoaDto;
import br.com.xpto.gerenciaPessoa.controller.form.PessoaForm;
import br.com.xpto.gerenciaPessoa.model.Pessoa;
import br.com.xpto.gerenciaPessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRep;
 
	@GetMapping
	public List<PessoaDto> listar(@RequestParam(required = false) String nome) {
		List<Pessoa> pessoa = null;
		if (nome == null) {
			pessoa = pessoaRep.findAll();
		} else {
			pessoa = pessoaRep.findByNome(nome);
		}
		return PessoaDto.converter(pessoa);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuider) {
		Pessoa  pessoa = form.converter();
		pessoaRep.save(pessoa);
		
		URI uri = uriBuider.path("/topicos/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> editar(@PathVariable Long id, @RequestBody @Valid PessoaForm form) {
		Optional<Pessoa> findById = pessoaRep.findById(id);
	 	if (findById.isPresent()) {
			Pessoa pessoa = form.atualizar(id, pessoaRep);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		return ResponseEntity.notFound().build();
	}
} 
