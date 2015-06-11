package br.eti.victorsoares.aula04.Model;

/**
 * Created by samuel on 10/06/15.
 */
public class Amigo {

    private Long cod_amigo;
    private String nome;
    private String imagem;
    private Long cod_usuario;

    public Long getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Long cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public void setCod_amigo(Long cod_amigo) {
        this.cod_amigo = cod_amigo;
    }

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

    public Long getCod_amigo() {
        return cod_amigo;
    }
}
