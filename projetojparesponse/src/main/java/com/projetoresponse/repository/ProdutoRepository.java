package com.projetoresponse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoresponse.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}