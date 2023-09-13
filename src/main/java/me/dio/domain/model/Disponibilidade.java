package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_disponibilidade")
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private boolean emEstoque;
    @Column(nullable = false)
    private String dataEntregaEstimada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public String getDataEntregaEstimada() {
        return dataEntregaEstimada;
    }

    public void setDataEntregaEstimada(String dataEntregaEstimada) {
        this.dataEntregaEstimada = dataEntregaEstimada;
    }
}
