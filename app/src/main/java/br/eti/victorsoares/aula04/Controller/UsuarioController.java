package br.eti.victorsoares.aula04.Controller;

import android.content.Context;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import br.eti.victorsoares.aula04.Model.Pessoa;
import br.eti.victorsoares.aula04.Model.Usuario;
import br.eti.victorsoares.aula04.daos.AmizadeDAO;
import br.eti.victorsoares.aula04.daos.PessoaDAO;
import br.eti.victorsoares.aula04.smldao.UsuarioDAO;

/**
 * Created by vsoares on 01/06/15.
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private Context context;

    public UsuarioController(Context context) {
        this.context = context;
        usuarioDAO = new UsuarioDAO(context);
    }


    public Usuario login(Context context, String usuario, String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            senha = new String(md.digest(senha.getBytes()));
            Usuario u = (Usuario) usuarioDAO.login(usuario, senha);
            return u;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isUsuario(Context context, String usuario){

        Usuario u = (Usuario) usuarioDAO.get(usuario);

        return u != null;

    }

    public void insert(Usuario u) {
        usuarioDAO.insert(u);
    }

    public ArrayList<Object> getFriends(Usuario u){
        PessoaDAO pd = new PessoaDAO(context);
        return pd.getFriends(u);
    }

    public void addFriend(Usuario usuario, Pessoa pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO(context);
        pessoaDAO.insert(pessoa);
        AmizadeDAO amizadeDAO = new AmizadeDAO(context);
        amizadeDAO.insert(usuario, pessoa);

    }

    public void getAmigos(Usuario usuario){

    }

}
