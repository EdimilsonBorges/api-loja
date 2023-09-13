package me.dio.service;

import me.dio.domain.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();
    Produto findById(Long id);
    Produto create(Produto produto);

    Produto update(Produto produto, Long id);
    void delete(Long id);
    boolean existsNome(String nome);

}
