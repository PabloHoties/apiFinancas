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

import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.categorias.models.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.categorias.services.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<CategoriaResponse> post(@RequestBody @Valid CategoriaRequest request) throws Exception {
		return ResponseEntity.status(201).body(categoriaService.criar(request));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CategoriaResponse> put(@PathVariable Integer id,@RequestBody @Valid CategoriaRequest request) throws Exception {
		return ResponseEntity.status(200).body(categoriaService.alterar(id, request));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CategoriaResponse> delete(@PathVariable Integer id) throws Exception {
		return ResponseEntity.status(200).body(categoriaService.excluir(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(categoriaService.consultar());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CategoriaResponse> getById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.status(200).body(categoriaService.obterPorId(id));
	}
}
