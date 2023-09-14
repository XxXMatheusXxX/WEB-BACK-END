package com.projetoresponse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoresponse.entities.Produto;
import com.projetoresponse.services.ProdutoService;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id) {
		Produto produto = produtoService.getProdutoById(id);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Produto>> buscaTodosProdutosControl() {
		List<Produto> produtos = produtoService.getAllPRodutos();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping("/")
	public ResponseEntity<Produto> saveProdutosControl(@RequestBody Produto produto) {
		Produto saveProduto = produtoService.saveProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduto);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto produto) {
		Produto alteraProduto = produtoService.changeProduto(id, produto);

		if (alteraProduto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProdutoControl(@PathVariable Long id) {
		boolean delete = produtoService.deleteProduto(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
}
