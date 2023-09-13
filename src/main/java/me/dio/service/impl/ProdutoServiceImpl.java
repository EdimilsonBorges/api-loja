package me.dio.service.impl;

import me.dio.controller.handler.BusinessException;
import me.dio.controller.handler.NotFoundException;
import me.dio.domain.model.Produto;
import me.dio.domain.repository.ProdutoRepository;
import me.dio.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Produto update(Produto produtoToUpdate, Long id) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoToUpdate.getNome());
            produto.setDescricao(produtoToUpdate.getDescricao());
            produto.setPreco(produtoToUpdate.getPreco());
            produto.setGarantia(produtoToUpdate.getGarantia());
            produto.setImagens(produtoToUpdate.getImagens());
            produto.setCategorias(produtoToUpdate.getCategorias());
            produto.setEspecificacoesTecnicas(produtoToUpdate.getEspecificacoesTecnicas());
            produto.setDisponibilidade(produtoToUpdate.getDisponibilidade());
            produto.setInformacoesFabricante(produtoToUpdate.getInformacoesFabricante());
            produto.setTamanhoEmbalagem(produtoToUpdate.getTamanhoEmbalagem());
            produto.setAvaliacoes(produtoToUpdate.getAvaliacoes());
            // Você pode atualizar outros campos aqui conforme necessário

            return produtoRepository.save(produto);
        } else {
            throw new NotFoundException("Produto não encontrado com ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            produtoRepository.deleteById(id);
        }else {
            throw new NotFoundException("Produto com o ID ("+id+") não foi encontrado");
        }
    }

    @Override
    public boolean existsNome(String nome) {
        return produtoRepository.existsByNome(nome);

    }

}
