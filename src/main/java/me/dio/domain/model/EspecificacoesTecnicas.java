package me.dio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_especificacoes_tecnicas")
public class EspecificacoesTecnicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho;
    @Column(nullable = false)
    private String peso;
    private String cor;
    private String material;
    private String[] caracteristicas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
