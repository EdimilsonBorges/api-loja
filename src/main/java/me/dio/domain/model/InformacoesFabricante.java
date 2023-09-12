package me.dio.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity(name = "tb_informacoes_fabricante")
public class InformacoesFabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String reputacao;
    private String historico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReputacao() {
        return reputacao;
    }

    public void setReputacao(String reputacao) {
        this.reputacao = reputacao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}
