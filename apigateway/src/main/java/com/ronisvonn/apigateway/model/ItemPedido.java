package com.ronisvonn.apigateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "itempedido")
public class ItemPedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "numero", referencedColumnName = "numero", nullable = false)
    @JsonIgnore
    private Pedido numero;

    @Column(nullable = false)
    private Integer indice;

    private String sku;
    private String produto;
    private Double preco;
    private Integer quantidade;

    // Construtores
    public ItemPedido() {
    }

    public ItemPedido(Integer indice, String sku, String produto, Double preco, Integer quantidade) {
        this.indice = indice;
        this.sku = sku;
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getNumero() {
        return numero;
    }

    public void setNumero(Pedido numero) {
        this.numero = numero;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getSKU() {
        return sku;
    }

    public void setSKU(String sku) {
        this.sku = sku;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}