package me.dio.service;

import me.dio.domain.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();
    Produto findById(Long id);
    Produto create(Produto produto);
    void delete(Long id);

    boolean existsNome(String nome);
    boolean existsId(Long id);

}
