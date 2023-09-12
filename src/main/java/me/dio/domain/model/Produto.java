package me.dio.domain.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false, scale = 2)
    private Double preco;
    private String garantia;
    @Column(nullable = false)
    private String[] imagens;
    @Column(nullable = false)
    private String[] categorias;
    @OneToOne(cascade = CascadeType.ALL)
    private EspecificacoesTecnicas especificacoesTecnicas;
    @OneToOne(cascade = CascadeType.ALL)
    private Disponibilidade disponibilidade;
    @OneToOne(cascade = CascadeType.ALL)
    private InformacoesFabricante informacoesFabricante;
    @OneToOne(cascade = CascadeType.ALL)
    private TamanhoEmbalagem tamanhoEmbalagem;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoes;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }

    public String[] getCategorias() {
        return categorias;
    }

    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    public EspecificacoesTecnicas getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }

    public void setEspecificacoesTecnicas(EspecificacoesTecnicas especificacoesTecnicas) {
        this.especificacoesTecnicas = especificacoesTecnicas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public InformacoesFabricante getInformacoesFabricante() {
        return informacoesFabricante;
    }

    public void setInformacoesFabricante(InformacoesFabricante informacoesFabricante) {
        this.informacoesFabricante = informacoesFabricante;
    }

    public TamanhoEmbalagem getTamanhoEmbalagem() {
        return tamanhoEmbalagem;
    }

    public void setTamanhoEmbalagem(TamanhoEmbalagem tamanhoEmbalagem) {
        this.tamanhoEmbalagem = tamanhoEmbalagem;
    }
}
