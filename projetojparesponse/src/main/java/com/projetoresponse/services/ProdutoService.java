package com.projetoresponse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoresponse.entities.Produto;
import com.projetoresponse.repository.ProdutoRepository;


@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> getAllPRodutos() {
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto changeProduto(Long id, Produto changeProd) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			changeProd.setId(id);
			return produtoRepository.save(changeProd);
		}
		return null;
	}
	
	public boolean deleteProduto(Long id) {
		Optional <Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
