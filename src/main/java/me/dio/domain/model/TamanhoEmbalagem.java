package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_tamanho_embalagem")
public class TamanhoEmbalagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String largura;
    @Column(nullable = false)
    private String altura;
    private String profundidade;
    @Column(nullable = false)
    private String peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(String profundidade) {
        this.profundidade = profundidade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
