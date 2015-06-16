package br.eti.victorsoares.aula04.Model;

/**
 * Created by samuel on 16/06/15.
 */
public class ItensAmigos {

    private long cod_item;
    private long cod_amigo;
    private String nome_item;
    private String descricao_item;

    public long getCod_amigo() {
        return cod_amigo;
    }

    public void setCod_amigo(long cod_amigo) {
        this.cod_amigo = cod_amigo;
    }

    public long getCod_item() {
        return cod_item;
    }

    public void setCod_item(long cod_item) {
        this.cod_item = cod_item;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public String getDescricao_item() {
        return descricao_item;
    }

    public void setDescricao_item(String descricao_item) {
        this.descricao_item = descricao_item;
    }
}
