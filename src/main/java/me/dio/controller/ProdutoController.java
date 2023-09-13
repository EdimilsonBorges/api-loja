package me.dio.controller;

import me.dio.domain.model.Produto;
import me.dio.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this. produtoService = produtoService;
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> create(@RequestBody Produto produtoToCreate){
        produtoService.create(produtoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoToCreate.getId()).toUri();

        return ResponseEntity.created(location).body(produtoToCreate);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> findById(@PathVariable("id") Long id){
        Produto produto = produtoService.findById(id);

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/produto/{id}")
    public void update(@RequestBody Produto produtoToUpdate, @PathVariable("id") Long id){
        produtoService.update(produtoToUpdate, id);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable("id") Long id){
       produtoService.delete(id);
    }
}
