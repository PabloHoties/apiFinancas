package br.com.cotiinformatica.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contas.models.dtos.ContaRequest;
import br.com.cotiinformatica.domain.contas.models.dtos.ContaResponse;
import br.com.cotiinformatica.domain.contas.services.ContaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@PostMapping
	public ResponseEntity<ContaResponse> post(@RequestBody @Valid ContaRequest request) throws Exception {
		return ResponseEntity.status(201).body(contaService.criar(request));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ContaResponse> put(@PathVariable Integer id, @RequestBody @Valid ContaRequest request) throws Exception {
		return ResponseEntity.status(200).body(contaService.alterar(id, request));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ContaResponse> delete(@PathVariable Integer id) throws Exception {
		return ResponseEntity.status(200).body(contaService.excluir(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ContaResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(contaService.consultar());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ContaResponse> getById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.status(200).body(contaService.obterPorId(id));
	}
}
