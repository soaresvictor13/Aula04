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

    public static Usuario login(Context context, String usuario, String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            senha = new String(md.digest(senha.getBytes()));
            UsuarioDAO uDAO = new UsuarioDAO(context);
            Usuario u = (Usuario) uDAO.login(usuario, senha);
            return u;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isUsuario(Context context, String usuario){

        UsuarioDAO ud = new UsuarioDAO(context);

        Usuario u = (Usuario) ud.get(usuario);

        if(u != null) return true;

        return false;
    }


}
