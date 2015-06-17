package br.eti.victorsoares.aula04.Model;

import java.io.Serializable;

/**
 * Created by vsoares on 26/05/15.
 */
public class Item implements Serializable{
    private long id;
    private String descricao;
    private String nome;
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
