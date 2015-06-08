package br.eti.victorsoares.aula04.Model;

import android.content.Context;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.eti.victorsoares.aula04.daos.UsuarioDAO;

/**
 * Created by VictorSoares on 21/05/2015.
 */
public class Usuario extends Pessoa implements Serializable {


    private long id;
    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.senha = new String(md.digest(senha.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoa(){
        return super.getId();
    }

    public void setIdPessoa(long id){
        super.setId(id);
    }



}
