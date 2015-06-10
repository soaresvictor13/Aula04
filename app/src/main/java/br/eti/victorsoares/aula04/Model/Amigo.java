package br.eti.victorsoares.aula04.Model;

import java.sql.Blob;

/**
 * Created by samuel on 10/06/15.
 */
public class Amigo {

    private Integer cod_amigo;
    private String nome;
    private String imagem;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCod_amigo() {
        return cod_amigo;
    }
}
