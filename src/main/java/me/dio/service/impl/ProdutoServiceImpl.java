package me.dio.service.impl;

import me.dio.controller.handler.BusinessException;
import me.dio.controller.handler.NotFoundException;
import me.dio.domain.model.Produto;
import me.dio.domain.repository.ProdutoRepository;
import me.dio.service.ProdutoService;
import org.apache.logging.log4j.util.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    @Override
    public Produto create(Produto produtoToCreated) {

        if(produtoToCreated.getNome() == null || produtoToCreated.getDescricao() == null || produtoToCreated.getImagens() == null || produtoToCreated.getPreco() == null){
            throw new BusinessException("Os campos de nome, descrição e preço são obrigatórios");
        }
        if(existsNome(produtoToCreated.getNome())){
           throw new BusinessException("O produto (" + produtoToCreated.getNome() + ") já existe");
        }
        return produtoRepository.save(produtoToCreated);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public boolean existsNome(String nome) {
        return produtoRepository.existsByNome(nome);

    }

    @Override
    public boolean existsId(Long id) {
        return produtoRepository.existsById(id);
    }

}
