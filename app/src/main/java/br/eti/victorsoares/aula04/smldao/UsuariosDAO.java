package br.eti.victorsoares.aula04.smldao;

import java.util.ArrayList;

/**
 * Created by samuel on 09/06/15.
 */
public class UsuariosDAO implements modeloDAO{

    private AcessoDB acessoDB;

    protected static final String SCRIPT_CREATE = "CREATE TABLE Usuarios(" +
                                                "_cod_usuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                "login_usuario TEXT," +
                                                "nome_usuario TEXT," +
                                                "senha_usuario TEXT," +
                                                "email_usuario TEXT,"+
                                                "img_usuario BLOB";

    @Override
    public void insert(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public ArrayList<Object> get() {
        return null;
    }
}
