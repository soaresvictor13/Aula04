package br.eti.victorsoares.aula04.Model;

/**
 * Created by vsoares on 26/05/15.
 */
public class Categoria {

    private long id;
    private String descricao;
    private long cod_item;

    public long getCod_item() {
        return cod_item;
    }

    public void setCod_item(long cod_item) {
        this.cod_item = cod_item;
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
}
